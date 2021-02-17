package hello.core;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration

// 자동으로 등록시켜줌(cf.AppConfig : 수동으로 등록)
@ComponentScan(
//        basePackages = { "hello.core.member", "hello.core.order"},// 스캔할 패키지범위 설정

        //@Configuration 어노테이션이 붙어있는 클래스는 제외해서 등록함(AppConfig, TestConfig등 과의 충돌 방지)
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)

)
public class AutoAppConfig {

}
