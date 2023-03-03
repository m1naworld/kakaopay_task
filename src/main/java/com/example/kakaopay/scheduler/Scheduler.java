package com.example.kakaopay.scheduler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.jdbctemplate.JdbcTemplateLockProvider;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;

import com.example.kakaopay.menu.entity.BestMenu;
import com.example.kakaopay.menu.repository.BestMenuRepository;
import com.example.kakaopay.menu.dto.BestMenuDto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Scheduler {

	private final BestMenuRepository bestMenuRepository;

	@Bean
	public LockProvider lockProvider(DataSource dataSource) {
		return new JdbcTemplateLockProvider(dataSource);
	}

	private static final String SEC_30 = "PT30S";

	@SchedulerLock(name = "runScenarioOneTime", lockAtMostFor = SEC_30, lockAtLeastFor = SEC_30)
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
