package com.example.kakaopay.point.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kakaopay.point.entity.PointCredit;

public interface PointCreditRepository extends JpaRepository<PointCredit, Long> {
}
