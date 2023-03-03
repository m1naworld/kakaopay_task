package com.example.kakaopay.menu;

import static com.example.kakaopay.common.response.ErrorMessage.*;
import static com.example.kakaopay.common.response.SuccessMessage.*;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kakaopay.common.response.Response;
import com.example.kakaopay.menu.dto.MenuRes;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("api/menu")
@RequiredArgsConstructor
public class MenuController {

	private MenuService menuService;

	@ApiOperation(value = "커피 메뉴 목록 조회 API")
	@ApiResponses({
		@ApiResponse(code = 200, message = "커피 메뉴 조회"),
		@ApiResponse(code = 404, message = "커피 메뉴 리스트 없음")
	})
	@GetMapping("")
	public ResponseEntity<?> menuList() {

		List<MenuRes> menuList = menuService.getMenuList();

		if (menuList == null) {
			return Response.toError(NOT_FOUND_MENU_LIST);
		}
		return new Response<>().toSuccessData(ORDER_SUCCESS, menuList);
	}

}
