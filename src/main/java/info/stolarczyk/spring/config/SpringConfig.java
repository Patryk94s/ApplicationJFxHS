package info.stolarczyk.spring.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.mysql.cj.jdbc.MysqlDataSource;


@EnableJpaRepositories("info.stolarczy")
@Configuration
@ComponentScan ("info.stolarczyk")
public class SpringConfig {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		
		LocalContainerEntityManagerFactoryBean factoryBean = 
				new LocalContainerEntityManagerFactoryBean();
		
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan("info.Stolarczyk");
		factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
	    factoryBean.setJpaProperties(getJpaProperties());
		
		
		return factoryBean;
		
		
	}

	private Properties getJpaProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto","create");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		//properties.setProperty("hibernate.jdbc.time_zone", "GMT");
		return properties;
	}

	@Bean
	public DataSource dataSource() {
		
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setServerName("localhost");
		dataSource.setPort(3306);
		dataSource.setDatabaseName("mybase");
		dataSource.setUser("User");
		dataSource.setPassword("password");
		dataSource.setURL("jdbc:mysql://localhost:3306/mybase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		
		return dataSource;
		
	}
	
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		
		return new JpaTransactionManager(entityManagerFactory);
		
	}
	
	
	
	
}
