package com.ws;

import java.util.HashMap;
import java.util.Map;

// Rq == Request(요청)
public class Rq {
	private String actionCode;
	private Map<String, String> params;

	public Rq(String cmd) { //함수
		String[] cmdBits = cmd.split("\\?", 2); //cmd의 내용을 ?로 스플릿함 명령어 / 내용

		actionCode = cmdBits[0]; //앞의 명령어

		params = new HashMap<>(); //파람에 해쉬맵을 넣음

		if (cmdBits.length == 1) { //만약에 내용을 제대로 안넣으면 리턴
			return;
		}

		String[] paramBits = cmdBits[1].split("&"); //아이디와 저자를 반씩나눔

		for (String paramStr : paramBits) {
			String[] paramStrBits = paramStr.split("=", 2); // 내용과 키를 반씩 나눔

			if (paramStrBits.length == 1) { //제대로 안쓰면 리턴
				continue;
			}

			String key = paramStrBits[0];// ex id,저자
			String value = paramStrBits[1]; // 값
			params.put(key, value); //params에 내용을 집어넣음
		}

	}

	public String getActionCode() { //겟엑션을 얻는 메소드
		return actionCode;
	}

	public String getParam(String name) { //겟파람을 얻는 매소드
		return params.get(name);
	}

	public int getIntParam(String name, int defaultValue) { //실행 루트를 위한 초기값을 얻어주는 매소드 
	
		try {
			return Integer.parseInt(getParam(name));
		} catch (NumberFormatException e) {

		}
		return defaultValue;
	}

}