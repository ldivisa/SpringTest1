package org.hopto.demo.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class KeycloakSecurityConfig {
        private static final String GROUPS = "groups";
        private static final String REALM_ACCESS_CLAIM = "realm_access";
        private static final String ROLES_CLAIM = "roles";

        private final KeycloakLogoutHandler keycloakLogoutHandler;

        public KeycloakSecurityConfig(KeycloakLogoutHandler keycloakLogoutHandler){
            this.keycloakLogoutHandler = keycloakLogoutHandler;
        }

@Bean
public SecurityFilterChain resourceServerFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(auth-> auth
        .requestMatchers(new AntPathRequestMatcher("/api/arquivos/**"))
        .hasRole("user")
        .requestMatchers(new AntPathRequestMatcher("/"))
        .permitAll()
        .anyRequest()
        .authenticated());
    http.oauth2ResourdeServer((oauth2) -> oauth2
        .jwt(Customizer.withDefaults()));
    http.oauth2Login(Customizer.withDefaults())
        .logout(logout -> logout.addLogoutHandler(keycloakLogoutHandler).logoutSuccessUrl("/"));
    return http.build();
    


}
}
