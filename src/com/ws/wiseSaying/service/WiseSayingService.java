package com.ws.wiseSaying.service;

import java.util.List;

import com.ws.wiseSaying.entity.WiseSaying;
import com.ws.wiseSaying.repository.WiseSayingRepository;

public class WiseSayingService {

	private WiseSayingRepository wiseSayingRepository;

	public WiseSayingService() {

		wiseSayingRepository = new WiseSayingRepository(); // 명언 저장소 객체 생성
	}

	public List<WiseSaying> findAll() { // 명언의 자료를 가져옴
		return wiseSayingRepository.findAll();
	}

	public int write(String content, String author) { // 컨트롤러의 명령을 받아 저장소에 내용을 넣음

		return wiseSayingRepository.write(content, author);
	}

	public WiseSaying findById(int id) { // 컨트롤러의 명령을 받아 저장소에서 아이디를 찾는다
		return wiseSayingRepository.findById(id);
	}

	public void remove(WiseSaying wiseSaying) { // 컨트롤러의 명령을 받아 저장소에서 내용삭제
		wiseSayingRepository.remove(wiseSaying);
	}

	public void modify(WiseSaying wiseSaying, String content, String author) { // 컨트롤러의 명령을 받아 저장소에서 수정
		wiseSayingRepository.modify(wiseSaying, content, author);

	}

}