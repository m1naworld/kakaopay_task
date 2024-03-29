package com.example.kakaopay.order;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.kakaopay.menu.entity.Menu;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@CreatedDate
	private LocalDateTime orderDate;

	@Column(nullable = false)
	private Long memberId;

	@Column(nullable = false)
	@OneToOne(fetch = FetchType.LAZY)
	private Menu menu;

	@Column(nullable = false)
	private Integer price;

	public Orders(Long memberId, Menu menu) {
		this.memberId = memberId;
		this.menu = menu;
		this.price = menu.getPrice();
	}

}

