package com.ezteam.ezstudio;

import com.ezteam.ezstudio.routes.BasicAuthEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import javax.sql.DataSource;

/**
 * Created by a70850 on 19/04/2017.
 */
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private static String REALM="EZStudio API";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/**", "/users").permitAll()
                //.antMatchers("/**").hasRole("USER")
                .and().httpBasic().realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint())
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    public BasicAuthEntryPoint getBasicAuthEntryPoint(){
        return new BasicAuthEntryPoint();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .usersByUsernameQuery(
                    "select login,password, enabled from UserEntity where login=?")
                .authoritiesByUsernameQuery(
                    "select login, role from UserEntity where login=?");
    }
}