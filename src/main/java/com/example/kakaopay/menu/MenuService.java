package com.example.kakaopay.menu;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.kakaopay.menu.dto.MenuRes;
import com.example.kakaopay.menu.entity.Menu;
import com.example.kakaopay.menu.repository.MenuRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MenuService {

	private final MenuRepository menuRepository;

	public List<MenuRes> getMenuList() {

		List<Menu> menuList = menuRepository.findAll();

		if (menuList.size() == 0) {
			return null;
		}

		return menuList.stream()
			.map(MenuRes::new)
			.toList();
	}

}
