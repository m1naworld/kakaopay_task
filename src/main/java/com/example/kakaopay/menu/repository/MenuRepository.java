package com.example.kakaopay.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kakaopay.menu.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {

}
