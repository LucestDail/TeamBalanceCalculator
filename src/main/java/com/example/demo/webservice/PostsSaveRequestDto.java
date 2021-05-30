package com.example.demo.webservice;

import com.example.demo.domain.Posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
// ConTroller -> @RequestBody 로 외부에서 데이터 받는 경우엔 기본생성자 + set메소드 통해서만 값이 할
@NoArgsConstructor
public class PostsSaveRequestDto {

	private String title;
	private String content;
	private String author;
	
	@Builder
	public PostsSaveRequestDto(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
	public Posts toEntity() {
		System.out.println(Posts.builder().title(title).content(content).author(author).build());
		return Posts.builder()
				.title(title)
				.content(content)
				.author(author)
				.build();
	}
	
}
