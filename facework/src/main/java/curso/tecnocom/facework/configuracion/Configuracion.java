package curso.tecnocom.facework.configuracion;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.support.OpenSessionInViewInterceptor;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan({"curso.java.tecnocom"})
@EnableTransactionManagement
public class Configuracion
{
	
	
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager()
	{
		HibernateTransactionManager hibernateTransactionManager= 
				new HibernateTransactionManager();
		hibernateTransactionManager.
		setSessionFactory(getLocalSessionFactoryBean().getObject());
		return hibernateTransactionManager;

	}

	@Bean
	public OpenSessionInViewInterceptor getOpenSessionInViewInterceptor()
	{
		OpenSessionInViewInterceptor openSessionInViewInterceptor= 
				new OpenSessionInViewInterceptor();
		openSessionInViewInterceptor.
		setSessionFactory(getLocalSessionFactoryBean().getObject());
		return openSessionInViewInterceptor;
	}
	
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver()
	{
		InternalResourceViewResolver internalResourceViewResolver= new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}
	
	
	@Bean
	public DriverManagerDataSource getDriverManagerDataSource()
	{
		DriverManagerDataSource datasource= new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://192.168.120.44:3306/redsocial");
		datasource.setUsername("root");
		datasource.setPassword("tecnocom");
		return datasource;
		
	}

	@Bean
	public LocalSessionFactoryBean getLocalSessionFactoryBean()
	{
		LocalSessionFactoryBean factoryBean=new LocalSessionFactoryBean();
		factoryBean.setDataSource(getDriverManagerDataSource());
		factoryBean.setPackagesToScan("curso.java.tecnocom.datos");
		Properties properties= new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		properties.setProperty("hibernate.connection.autocommit", "false");
		properties.setProperty("hibernate.id.new_generator_mappings", "false");		
		factoryBean.setHibernateProperties(properties);
		return factoryBean;
		
	}
	
}









