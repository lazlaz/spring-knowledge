package com.laz.spring.knowledge.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.laz.spring.knowledge.spring.security.service.MyUserService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserService myUserService;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /* 可以将用户名密码存在内存中，也可以采用自定义Service从数据库中取
        auth.inMemoryAuthentication().withUser("admin").password("12345").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("test").password("test").roles("USER");
        */
       // auth.userDetailsService(myUserService).passwordEncoder(new MyPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 配置对根路径放行，其他请求拦截，对logout放行，允许表单校验，禁用CSRF
        http.authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated().and().logout().permitAll()
                .and().formLogin();
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 配置忽略js、css、images静态文件
        web.ignoring().antMatchers("/js/**", "/css/**", "/images/**");
    }


}
