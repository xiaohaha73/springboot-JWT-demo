package com.resource.config;

import com.resource.filter.JwtVerifyFilter;
import com.resource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private RsaKeyProperties prop;

    //SpringSecurity配置信息
    public void configure(HttpSecurity http) throws Exception {
        http.csrf()
            .disable()
            .authorizeRequests()
            .antMatchers("/**").hasAnyRole("USER","ADMIN")
            .anyRequest()
            .authenticated()
            .and()
            .addFilter(new JwtVerifyFilter(super.authenticationManager(), prop))
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // 关闭session
    }
}
