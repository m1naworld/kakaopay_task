package com.example.kakaopay.menu.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.kakaopay.menu.dto.BestMenuDto;
import com.example.kakaopay.menu.entity.BestMenu;

public interface BestMenuRepository extends JpaRepository<BestMenu, Long> {

	@Query("SELECT b FROM BestMenu b WHERE b.dates = :today")
	List<BestMenu> findTodayBestMenu (LocalDate today);

	@Query(value = "SELECT o.menu_id AS menuId, m.name, m.price, COUNT(o.menu_id) AS orderCount "
		+ "FROM Orders o "
		+ "INNER JOIN MENU m on o.menu_id = m.id "
		+ "WHERE o.order_date BETWEEN :aWeekAgo AND :aDayAgo "
		+ "GROUP BY o.menu_id "
		+ "LIMIT 3", nativeQuery = true)

	List<BestMenuDto> findOneWeekOrders(@Param("aWeekAgo") LocalDateTime aWeekAgo, @Param("aDayAgo") LocalDateTime aDayAgo);

}
