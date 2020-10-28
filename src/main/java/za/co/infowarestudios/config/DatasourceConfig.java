package za.co.infowarestudios.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Jomo Lumina on 2018/06/05.
 */
@Configuration
@EnableTransactionManagement
public class DatasourceConfig {

	@Value("${tomcat.jdbc.pool.max_size}")
	private int maxSize;

	@Value("${tomcat.jdbc.pool.min_size}")
	private int minSize;

	@Value("${tomcat.jdbc.pool.initial-size}")
	private int initialSize;

	@Value("${tomcat.jdbc.pool.test-on-borrow}")
	private boolean testOnBorrow;

	@Value("${tomcat.jdbc.pool.test-while-idle}")
	private boolean testWhileIdle;

	@Value("${tomcat.jdbc.pool.username}")
	private String username;

	@Value("${tomcat.jdbc.pool.password}")
	private String password;

	@Value("${tomcat.jdbc.pool.url}")
	private String url;

	@Value("${tomcat.jdbc.pool.driver-class-name}")
	private String driverClassName;

	@Value("${tomcat.jdbc.pool.validation-query}")
	private String validationQuery;

	@Bean
	public DataSource dataSource() {
		DataSource dataSource = new DataSource();
		dataSource.setUrl(url);
		dataSource.setPassword(password);
		dataSource.setUsername(username);
		dataSource.setDriverClassName(driverClassName);
		dataSource.setValidationQuery(validationQuery);
		dataSource.setInitialSize(initialSize);
		dataSource.setMaxIdle(maxSize);
		dataSource.setMinIdle(minSize);
		dataSource.setTestOnBorrow(testOnBorrow);
		dataSource.setTestWhileIdle(testWhileIdle);
		return dataSource;
	}

}
