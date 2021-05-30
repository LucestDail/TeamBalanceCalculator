package com.example.demo.webservice;

import com.example.demo.domain.Posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostsUpdateRequestDto {
	
	private Long id;
	private String content;
	private String author;
	private String title;
	
	@Builder
	public PostsUpdateRequestDto(Long id, String content, String author, String title) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.content = content;
	}
	
	public Posts toEntity() {
		return Posts.builder().id(id)
				.content(content)
				.author(author)
				.title(title)
				.build();
	}

	@Override
	public String toString() {
		return "PostsUpdateRequestDto [id=" + id + ", content=" + content + ", author=" + author + ", title=" + title
				+ "]";
	}

}
