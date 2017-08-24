package hello.jpa;

import hello.jpa.model.BootUser;

import org.springframework.data.jpa.repository.JpaRepository;


public interface BootUserResposty extends JpaRepository<BootUser, Long>{
	
	BootUser findUserByName(String name);
	
}
