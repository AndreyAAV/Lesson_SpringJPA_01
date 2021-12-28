package by.itclass.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories("by.itclass.repositories")
//@ComponentScan("by.itclass.repository")
public class JPAConfig {

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory managerFactory) {
        return new JpaTransactionManager(managerFactory);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        Map<String, String> props = new HashMap<>();
        props.put("hibernate.show_sql", "true");

        LocalContainerEntityManagerFactoryBean managerFactory = new LocalContainerEntityManagerFactoryBean();
        managerFactory.setDataSource(dataSource());
        managerFactory.setJpaVendorAdapter(jpaVendorAdapter());
        managerFactory.setPackagesToScan("by.itclass.entity");
        managerFactory.setJpaPropertyMap(props);

        return managerFactory;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/itclass_po52?serverTimezone=Europe/Minsk");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }
}
