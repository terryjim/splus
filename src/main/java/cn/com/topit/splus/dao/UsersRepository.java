package cn.com.topit.splus.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.com.topit.splus.entity.Users;

public interface UsersRepository extends JpaRepository<Users,Long>{
	 Users findByName(String name);
	 Users findByCode(String code);
}
