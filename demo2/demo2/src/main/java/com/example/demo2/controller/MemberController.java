package com.example.demo2.controller;

import com.example.demo2.domain.Member;
import com.example.demo2.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

	// 다른 컨트롤러에서도 이 서비스를 사용할 수 있음. 일일히 생성하는 것보다는 하나만 생성해서 다같이 쓰는게 나음
//	private final MemberService memberService = new MemberService();
	private final MemberService memberService;

	// 스프링이 서비스와 컨트롤러를 연결을 시켜줌(DI)
	@Autowired
	public MemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}
	
	@GetMapping("/members/new")
	public String createForm() {
		return "members/createMemberForm";
	}
	
	// 2. create메서드 실행. html의 form태그 에서 input의 "name" attribute을 MemberForm클래스에서 찾아줌.
	@PostMapping("/members/new")
	public String create(MemberForm form) {
		Member member = new Member();
		member.setName(form.getName());
		
		System.out.println(member.getName());
		
		memberService.join(member);
		return "redirect:/";
	}
	
	@GetMapping("/members")
	public String list(Model model) {
		List<Member> members = memberService.findMembers();
		model.addAttribute("members", members);
		return "members/memberList";
	}

}
