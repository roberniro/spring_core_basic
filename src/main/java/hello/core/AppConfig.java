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

// 구동에 필요한 객체 생성하는 클래스
@Configuration // 어플리케이션 설정 정보임을 나타냄
public class AppConfig {

    /*
    * @Bean memberService -> new MemoryMemberRepository()
    * @Bean orderService -> new MemoryMemberRepository()
    * 싱글톤이 깨지지 않을까? -> @Configuration
    *
    * 예측
    * call AppConfig.memberService
    * call AppConfig.memberRepository
    * call AppConfig.memberRepository
    * call AppConfig.orderService
    * call AppConfig.memberRepository
    *
    * 실제
    * call AppConfig.memberService
    * call AppConfig.memberRepository
    * call AppConfig.orderService
    */

    @Bean // 스프링 컨테이너에 등록
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository()); // 생성자 주입
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
