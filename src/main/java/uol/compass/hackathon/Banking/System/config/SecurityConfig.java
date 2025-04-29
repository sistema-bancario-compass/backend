package uol.compass.hackathon.Banking.System.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/**").permitAll() // libera /api
                .anyRequest().authenticated() // exige login para o resto
                .and()
                .formLogin(); // mantém a tela padrão de login
        return http.build();
    }
}
