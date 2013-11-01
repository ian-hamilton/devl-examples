package com.inertia.solutions.spring.orm;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * This class is a basic Spring IOC Container config
 * which does a @Component @Services scan on the base package name,
 * and also allows the AspectJ Style proxy generation.
 *
 */
@Configuration
@ComponentScan({"com.inertia.solutions.spring.orm"})
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class SpringConfiguration {

	@Bean(name="dataSource")
	public BasicDataSource getDataSource() {
		BasicDataSource returnVal =  new BasicDataSource();
		returnVal.setDriverClassName("org.postgresql.Driver");
		returnVal.setUrl("jdbc:postgresql://localhost:5432/hibernatedb");
		returnVal.setUsername("postgres");
		returnVal.setPassword("devl");
		return returnVal;
	}
	
	@Bean(name="sessionFactory")
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean returnVal = new LocalSessionFactoryBean();
		returnVal.setDataSource(getDataSource());
		returnVal.setPackagesToScan(new String[] { "com.inertia.solutions.spring.orm.bean" });
		
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "create");
		returnVal.setHibernateProperties(properties);
		
		return returnVal;
	}
	
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager returnVal = new HibernateTransactionManager();
		returnVal.setSessionFactory(getSessionFactory().getObject());
		return returnVal;
	}
}
