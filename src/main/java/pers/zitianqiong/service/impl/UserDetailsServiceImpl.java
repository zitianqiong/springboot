package pers.zitianqiong.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pers.zitianqiong.domain.Authority;
import pers.zitianqiong.domain.Customer;
import pers.zitianqiong.service.CustomerService;

/**
 * <p>描述:</p>
 *
 * @author 丛吉钰
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private CustomerService customerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerService.getCustomer(username);
        List<Authority> authorities = customerService.getCustomerAuthoritiy(username);
        List<SimpleGrantedAuthority> list = authorities.stream().map(authority -> new SimpleGrantedAuthority(authority.getAuthority())).collect(Collectors.toList());
        //返回封装的UserDetails用户详情类
        if(customer!=null){
            UserDetails userDetails=new User(customer.getUsername() , customer. getPassword() ,list);
            return userDetails;
        }else {
            //如果查询的用户不存在（用户名不存在）,必须抛出此异常
            throw new UsernameNotFoundException("当前用户不存在!");
        }
    }
}
