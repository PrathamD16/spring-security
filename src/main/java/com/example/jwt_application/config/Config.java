package com.example.jwt_application.config;

import com.example.jwt_application.service.JWTService;
import com.example.jwt_application.service.MyUserDetailService;
import com.example.jwt_application.service.StudentService;
import com.example.jwt_application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class Config {

    @Autowired
//    UserDetailsService userDetailsService;
    MyUserDetailService myUserDetailService;

    @Bean
    public StudentService studentService(){
        return new StudentService();
    }

    @Bean
    public UserService userService(){
        return new UserService();
    }

    @Bean
    public JWTService jwtService(){return new JWTService();}

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.
                csrf(x -> x.disable())
                .authorizeHttpRequests(req -> req
                        .requestMatchers(
                                new AntPathRequestMatcher("/register"),
                                new AntPathRequestMatcher("/login"))
                        .permitAll()
                        .anyRequest().authenticated())
                .formLogin(x -> x.disable())
                .httpBasic(Customizer.withDefaults())

                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        provider.setUserDetailsService(myUserDetailService);
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }

}
