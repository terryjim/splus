package cn.com.topit.splus.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.com.topit.splus.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{
	 User findByName(String name);
}
