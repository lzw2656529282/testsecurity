package com.example.testsecurity.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author: liuzhenwei
 * @date: 2020/10/15
 */
@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //拦截所有的请求
        http.authorizeRequests()
                .and().authorizeRequests()
                //验证访问路径是否需要验证
                .antMatchers("/login").permitAll()  //权限验证失败
                .antMatchers("/getName").authenticated()//未认证处理异常
                .antMatchers("/getAge").hasRole("vip3")//未认证处理异常
                //没有匹配到的都需要验证
                .anyRequest().authenticated()
                //执行各种处理器
                //1.角色验证失败
                .and().exceptionHandling().accessDeniedHandler(new MyAccessDeniedHandler())
                .authenticationEntryPoint(new MyAuthenticationEntryPoint())
                ;
        //没有权限跳转到登录页面
        http.formLogin();
    }

    /**
     * 授权
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("lzw").password(new BCryptPasswordEncoder().encode("lzw")).roles("vip1","vip2")
                .and().withUser("admin").password(new BCryptPasswordEncoder().encode("admin")) .roles("vip3");
    }

}
