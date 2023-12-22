package com.ws;

import com.ws.system.controller.SystemController;
import com.ws.wiseSaying.controller.WiseSayingController;

public class App {

	private byte system_status = 1; //시스템 시작반복

	public App() {

	}

	public void run() {
		System.out.println("== 명언 앱 실행 ==");

		SystemController systemController = new SystemController(); //시스템 컨트롤러 객체 생성
		WiseSayingController wiseSayingController = new WiseSayingController(); //와이즈컨트롤러 객체생성

		while (system_status == 1) {
			System.out.print("명령어 ) ");
			String cmd = Container.getScanner().nextLine().trim(); //
			Rq rq = new Rq(cmd); //Rq cmd 명령어 객체생성 

			switch (rq.getActionCode()) { //rq의 겟액션코드 매서드 실행 앞부분만 스캔함
			case "종료":
				systemController.exit(); // 시스템 컨트롤러 exit 매서드 실행 출력을 표시하게됨
				system_status = 0; //시스템 종료 !=1
				break;
			case "등록":
				wiseSayingController.write(); //컨트롤러 write 매서드 실행
				break;
			case "목록":
				wiseSayingController.list(); //컨트롤러 list 매서드 실행
				break;
			case "삭제":
				wiseSayingController.remove(rq); //컨트롤러 remove 매서드 실행
				break;
			case "수정":
				wiseSayingController.modify(rq); //컨트롤러 modify 매서드 실행
				break;
			default:
				System.out.println("존재하지 않는 명령어입니다");
				break;
			}
		}

	}
}