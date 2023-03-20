package com.example.kakaopay.point.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "POINTS")
public class Point {

	@Id
	private Long memberId;

	@Column(nullable = false)
	private Integer point;

	public Point(Long memberId, int point) {
		this.memberId = memberId;
		this.point = point;
	}

	public void add(int point) {
		this.point += point;
	}

	public void payment(int point) { this.point -= point; }
}
