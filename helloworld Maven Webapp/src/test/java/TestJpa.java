import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import hello.HelloStart;
import hello.jpa.BootUserPageResposty;
import hello.jpa.BootUserResposty;
import hello.jpa.model.BootUser;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;



@RunWith(SpringJUnit4ClassRunner.class)
//juit测试,SpringJUnit支持，由此引入Spring-Test框架支持
@SpringApplicationConfiguration(classes = HelloStart.class)
//spring boot的启动类
@WebAppConfiguration
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration
public class TestJpa {

//	@Autowired
//	private BootUserResposty resposty;
	
	@Autowired
	private BootUserPageResposty pageResposty;
	
	@Test
	public void queryTest(){
		
//		BootUser user = resposty.findOne(123l);
		
//		user = resposty.findUserByName("name1");
//		
//		System.out.println(user.getName());
//		
//		List<BootUser> list = resposty.findAll();
//		
//		System.out.println(list.size());
		
//		BootUser buser = new BootUser();
//		long ts = user.getId()+2;
//		buser.setId(ts);
//		buser.setCode(ts+"");
//		buser.setName(ts+"");
//		buser.setPhone(ts+"");
//		resposty.save(buser);
		
		
		//排序
		Order order = new Order(Direction.ASC, "id");
		Sort sort = new Sort(order);
//		List<BootUser> orderList = resposty.findAll(sort);
//		
//		System.out.println(orderList.get(2).getId());
//		
		//分页
		Pageable page = new PageRequest(1, 1, sort);
//		Page<BootUser> pageUser = resposty.findAll(page);
//		List<BootUser> pageList = pageUser.getContent();
//		System.out.println(pageList.size());
		
		//带条件的分页查询
		Spec spec = new Spec();
		Page<BootUser> pbu = pageResposty.findAll(spec, page);
		System.out.println(pbu.getContent().size());
	}
	
	
	/**
	 * 可实现自定义条件、多表查询
	 * @author TL
	 *
	 */
	class Spec implements Specification<BootUser>{

		@Override
		public Predicate toPredicate(Root<BootUser> root,
				CriteriaQuery<?> query, CriteriaBuilder cb) {
			Path<Long> exp_id = root.get("id");
			Predicate predicat = cb.lessThan(exp_id, 123l);
			return predicat;
		}
	}
}
