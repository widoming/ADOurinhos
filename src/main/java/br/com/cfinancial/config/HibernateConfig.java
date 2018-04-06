/**
 * @author Bruno Fernando Yamada
 * 23 de out de 2017
 *	
 */
package br.com.cfinancial.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"br.com.cfinancial.entity"})
@EnableTransactionManagement
public class HibernateConfig {
	
	//Configuração de conexão com Firebird
	private static final String DATABASE_URL = "jdbc:postgresql://127.0.0.1:16582/cfinancial";
	private static final String DATABASE_USERNAME = "postgres";
	private static final String DATABASE_PASSWORD = "root";
	private static final String DATABASE_DIALECT = "org.hibernate.dialect.PostgreSQLDialect";
	private static final String DATABASE_DRIVER = "org.postgresql.Driver";
	
	
	@Bean
	public DataSource getDataSource() {
		
		
		
		/* Configuração Para outros SGBD's*/
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl(DATABASE_URL);
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		return dataSource;
	}
	

	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("br.com.cfinancial.entity");
		
		return builder.buildSessionFactory();
		
		
	}

	private Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		
		
		return properties;
	}
	
	@Bean
	public HibernateTransactionManager geTransactionManager(SessionFactory sessionFactory) {
		
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		
		return transactionManager;
		
	}
	
	
	

}
