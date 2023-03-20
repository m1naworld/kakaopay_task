package com.example.kakaopay.point.repository;

import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import com.example.kakaopay.point.entity.Point;

public interface PointRepository extends JpaRepository<Point, Long> {
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Optional<Point> findByMemberId(Long memberId);
}
