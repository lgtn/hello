import hello.HelloStart;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.catalina.core.ApplicationContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
//juit测试,SpringJUnit支持，由此引入Spring-Test框架支持
@SpringApplicationConfiguration(classes = HelloStart.class)
//spring boot的启动类
@WebAppConfiguration
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration
public class TestJdbc {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void queryTest(){
		String sql = "select * from boot_user";
		
		List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
		
		for(Map<String, Object> map : result){
			System.out.println(map.get("name"));
		}
		
		 
		
	}

}
