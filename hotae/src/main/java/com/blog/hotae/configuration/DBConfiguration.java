package com.blog.hotae.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration                                          //설정파일이란 의미
@PropertySource("classpath:/application.properties")    //properties파일 위치
public class DBConfiguration {

    //스프링컨테이너의 한 종류
    @Autowired
    private ApplicationContext applicationContext;

    //properties파일에서 spring.datasource.hikari 로 시작하는 설정을 해당 메서드에 매핑(바인딩)
    @Bean
    @ConfigurationProperties(prefix="spring.datasource.hikari")
    //히카리CP(커넥션풀 라이브러리) 객체 생성
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }

    //DataSource : 커넥션풀을 지원하는 인터페이스
    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(hikariConfig());
    }

    /*
    SqlSessionFactory : 데이터베이스 커넥션과 SQL실행에 대한 모든것을 가짐
    SqlSessionFactoryBean : MyBatis XML Mapper, 설정파일위치 등을 지정
    getObject() 메서드 리턴 시 SqlSessionFactory를 생성
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        //mapper위치
        factoryBean.setMapperLocations(applicationContext.getResource("classpath:/**/*Mapper.xml"));
        //domain풀패키지 생략
        factoryBean.setTypeAliasesPackage("com.blog.hotae.domain");
        //mybatis설정빈 을 설정파일로 지정(인자:밑의 mybatisConfig메서드)
        factoryBean.setConfiguration(mybatisConfig());
        return factoryBean.getObject();
    }

    /*
    SQL의 실행에 필요한 모든 메서드를 갖는 객체
     */
    @Bean
    public SqlSessionTemplate sqlSession() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }

    //properties파일에서 mybatis.configuration 로 시작하는 설정을 해당 메서드에 매핑(바인딩)
    @Bean
    @ConfigurationProperties(prefix="mybatis.configuration")
    public org.apache.ibatis.session.Configuration mybatisConfig() {
        return new org.apache.ibatis.session.Configuration();
    }

    /*
    커넥션:SQL을 실행할때마다 데이터베이스에 접근하는 객체
    ConnectionPool(HikariCP)>DataSource>SqlSessionFactory>SqlTemplate
     */
}
