package com.example.demo2.service;

import com.example.demo2.domain.Member;
import com.example.demo2.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service // 서비스
public class MemberService {

//	private final MemberRepository memberRepository = new MemoryMemberRepository();
	private final MemberRepository memberRepository;

	@Autowired // 위처럼 그냥 new하면 테스트에서도 new할때 불필요하게 메모리낭비. 같은객체 사용하기 위해 외부에서 접근가능한 생성자 선언(DI)
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	/* 회원가입 */
	public Long join(Member member) {

		validateDuplicateMember(member);
		memberRepository.save(member);
		return member.getId();

	}

	// 같은이름 중복회원 제외
	private void validateDuplicateMember(Member member) {
		Optional<Member> result = memberRepository.findByName(member.getName());
		result.ifPresent(m -> { // ifPresent : Optional의 메서드
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		});
	}

	/* 전체회원 조회 */
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}

	/* 아이디로 회원 조회 */
	public Optional<Member> findOne(Long memberId) {
		return memberRepository.findById(memberId);
	}

}
