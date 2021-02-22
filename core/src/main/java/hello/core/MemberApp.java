package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

//        MemberService memberService = new MemberServiceImpl();

    // 스프링컨테이너 생성(@Configuration이 있는 클래스의 @Bean가 붙은 요소를 스프링컨테이너에 넣음)
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    // (불러올 Bean 이름, 반환타입
    // getBean(빈이름, 타입) : 빈 이름으로 빈객체조회     getBeanDefinitionNames() : 스프링에 등록된 모든 빈 이름 조회(배열)
    MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

    Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

                Member findMember = memberService.findMember(1L);
                System.out.println("new member = " + memberA.getName());
                System.out.println("findMember = " + findMember.getName());
    }
}
