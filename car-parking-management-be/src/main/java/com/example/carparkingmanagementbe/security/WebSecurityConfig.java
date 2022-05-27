package com.example.carparkingmanagementbe.security;//package com.example.carparkingmanagementbe.Security;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.userDetailsService();
//    }
//
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(12);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http.csrf()
////                .disable()
////                .authorizeRequests()
////                .antMatchers("/api/public/**")
////                .permitAll()
////                .antMatchers("/api/user/**").hasAnyRole("USER","ADMIN")
////                .antMatchers("api/admin/**").hasRole("ADMIN")
////                .anyRequest()
////                .authenticated()
////                .and()
////                .sessionManagement()
////                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
////        http.addFilterBefore(, UsernamePasswordAuthenticationFilter.class);
//    }
//}
