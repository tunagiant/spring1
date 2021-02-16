package com.insight.board.configuration;

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

@Configuration
//application.properties 사용할 수 있도록
@PropertySource("classpath:/application.properties")
public class DatabaseConfiguration {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    /* application.properties에 설정했던 데이터베이스정보 사용할 수 있도록하며
    spring.datasource.hikari로 시작하는 설정을 이용해서 히카리CP 설정파일 만듬
     */
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }

    @Bean
    // 앞에서만든 히카리CP파일을 이용해서 데이터베이스와 연결하는 데이터소스(커넥션풀을 관리) 생성
    public DataSource dataSource() throws Exception {
        DataSource dataSource = new HikariDataSource(hikariConfig());
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        /* 스프링-MyBatis 에서 SqlSessionFactory 생성 시 sqlSessionFactoryBean 이용
        SqlSessionFactory : DataSource를 참조하여 MySQL서버와 MyBatis를 연결해주는 객체.
         */
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 앞에서 만든 데이터소스 설정
        sqlSessionFactoryBean.setDataSource(dataSource);
        /* MyBatis 매퍼파일(애플리케이션에서 사용할 SQL을 담고있는 XML파일) 위치 설정
        classpath : resources폴더의미   /mapper/** / : ampper폴더 밑 모든폴더의미
        /sql-*.xml : 이름이 sql로 시작하고 확장자가 xml인 모든파일의미  */
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResource("classpath:/mapper/**/dwl-*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    // 스네이크-카멜 설정값 적용
    @Bean
    @ConfigurationProperties(prefix = "mybatis.configuration")
    public org.apache.ibatis.session.Configuration mybatisConfig() {
        // 가져온 mybatis설정을 자바클래스로 만들어서 반환
        return new org.apache.ibatis.session.Configuration();
    }


}
