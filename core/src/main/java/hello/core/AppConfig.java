package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    /*스프링 컨테이너(ApplicationContext)에 (memberService(), 리턴타입)   (key, value) 형식으로 등록됨. 이것을 스프링빈 객체라고 함
    스프링컨테이너는 @Configuration이 붙은 AppConfig를 구성정보로 사용함.
    빈 이름은 따로 부여가능(@bean(name="XXX"))  but 빈 이름은 중복되면 안된다.
     */
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
    return new OrderServiceImpl(memberRepository(), discountPolicy());
}

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
//        return new FixDiscountPolicy();
    }


}
