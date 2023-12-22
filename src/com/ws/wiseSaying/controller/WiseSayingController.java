package com.ws.wiseSaying.controller;

import java.util.List;

import com.ws.Container;
import com.ws.Rq;
import com.ws.wiseSaying.entity.WiseSaying;
import com.ws.wiseSaying.service.WiseSayingService;

public class WiseSayingController {

	private WiseSayingService wiseSayingService;

	public WiseSayingController() {
		wiseSayingService = new WiseSayingService(); //와이드서비스 객체 생성
	}

	public void write() {
		System.out.print("명언 : "); // 명언 스캐너로 생성
		String content = Container.getScanner().nextLine().trim();
		System.out.print("작가 : "); // 작가 스캐너로 생성
		String author = Container.getScanner().nextLine().trim();

		int id = wiseSayingService.write(content, author); // 쓴 내용을 서비스로 이관

		System.out.printf("%d번 명언이 등록되었습니다.\n", id); //결과 출력
	}

	public void list() {
		List<WiseSaying> wiseSayings = wiseSayingService.findAll(); // 목록 내용 자료를 가져옴

		System.out.println("번호  /  작가  /  명언  "); //텍스트 출력
		System.out.println("=".repeat(30));

		for (int i = wiseSayings.size() - 1; i >= 0; i--) { //조건문을 이용해서 내용 전체를 출력함
			WiseSaying ws = wiseSayings.get(i);

			System.out.printf("%d  /  %s  /  %s\n", ws.getId(), ws.getAuthor(), ws.getContent());
		}
	}

	public void remove(Rq rq) {

		int id = rq.getIntParam("id", -1); //초기값

		if (id == -1) {  //숫자가 없을시
			System.out.println("id(정수)를 제대로 입력해주세요");
			return;
		}
		// 입력된 id와 일치하는 명언 객체 찾기
		WiseSaying wiseSaying = wiseSayingService.findById(id); // 서비스를 거쳐 내용확인

		if (wiseSaying == null) { //null시 명언 미존재
			System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
			return;
		}

		// 찾은 명언 객체를 object기반으로 삭제
		wiseSayingService.remove(wiseSaying); //find id를 이용해 삭제

		System.out.printf("%d번 명언이 삭제되었습니다.\n", id);

	}

	public void modify(Rq rq) {
		int id = rq.getIntParam("id", -1);

		if (id == -1) {
			System.out.println("id(정수)를 제대로 입력해주세요");
			return;
		}
		// 입력된 id와 일치하는 명언 객체 찾기
		WiseSaying wiseSaying = wiseSayingService.findById(id);

		if (wiseSaying == null) {
			System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
			return;
		}

		// 찾은 명언 객체를 object기반으로 수정
		System.out.println("명언(기존) :" + wiseSaying.getContent());
		System.out.println("작가(기존) :" + wiseSaying.getAuthor());

		System.out.print("명언 : ");
		String content = Container.getScanner().nextLine().trim();
		System.out.print("작가 : ");
		String author = Container.getScanner().nextLine().trim();

		wiseSayingService.modify(wiseSaying, content, author);

		System.out.printf("%d번 명언이 수정되었습니다.\n", id);

	}

}