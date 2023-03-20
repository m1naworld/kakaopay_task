package com.example.kakaopay.order;

import static com.example.kakaopay.common.response.ErrorMessage.*;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.kakaopay.common.exception.NotFoundException;
import com.example.kakaopay.menu.entity.Menu;
import com.example.kakaopay.menu.repository.MenuRepository;
import com.example.kakaopay.point.entity.Point;
import com.example.kakaopay.point.repository.PointRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final MenuRepository menuRepository;
	private final PointRepository pointRepository;
	private final OrdersRepository ordersRepository;

	@Transactional
	public Boolean doOrder(OrderReq orderReq) {
		Long memberId = orderReq.getMemberId();
		Long menuId = orderReq.getMenuId();

		Optional<Point> findMyPoint = pointRepository.findByMemberId(memberId);

		if (findMyPoint.isEmpty()) {
			return false;
		}

		Menu menu = menuRepository.findById(menuId)
			.orElseThrow(() ->
				new NotFoundException("orderService-doOrder", "memberId: "+memberId, NOT_FOUND_MEMBER));

		if (findMyPoint.get().getPoint() < menu.getPrice()) {
			return false;
		}

		findMyPoint.get().payment(menu.getPrice());

		Orders order = new Orders(memberId, menu);
		ordersRepository.save(order);

		return true;

	}
}
