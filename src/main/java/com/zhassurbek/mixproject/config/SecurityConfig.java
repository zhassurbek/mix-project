//package com.zhassurbek.mixproject.config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import java.lang.reflect.Method;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
////    @Bean
////    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
////        httpSecurity.authorizeRequests()
////                .anyRequest().permitAll();
////        return httpSecurity.build();
////    }
//
//    @Bean
//    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(requests -> requests
//                .requestMatchers(new AntPathRequestMatcher("/mix-spring/**")).permitAll()
//                .anyRequest().authenticated());
//        return http.build();
//    }
////
////    @Bean
////    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
////        http
////                .csrf().disable()
////                .authorizeHttpRequests(requests -> requests
////                        .requestMatchers(HttpMethod.GET, "/", "/static/**", "/index.html", "/api/users/me").permitAll()
////                        .requestMatchers(HttpMethod.POST, "/api/users").permitAll()
////                        .requestMatchers(HttpMethod.GET, "/api/users/login", "/api/users/{username}", "/api/users/logout", "/api/customers", "/api/storages").authenticated()
////                        .requestMatchers(HttpMethod.POST, "/api/customers", "/api/storages").authenticated()
////                        .requestMatchers(HttpMethod.PUT, "/api/customers/{id}", "/api/storages/{id}").authenticated()
////                        .requestMatchers(HttpMethod.DELETE, "/api/users/{id}", "/api/storages/{id}", "/api/customers/{id}").authenticated()
////                        .anyRequest().denyAll())
////                .httpBasic();
////        return http.build();
////    }
//
//}
////
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.http.HttpMethod;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.web.SecurityFilterChain;
////
////@Configuration
////@EnableWebSecurity
////public class SecurityConfig {
////
////    @Bean
////    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
////        httpSecurity.
////                authorizeHttpRequests()
////                .requestMatchers(HttpMethod.POST, "/mix-spring/**").permitAll();
////        return httpSecurity.build();
////
////    }
////
////}
