package com.example.kakaopay.menu;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.kakaopay.menu.dto.BestMenuRes;
import com.example.kakaopay.menu.dto.MenuRes;
import com.example.kakaopay.menu.entity.BestMenu;
import com.example.kakaopay.menu.entity.Menu;
import com.example.kakaopay.menu.repository.BestMenuRepository;
import com.example.kakaopay.menu.repository.MenuRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MenuService {

	private final MenuRepository menuRepository;
	private final BestMenuRepository bestMenuRepository;

	public List<MenuRes> getMenuList() {

		List<Menu> menuList = menuRepository.findAll();

		if (menuList.size() == 0) {
			return null;
		}

		return menuList.stream()
			.map(MenuRes::new)
			.toList();
	}

	public List<BestMenuRes> getBestMenuList() {

		LocalDateTime now = LocalDateTime.now();
		LocalDate today = now.toLocalDate();

		List<BestMenu> bestMenuList = bestMenuRepository.findTodayBestMenu(today);

		if (bestMenuList.size() == 0) {
			return null;
		}

		return bestMenuList.stream()
			.map(BestMenuRes::new)
			.toList();
	}

}
