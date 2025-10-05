package com.scm.contact.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.scm.contact.impl.SecurityCoustomUserDetailService;

@Configuration
public class SecurityConfig {

  @Autowired
  private OAuthAuthenicationSuccessHandler handler;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public DaoAuthenticationProvider authenticationProvider(SecurityCoustomUserDetailService userSecDetailService,
      PasswordEncoder passwordEncoder) {
    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    daoAuthenticationProvider.setUserDetailsService(userSecDetailService);
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
    return daoAuthenticationProvider;
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/user/**").authenticated()
            .anyRequest().permitAll())
        .formLogin(formLogin -> {
          formLogin.loginPage("/login");
          formLogin.loginProcessingUrl("/authenticate");
          formLogin.successForwardUrl("/user/profile");

          formLogin.usernameParameter("email");
          formLogin.passwordParameter("password");
        })
        .csrf(AbstractHttpConfigurer::disable)
        .logout(logoutForm -> {
          logoutForm.logoutUrl("/do-logout");
          logoutForm.logoutSuccessUrl("/login?logout=true");
        });

    // oauth coniguration
    http.oauth2Login(oauth -> {
      oauth.loginPage("/login");
      oauth.successHandler(handler);
    });

    return http.build();
  }

}
