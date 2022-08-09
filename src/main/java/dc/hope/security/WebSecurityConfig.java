package dc.hope.security;

import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class WebSecurityConfig {

  @Bean
  public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{

    http
    .httpBasic()
    .and()
    .authorizeRequests()
    .antMatchers(HttpMethod.POST, "/cliente/**")
    .permitAll()
    .anyRequest()
    .authenticated()

    .and()
    .sessionManagement()
    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

    .and()
    .csrf().disable();

    return http.build();

  }


  
}
