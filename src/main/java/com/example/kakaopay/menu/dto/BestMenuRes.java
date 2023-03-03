package com.example.kakaopay.menu.dto;

import com.example.kakaopay.menu.entity.BestMenu;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BestMenuRes {

	private Long menuId;
	private String name;
	private Integer price;

	public BestMenuRes(BestMenu bestMenu) {
		this.menuId = bestMenu.getMenuId();
		this.name = bestMenu.getName();
		this.price = bestMenu.getPrice();
	}
}
