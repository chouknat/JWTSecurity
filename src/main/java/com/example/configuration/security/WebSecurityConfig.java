package com.example.configuration.security;

import com.example.configuration.security.jwt.JWTAuthenticationFilter;
import com.example.configuration.security.jwt.JWTLoginFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by a576097 on 16/08/2016.
 */

@Configuration
//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/console").permitAll()
                .antMatchers(HttpMethod.POST, "/api/login").permitAll();
                //.anyRequest().authenticated()
                //.and()
                // We filter the api/login requests
                //.addFilterBefore(new JWTLoginFilter("/api/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                // And filter other requests to check the presence of JWT in header
                //.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
                // And filter other requests to check the presence of JWT in header
               // .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
                //.and()
                //.formLogin()
                //.loginPage("/login.html")
                //.loginProcessingUrl("/perform_login")
                //.defaultSuccessUrl("/swagger-ui.html")

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        // Create a default account
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("password")
                .roles("ADMIN");
    }
}
