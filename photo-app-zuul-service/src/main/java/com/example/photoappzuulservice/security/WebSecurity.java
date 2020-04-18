package com.example.photoappzuulservice.security;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private final Environment environment;

    @Autowired
    public WebSecurity(Environment environment) {
        this.environment = environment;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.authorizeRequests()

                 .antMatchers("/**").permitAll();
               //  .antMatchers("/actuator/**").permitAll();
//                .antMatchers("/users-ws/h2-console/**").permitAll()
//                .antMatchers(HttpMethod.POST, "/users-ws/users").permitAll()
//                .antMatchers(HttpMethod.POST, "/users-ws/login").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .addFilter(new AuthorizationFilter(authenticationManager(), environment));

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }

}