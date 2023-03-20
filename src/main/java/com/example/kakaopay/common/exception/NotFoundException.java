package com.example.kakaopay.common.exception;

import com.example.kakaopay.common.response.ErrorMessage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
@AllArgsConstructor
public class NotFoundException extends NullPointerException{

	private String method;
	private String detailInfo;
	private ErrorMessage errorMessage;
}
