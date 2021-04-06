package hello.itemservice;

import hello.itemservice.repository.ItemRepository;
import hello.itemservice.repository.ItemRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public ItemRepository itemRepository() {
        return new ItemRepositoryImpl(dataSource);
    }

}
