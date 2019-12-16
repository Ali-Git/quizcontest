package com.quiz.contest.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import com.quiz.contest.entity.Participant;
import com.quiz.contest.entity.Question;

@Component
public class HibernateUtilConfig {
	private static SessionFactory sessionFactory;

	@Bean
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				
				 settings.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
				 settings.put(Environment.URL, "jdbc:sqlserver://localhost:1433;instanceName=SQLEXPRESS;databaseName=QuizDB");
				 settings.put(Environment.USER, "ali53"); 
				 settings.put(Environment.PASS, "ali53"); 
				settings.put(Environment.DIALECT, "org.hibernate.dialect.SQLServer2012Dialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				// settings.put(Environment.HBM2DDL_AUTO, "create-drop");
				configuration.addAnnotatedClass(Question.class);
				configuration.addAnnotatedClass(Participant.class);
				configuration.setProperties(settings);
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}

	@Bean
	public static PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory);
		return txManager;
	}

}