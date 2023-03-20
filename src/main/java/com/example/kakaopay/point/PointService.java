package com.example.kakaopay.point;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.kakaopay.common.exception.NotFoundException;
import com.example.kakaopay.common.response.ErrorMessage;
import com.example.kakaopay.member.Member;
import com.example.kakaopay.member.MemberRepository;
import com.example.kakaopay.point.entity.Point;
import com.example.kakaopay.point.entity.PointCredit;
import com.example.kakaopay.point.repository.PointCreditRepository;
import com.example.kakaopay.point.repository.PointRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PointService {

	private final MemberRepository memberRepository;
	private final PointRepository pointRepository;
	private final PointCreditRepository pointCreditRepository;

	@Transactional
	public void savePoint(PointReq pointReq) {
		Long memberId = pointReq.getMemberId();
		Integer point = pointReq.getPoint();

		Member member = memberRepository.findById(memberId)
			.orElseThrow(() ->
				new NotFoundException("PointService-savePoint",
					"memberId: "+memberId, ErrorMessage.NOT_FOUND_MEMBER));

		Optional<Point> findMyPoint = pointRepository.findByMemberId(memberId);

		PointCredit credit = new PointCredit(memberId, point);
		pointCreditRepository.save(credit);

		if (findMyPoint.isPresent()) {
			findMyPoint.get().add(point);
			return;
		}
		Point myPoint = new Point(memberId, point);
		pointRepository.save(myPoint);
	}
}
