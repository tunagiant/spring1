package hello.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 기본적으로 스프링부트 사용 시 생기는 파일 : @SpringbootApplication에는 @ComponentScan이 붙어있음
// 따라서 스프링부트 사용 시 따로 @ComponentScan 쓸 일이 없다
@SpringBootApplication
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

}
