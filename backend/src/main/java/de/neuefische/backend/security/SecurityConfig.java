package de.neuefische.backend.security;

import de.neuefische.backend.service.AppUsersDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AppUsersDetailService appUsersDetailService;

    public SecurityConfig(AppUsersDetailService appUsersDetailService) {
        this.appUsersDetailService = appUsersDetailService;
    }

    @Bean
    PasswordEncoder passwordEncoder () {
    return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/user/login").permitAll()
                .antMatchers("/api/user/register").permitAll()
                .antMatchers("/api/travel/match").permitAll()
                .antMatchers("/admin/*").hasRole("admin")
                .and().httpBasic().and().csrf().disable();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(appUsersDetailService);
    }

}
