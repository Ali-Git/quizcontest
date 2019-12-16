/*
 * package com.quiz.contest.config;
 * 
 * import javax.persistence.EntityManagerFactory; import javax.sql.DataSource;
 * 
 * import org.springframework.boot.jdbc.DataSourceBuilder; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.data.jpa.repository.config.EnableJpaRepositories; import
 * org.springframework.orm.jpa.JpaTransactionManager; import
 * org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean; import
 * org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter; import
 * org.springframework.transaction.PlatformTransactionManager; import
 * org.springframework.transaction.annotation.EnableTransactionManagement;
 * 
 * @Configuration
 * 
 * @EnableJpaRepositories
 * 
 * @EnableTransactionManagement class ApplicationConfig {
 * 
 * 
 * @Bean public DataSource dataSource() {
 * 
 * EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder(); return
 * builder.setType(EmbeddedDatabaseType.HSQL).build(); }
 * 
 * 
 * @Bean public static DataSource dataSource() { DataSourceBuilder
 * dataSourceBuilder = DataSourceBuilder.create();
 * dataSourceBuilder.driverClassName(
 * "com.microsoft.sqlserver.jdbc.SQLServerDriver"); dataSourceBuilder.url(
 * "jdbc:sqlserver://localhost:1433;instanceName=SQLEXPRESS;databaseName=QuizDB"
 * ); dataSourceBuilder.username("ali53"); dataSourceBuilder.password("ali53");
 * return dataSourceBuilder.build(); }
 * 
 * 
 * 
 * 
 * @Bean public static LocalContainerEntityManagerFactoryBean
 * entityManagerFactory() {
 * 
 * HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
 * vendorAdapter.setGenerateDdl(true);
 * 
 * LocalContainerEntityManagerFactoryBean factory = new
 * LocalContainerEntityManagerFactoryBean();
 * factory.setJpaVendorAdapter(vendorAdapter);
 * factory.setPackagesToScan("com.quiz.contest");
 * factory.setDataSource(dataSource()); return factory; }
 * 
 * 
 * @Bean public static PlatformTransactionManager
 * transactionManager(EntityManagerFactory entityManagerFactory) {
 * 
 * JpaTransactionManager txManager = new JpaTransactionManager();
 * txManager.setEntityManagerFactory(entityManagerFactory); return txManager; }
 * }
 */