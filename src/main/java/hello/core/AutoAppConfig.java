package hello.core;


import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 탐색 시작 위치 지정(지정하지 않으면 @ComponentScan 붙은 설정 정보 클래스의 패키지부터 시작
        // 설정 정보 클래스 프로젝트 최상단에 두어 basePackages 지정 생략하자! (스프링 부트는 @SpringBootApplication)
        basePackages = "hello.core",
        // AppConfig 삭제 없이 ComponentScan 하기 위해 필터링
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
//    스프링 부트 테스트에서 수동 등록하면 오류발생하여 주석 처리
//    @Bean(name = "memoryMemberRepository")
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
