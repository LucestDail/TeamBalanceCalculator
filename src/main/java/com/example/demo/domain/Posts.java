package com.example.demo.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Posts extends BaseTimeEntity{
	/**
	 * 실제 DB 테이블과 매칭될 클래스, Entity 클래스라고 명칭
	 * JPA 사용시 DB 데이터 작업할 경우 실제 쿼리 날리기보다는 이 Entity 수정을 통해서 작업
	 * JPA 제공하는 어노테이션 소개
	 * @Entity : 테이블과 링크될 클래스 명시, 언더스코어 네이밍으로 이름 매칭
	 * @Id :PK 테이블 필드 명시
	 * @GeneratedValue : PK 생성 규칙, 스프링 부트 2.0부터는 옵션 추가해야 auto_increment(strategy = GenerationType.IDENTITY)
	 * @Column : 테이블의 컬럼 명시, 기본값 외 추가로 변경 필요한 옵션이 있을 경우 명시(예 = varchar(255) 가 문자열 기본값이나, 사이즈를 늘리고 싶은 경우 등)
	 * 
	 */
	
	/**
	 * Lombok 라이브러리 어노테이션
	 * 사용하는 이유 : 서비스 구축 단계에서 테이블 설계가 빈번하게 변경되므로, 코드 변경량을 최소하하기 때문에 강력 추천!!!
	 * 
	 * @NoArgsConstructor : 기본 생성자 자동 추가 어노테이션, 접근 권한 설정 가능
	 * @Getter :  클래스 내 모든 필드의 Getter 메소드 자동 생성
	 * @Builder : 해당 클래스 빌더패턴 클래스 생성(생성자 상단에 선언시 생성자에 포함된 필드만 빌더 포함)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/**
	 * 가능하면 PK 값은 Long 타입의 Auto_increment 추천
	 */
	private Long id;
	
	@Column(length = 500, nullable = false)
	private String title;
	
	@Column(columnDefinition = "text", nullable = false)
	private String content;
	
	private String author;
	
	@Builder
	public Posts(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
	@Builder
	public Posts(Long id) {
		this.id = id;
	}
	
	@Builder
	public Posts(Long id, String content, String author, String title) {
		this.id = id;
		this.content = content;
		this.title = title;
		this.author = author;
	}

	@Override
	public String toString() {
		return "Posts [id=" + id + ", title=" + title + ", content=" + content + ", author=" + author + "]";
	}
	
	
}
