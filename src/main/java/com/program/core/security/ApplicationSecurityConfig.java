package com.program.core.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","index","/css/*").permitAll()
                .antMatchers("/v1/**").hasRole(ApplicationUserRoles.STUDENT.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails jamesUser  = User
                .builder()
                .username("james")
                .password(passwordEncoder.encode("password"))
                .roles(ApplicationUserRoles.STUDENT.name()) // ROLE_STUDENT
                .build();

        UserDetails admin = User.builder().username("admin")
                .password(passwordEncoder.encode("admin"))
                .roles(ApplicationUserRoles.ADMIN.name())
                .build();
        return new InMemoryUserDetailsManager(jamesUser,admin);
    }
}
