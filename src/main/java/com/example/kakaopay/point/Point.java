package com.example.kakaopay.point;

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

	private Integer point;

	public Point(Long memberId, int point) {
		this.memberId = memberId;
		this.point = point;
	}

	public void updatePoint(int point) {
		this.point += point;
	}

	public void paymentPoint(int point) { this.point -= point; }
}
