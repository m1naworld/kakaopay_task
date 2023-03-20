package com.example.kakaopay.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

	NOT_FOUND_MEMBER(400, "존재하지 않는 회원입니다."),
	NOT_FOUND_MENU_LIST(404, "메뉴 목록이 존재하지 않습니다."),
	POINT_LACK(400, "포인트가 부족합니다.");

	private final int statusCode;
	private final String message;
}
