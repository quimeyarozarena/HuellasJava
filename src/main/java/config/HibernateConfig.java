package config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate5.support.OpenSessionInViewInterceptor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import model.Person;

@Configuration 
@EnableTransactionManagement
@EnableJpaRepositories(basePackages={"dao"})
@PropertySource(value = {"classpath:application.properties"}) 
public class HibernateConfig {

    @Value("${spring.datasource.driverClassName}")
    private String DB_DRIVER;

    @Value("${spring.datasource.password}")
    private String DB_PASSWORD;

    @Value("${spring.datasource.url}")
    private String DB_URL;

    @Value("${spring.datasource.username}")
    private String DB_USERNAME;

    @Value("${spring.jpa.hibernate.dialect}")
    private String HIBERNATE_DIALECT;

    @Value("${spring.jpa.hibernate.show_sql}")
    private String HIBERNATE_SHOW_SQL;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String HIBERNATE_HBM2DDL_AUTO;

    @Value("${spring.jpa.hibernate.entitymanager.packagesToScan}")
    private String ENTITYMANAGER_PACKAGES_TO_SCAN;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DB_DRIVER);
        dataSource.setUrl(DB_URL);
        dataSource.setUsername(DB_USERNAME);
        dataSource.setPassword(DB_PASSWORD);
        return dataSource;
    }
    
    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", HIBERNATE_DIALECT);
        hibernateProperties.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
        hibernateProperties.put("hibernate.hbm2ddl.auto", HIBERNATE_HBM2DDL_AUTO);
        return hibernateProperties;        
    }
     
    //da acceso completo a la configuraci�n de EntityManagerFactory 
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
       LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
       em.setDataSource(dataSource());
       em.setPackagesToScan(new String[] { ENTITYMANAGER_PACKAGES_TO_SCAN});
  
       //define hibernate como implementacion de jpa
       JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
       em.setJpaVendorAdapter(vendorAdapter);
       em.setJpaProperties(hibernateProperties());

       return em;
    }
  
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
      return new JpaTransactionManager(entityManagerFactory().getObject());
    }
  
    //Spring captura las excepciones de repositorios y las transforme en excepciones de Spring
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
       return new PersistenceExceptionTranslationPostProcessor();
    }
  
    
    @Bean 
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
    }
    
    

}
