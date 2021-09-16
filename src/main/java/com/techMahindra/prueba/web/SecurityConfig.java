//package com.techMahindra.prueba.web;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {


//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }


//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder build) throws Exception{
//        build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }



//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                    .password("{noop}123")
//                    .roles("ADMIN", "USER")
//                .and()
//                .withUser("user")
//                    .password("{noop}123")
//                    .roles("USER")
//        ;
//
//    }

//    //Autorizacion de URL
//    protected void configure(HttpSecurity http) throws Exception{
//        http.authorizeRequests()
//                .antMatchers("/api_mesa/create")
//                    .hasRole("ADMIN")
//                .antMatchers("/api_mesa/listado", "api_usuario/create", "api_usuario/listado")
//                    .hasAnyRole("USER","ADMIN")
//                .and()
//                    .formLogin()
//                    .loginPage("/login")
//            ;
//    }
//}
