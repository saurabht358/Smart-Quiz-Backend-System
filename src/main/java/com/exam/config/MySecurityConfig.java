package com.exam.config;


import com.exam.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class MySecurityConfig {

 @Autowired
 JwtAuthenticationEntryPoint unauthorizedHandler;

 @Autowired
 JwtAuthenticationFilter jwtAuthenticationFilter;

 @Autowired
 private UserDetailsServiceImpl userDetailsServiceImpl;

// @Bean
// public PasswordEncoder passwordEncoder() {
//  return NoOpPasswordEncoder.getInstance();
// }

// NoOpPasswordEncoder Implementation (without securing the password)
 /**
@Bean
public PasswordEncoder passwordEncoder() {
 return new PasswordEncoder() {
  @Override
  public String encode(CharSequence rawPassword) {
   return rawPassword.toString();  // Returns the raw password
  }

  @Override
  public boolean matches(CharSequence rawPassword, String encodedPassword) {
   return rawPassword.toString().equals(encodedPassword);  // Direct comparison
  }
 };
}
*/

 @Bean
 public BCryptPasswordEncoder passwordEncoder(){
  return new BCryptPasswordEncoder();
 }




 @Bean
 public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
  return configuration.getAuthenticationManager();
 }

 @Bean
 public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
  http
          .csrf(csrf -> csrf.disable())
          .cors(cors -> cors.disable())
          .authorizeHttpRequests(auth -> auth
                  .requestMatchers("/generate-token", "/user/").permitAll()
                  .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                  .anyRequest().authenticated()
          )
          .exceptionHandling(exception -> exception
                  .authenticationEntryPoint(unauthorizedHandler)
          )
          .sessionManagement(session -> session
                  .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
          );

   http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
  return http.build();
  }
}
