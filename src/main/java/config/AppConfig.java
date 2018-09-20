package config;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan(basePackages = {"controller", "config", "service"})
@Import(SecurityConfig.class)
public class AppConfig {
    public AppConfig() {
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.hbm2ddl.auto", "update");
        sessionFactoryBean.setPackagesToScan(new String[]{"model"});
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/clinicmana2");
//        dataSource.setUsername("rmit");
//        dataSource.setPassword("rmit");


        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        String username = System.getenv("JDBC_DATABASE_USERNAME");
        String password = System.getenv("JDBC_DATABASE_PASSWORD");
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setHibernateProperties(properties);
        return sessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager tx = new HibernateTransactionManager(sessionFactory);
        return tx;
    }
}

