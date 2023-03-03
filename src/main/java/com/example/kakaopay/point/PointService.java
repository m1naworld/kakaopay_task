package com.example.kakaopay.point;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PointService {

	private final PointRepository pointRepository;

	@Transactional
	public void savePoint(PointReq pointReq) {
		Long memberId = pointReq.getMemberId();
		Integer point = pointReq.getPoint();

		Optional<Point> findMyPoint = pointRepository.findByMemberId(memberId);

		if (findMyPoint.isPresent()) {
			findMyPoint.get().updatePoint(point);
			return;
		}
		Point myPoint = new Point(memberId, point);
		pointRepository.save(myPoint);
	}
}
