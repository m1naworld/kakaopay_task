package com.example.kakaopay.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SuccessMessage {

	ORDER_SUCCESS(200, "주문 성공"),
	ORDER_SAVE_SUCCESS(200, "주문내역 저장 성공"),
	SAVE_POINT_SUCCESS(200, "포인트 충전 성공");

	private final int statusCode;
	private final String message;

}
