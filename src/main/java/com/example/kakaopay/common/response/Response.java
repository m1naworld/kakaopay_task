package com.example.kakaopay.common.response;

import org.springframework.http.ResponseEntity;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Response<T> {
	private String message;
	private T data;

	public Response(String message, T data) {
		this.message = message;
		this.data = data;
	}

	public ResponseEntity toSuccessData(SuccessMessage success, T data) {
		return ResponseEntity.status(success.getStatusCode())
			.body(new Response<>(success.getMessage(), data));
	}

	public static ResponseEntity toError(ErrorMessage error) {
		return ResponseEntity.status(error.getStatusCode())
			.body(error.getMessage());
	}

	public static ResponseEntity toSuccess(SuccessMessage success) {
		return ResponseEntity.status(success.getStatusCode())
			.body(success.getMessage());
	}

}
