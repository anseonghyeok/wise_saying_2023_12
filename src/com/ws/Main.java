package com.ws;

public class Main {
	public static void main(String[] args) {

		Container.init(); //Container init 매서드 실행 공용저장소 작동하게됨

		new App().run(); //App run 매서드 실행 명언앱 실행 가능

		Container.close(); //Container close 매서드 실행 공용저장소 꺼짐
	}
}