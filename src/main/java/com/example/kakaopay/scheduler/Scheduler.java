package com.example.kakaopay.scheduler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.kakaopay.menu.entity.BestMenu;
import com.example.kakaopay.menu.repository.BestMenuRepository;
import com.example.kakaopay.menu.dto.BestMenuDto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Scheduler {

	private final BestMenuRepository bestMenuRepository;

	@Scheduled(cron = "0 0 0 * * *")
	public void bestMenuSch() {

		LocalDateTime now = LocalDateTime.now();
		LocalDate today = now.toLocalDate();
		LocalDateTime aWeekAgo = now.minusWeeks(1);
		LocalDateTime aDayAgo = now.minusDays(1);

		List<BestMenuDto> orderList = bestMenuRepository.findOneWeekOrders(aWeekAgo, aDayAgo);

		orderList.stream().forEach(m -> bestMenuRepository.save(new BestMenu(m)));
	}
}
