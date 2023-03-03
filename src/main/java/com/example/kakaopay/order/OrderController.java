package com.example.kakaopay.order;

import static com.example.kakaopay.common.response.ErrorMessage.*;
import static com.example.kakaopay.common.response.SuccessMessage.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kakaopay.common.response.Response;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/order")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;

	@ApiOperation(value = "커피 주문, 결제하기 API")
	@PostMapping("")
	public ResponseEntity<?> createOrder(@RequestBody OrderReq orderReq) {
		Boolean isSuccess = orderService.doOrder(orderReq);

		if (isSuccess) {
			return Response.toSuccess(ORDER_SUCCESS);
		}
		return Response.toError(POINT_LACK);
	}
}
