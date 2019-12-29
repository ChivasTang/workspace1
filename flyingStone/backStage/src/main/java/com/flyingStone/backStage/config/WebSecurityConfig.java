package com.flyingStone.backStage.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

/*@Configuration*/
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    private final UserDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder;

    public WebSecurityConfig(DataSource dataSource, UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.dataSource = dataSource;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated();
        http
                .formLogin()
                .loginPage("/")
                .loginProcessingUrl("/admin/login")
                .defaultSuccessUrl("/")
                .failureUrl("/")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .permitAll();
        http
                .csrf()
                .disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder)
                .and()
                .jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("SELECT USER_ID, USERNAME, EMAIL, PASSWORD, FIRST_NAME, LAST_NAME, BIRTHDAY, LAST_LOGIN, CREATE_USER, CREATED, UPDATE_USER, UPDATED, ACTIVE_KBN FROM M_USER WHERE USERNAME= ? AND ACTIVE_KBN=1;")
                .authoritiesByUsernameQuery("SELECT mr.ROLE_ID, mr.ROLE_NAME, mr.DISPLAY_NAME, mr.DESCRIPTION, mr.CREATE_USER, mr.CREATED, mr.UPDATE_USER, mr.UPDATED, mr.ACTIVE_KBN FROM M_ROLE mr LEFT JOIN R_USER_ROLE rur ON mr.ROLE_ID = rur.ROLE_ID LEFT JOIN M_USER mu ON rur.USER_ID=mu.USER_ID WHERE mu.USERNAME=? AND mr.ACTIVE_KBN=1 AND rur.ACTIVE_KBN=1 AND mu.ACTIVE_KBN=1");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/WEB-INF/static/**/**");
    }
}
