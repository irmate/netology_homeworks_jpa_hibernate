package ru.netology.DAOapp_hibernate.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().
                withUser("Javaboy")
                .password("{noop}Javaboy")
                .authorities("read", "write")
                .and()
                .withUser("Javagirl")
                .password("{noop}Javagirl")
                .authorities("read");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .authorizeRequests().antMatchers("/persons").permitAll()
                .and()
                .authorizeRequests().antMatchers("/persons/by-city", "/persons/by-name-surname", "/persons/by-lessthan-age/{age}").hasAuthority("read")
                .and()
                .authorizeRequests().antMatchers("/persons/create", "/persons/update", "/persons/delete").hasAuthority("write")
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }
}