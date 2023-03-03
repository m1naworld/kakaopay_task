package com.example.kakaopay.point;

import static com.example.kakaopay.common.response.SuccessMessage.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kakaopay.common.response.Response;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RequestMapping("api/point")
@RestController
@RequiredArgsConstructor
public class PointController {

	private final PointService pointService;

	@ApiOperation(value = "포인트 충전하기 API")
	@ApiImplicitParam(
		name = "point"
		, value = "충전금액")
	@PostMapping()
	public ResponseEntity<?> savePoint(@RequestBody PointReq point) {

		pointService.savePoint(point);
		return Response.toSuccess(SAVE_POINT_SUCCESS);
	}
}
