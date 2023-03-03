package com.example.kakaopay.menu.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.kakaopay.menu.dto.BestMenuDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class BestMenu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@CreatedDate
	private LocalDate dates;

	private Long menuId;
	private String name;
	private Integer price;
	private Integer orderCount;

	public BestMenu(BestMenuDto bestMenuDto) {
		this.menuId = bestMenuDto.getMenuId();
		this.name = bestMenuDto.getName();
		this.price = bestMenuDto.getPrice();
		this.orderCount = bestMenuDto.getOrderCount();
	}

}
