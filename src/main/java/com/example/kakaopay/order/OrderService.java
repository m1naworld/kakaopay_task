package com.example.kakaopay.order;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.kakaopay.menu.entity.Menu;
import com.example.kakaopay.menu.repository.MenuRepository;
import com.example.kakaopay.point.Point;
import com.example.kakaopay.point.PointRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrdersRepository ordersRepository;
	private final MenuRepository menuRepository;
	private final PointRepository pointRepository;

	@Transactional
	public Boolean doOrder(OrderReq orderReq) {
		Long memberId = orderReq.getMemberId();
		Long menuId = orderReq.getMenuId();

		Optional<Point> findPoint = pointRepository.findByMemberId(memberId);

		if (findPoint.isEmpty()) {
			return false;
		}

		Menu menu = menuRepository.findById(menuId).get();

		if (findPoint.get().getPoint() < menu.getPrice()) {
			return false;
		}

		Orders order = new Orders(memberId, menu);
		ordersRepository.save(order);

		findPoint.get().paymentPoint(menu.getPrice());
		return true;

	}
}
