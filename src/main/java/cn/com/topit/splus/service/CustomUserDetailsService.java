package cn.com.topit.splus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import cn.com.topit.splus.dao.UsersRepository;
import cn.com.topit.splus.entity.SecurityUser;
import cn.com.topit.splus.entity.Users;

/**
 * https://github.com/chenfromsz/spring-boot-security
 * @author terry
 *
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users user = usersRepository.findByCode(userName);
        System.out.println(user);
        if (user == null) {
            throw new UsernameNotFoundException("用户名 " + userName + "不存在");
        }
        return new SecurityUser(user);
    }
}
