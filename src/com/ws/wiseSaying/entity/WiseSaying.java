package com.ws.wiseSaying.entity;

public class WiseSaying {
	private int id; //번호
	private String content; //내용
	private String author; //작가

	public WiseSaying(int id, String content, String author) { //설계도
		this.id = id;
		this.content = content;
		this.author = author;
	}

	public int getId() { //id 생성 매서드
		return id;
	}

	public void setId(int id) { //id 수정 매서드
		this.id = id;
	}

	public String getContent() { //컨텐트 생성 매서드
		return content;
	}

	public void setContent(String content) { //컨텐트 수정 매서드
		this.content = content;
	}

	public String getAuthor() { //작가 생성 매서드 
		return author;
	}

	public void setAuthor(String author) { // 작가 수정 매서드
		this.author = author;
	}

}