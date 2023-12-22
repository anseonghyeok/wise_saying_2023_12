package com.ws.wiseSaying.repository;

import java.util.ArrayList;
import java.util.List;

import com.ws.wiseSaying.entity.WiseSaying;

public class WiseSayingRepository {

	private int lastWiseSayingId;
	private List<WiseSaying> wiseSayings;

	public WiseSayingRepository() {

		lastWiseSayingId = 0; //명언의 아이디의 초기 셋팅값
		wiseSayings = new ArrayList<>(); //어레이 리스트 저장소 와일즈세이의 저장장소
	}

	public void remove(WiseSaying wiseSaying) { //매서드 와일즈 세이스의 접근해 명언을 지운다
		wiseSayings.remove(wiseSaying);
	}

	public WiseSaying findById(int id) {  //명언과 와일즈세일스와 아이디값이 같으면 와일즈세이스의 아디를 가져옴
		for (WiseSaying wiseSaying : wiseSayings) {
			if (wiseSaying.getId() == id) {
				return wiseSaying;
			}
		}

		return null;
	}
	//컨트롤러에서 서비스를 거쳐 온값을 넣음 수정매서드를 작동시킴 이건 와일즈 세이 안에있음
	public void modify(WiseSaying wiseSaying, String content, String author) { 
		wiseSaying.setContent(content);
		wiseSaying.setAuthor(author);
	}
	
	
	//실행 매서드 실행시 초기값 id를 +1해서 아이디에 넣고 받은 스트링 값을 집어넣음
	//이때 와이즈 세이 타입의 와일즈세이가 생기며 이 내용은 모두 저장된 내용을 받아서 
	//와일즈 세이즈 어레이리스트에 add로 저장됨 마지막 id는 id로 저장되며 다시 id로
	//리턴 받아서 0에서 1 나중에 1이 +1 2이런식으로 배열 순차으로 id에 넣어줌
	
	public int write(String content, String author) {
		int id = lastWiseSayingId + 1;

		WiseSaying wiseSaying = new WiseSaying(id, content, author);
		wiseSayings.add(wiseSaying);

		lastWiseSayingId = id; // 방금 전에 새 명언이 생겼으니, lastWiseSayingId의 값을 갱신

		return id;
	}

	// 와이즈세잉 리스트 모두 찾는 매서드 
	public List<WiseSaying> findAll() {
		return wiseSayings;
	}

}