package hello.jpa;

import hello.jpa.model.BootUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * JpaSpecificationExecutor特色：实现了带条件的查询， 类似于Hibernate 的cretira
 * 1、JpaRepository 继承于 PagingAndSortingRepository 接口
 * 2、由于JpaSpecificationExecutor 并不继承repository 接口，所以它不能单独使用，只能和jpa Repository 一起用，否则无法为BootUserPageResposty创建bean
 * @author TL
 *
 */
public interface BootUserPageResposty extends JpaRepository<BootUser, Long> ,JpaSpecificationExecutor<BootUser>{

}
