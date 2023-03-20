package com.example.kakaopay.menu.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
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
	@CreatedDate
	private LocalDate dates;

	@Column(nullable = false)
	private Long menuId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private Integer price;

	@Column(nullable = false)
	private Integer orderCount;

	public BestMenu(BestMenuDto bestMenuDto) {
		this.menuId = bestMenuDto.getMenuId();
		this.name = bestMenuDto.getName();
		this.price = bestMenuDto.getPrice();
		this.orderCount = bestMenuDto.getOrderCount();
	}

}
