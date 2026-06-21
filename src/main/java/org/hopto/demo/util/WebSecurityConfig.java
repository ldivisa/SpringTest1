package org.hopto.demo.util;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig { 
@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
        .withUser("luiz").roles("USER").password("{noop}1980")
            .and()
        .withUser("admin").roles("ADMIN").password("{noop}1980");
    }
@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                // Specific rule: /api/casos/** requires ROLE_USER
                .requestMatchers("/api/casos/**").hasRole("USER")
                
                // Specific rule: /api/arquivos/** requires ROLE_ADMIN
                .requestMatchers("/api/arquivos/**").hasRole("ADMIN")
                
                // General rule: All other requests require authentication
                .anyRequest().authenticated()
            )
            // Enable HTTP Basic Authentication
            .httpBasic(customizer -> {}); 

        return http.build();
    }
    }
    

/* 
Key Fixes Explained
Return Type: Changed public HttpSecurity to public SecurityFilterChain. The bean must be the built chain. 
Chaining Syntax:
Wrong: .requestMatchers(new AnyRequestMatcher(...).hasRole(...))
Right: .requestMatchers("/pattern").hasRole("ROLE")
The requestMatchers method defines what to match, and hasRole defines who can access it. They are separate method calls in the chain.
Simplified Matchers: You do not need to manually instantiate new AntPathRequestMatcher when using the String overload of requestMatchers. Spring automatically treats strings as Ant patterns (e.g., ** matches sub-paths). 
Single Authorization Block: All authorization rules should be defined inside one .authorizeHttpRequests(...) block to ensure they are evaluated in the correct order (specific rules before general rules). 
Important Notes on Roles
Prefixing: The method hasRole("USER") automatically adds the ROLE_ prefix. Spring expects the authority to be ROLE_USER. 
Authorities: If your database or identity provider grants authorities without the prefix (e.g., just USER), use hasAuthority("USER") instead. 

Spring Security 6 authorizeHttpRequests requestMatchers examples
 */

    
    
        
        

