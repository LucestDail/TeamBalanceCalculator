package com.example.demo.webservice;

import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Posts;
import com.example.demo.domain.PostsRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {
	
	private PostsRepository postsRepository;
	/**
	 * riot api checking / validator from riot developer api checker
	 * @return
	 */
	@RequestMapping("/riot.txt")
	@ResponseBody
	public String riot() {
		return "5271dbcd-d91f-44a5-a47a-117c1de87770";
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello, World!";
	}
	
	@PostMapping("/posts")
	public void savePosts(@RequestBody PostsSaveRequestDto dto) {
		System.out.println("WebRestController savePosts activated");
		postsRepository.save(dto.toEntity());
		System.out.println(dto.getAuthor() + dto.getContent() + dto.getTitle());
	}
	
	@PostMapping("/delete")
	public void deletePosts(@RequestBody PostsDeleteRequestDto dto) {
		System.out.println("WebRestController deletePosts activated");
		try {
			Optional<Posts> posts = postsRepository.findById(dto.getId());
			System.out.println(posts.get().getId());
			postsRepository.deleteById(posts.get().getId());
		}catch(EmptyResultDataAccessException e){
			System.out.println(dto.getId() + " is not exist");
		}
	}
	
	@PostMapping("/update")
	public void updatePosts(@RequestBody PostsUpdateRequestDto dto) {
		System.out.println("WebRestController deletePosts activated");
		System.out.println("request data : " + dto.getId() + "," +dto.getAuthor() + "," +  dto.getContent() + dto.getTitle());
		try{
			Optional<Posts> posts = postsRepository.findById(dto.getId());
			System.out.println(dto.getId() + " -> "+posts.get());
			Long id = posts.get().getId();
			String author = dto.getAuthor();
			String content = dto.getContent();
			String title = dto.getTitle();
			postsRepository.update(id,author,content,title);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(dto.getId() + " -> not exist");
		}
	}
	
}
