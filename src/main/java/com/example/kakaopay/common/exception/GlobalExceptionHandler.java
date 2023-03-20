package com.example.kakaopay.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.kakaopay.common.response.Response;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<Response> handleNotFoundException(NotFoundException e) {
		log.error(e.getMethod() +"/" + e.getDetailInfo() + " " + e.getErrorMessage().getMessage()) ;

		return Response.toError(e.getErrorMessage());
	}
}
