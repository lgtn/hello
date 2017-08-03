package hello;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
// 注解等价于以默认属性使用 @Configuration ， @EnableAutoConfiguration 和 @ComponentScan
public class HelloStart {

	@Bean
	public DataSource dataSource(DataSourceProperties properties) {
		BasicDataSource dataSource = new BasicDataSource();
		return dataSource;
	}

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(HelloStart.class);
		application.run(args);
	}
}
