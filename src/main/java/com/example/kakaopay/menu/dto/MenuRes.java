package com.example.kakaopay.menu.dto;

import com.example.kakaopay.menu.entity.Menu;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MenuRes {

	private long menuId;
	private String name;
	private int price;

	public MenuRes(Menu menu) {
		this.menuId = menu.getId();
		this.name = menu.getName();
		this.price = menu.getPrice();
	}
	
}
