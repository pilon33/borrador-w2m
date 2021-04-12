package test.w2m.jfvTest.config.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * This class configures security to the API
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Value("${test.w2m.user.username}")
  private String superUsername;
  @Value("${test.w2m.user.password}")
  private String superPassword;

  @LocalServerPort
  private int port;
  
  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
            .withUser(superUsername)
            .password(passwordEncoder().encode(superPassword)).roles("ADMIN");
  }

  @Override
	protected void configure(HttpSecurity http) throws Exception {
	 
	
	  
		http.authorizeRequests().antMatchers("/").permitAll().and().authorizeRequests().antMatchers("/console/**")
				.permitAll();
		http.csrf().disable();
		http.headers().frameOptions().disable();

		http.authorizeRequests().antMatchers("/").permitAll().and().authorizeRequests().antMatchers("/actuator/**")
				.permitAll();
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
		http.authorizeRequests().antMatchers("/").permitAll().and().authorizeRequests().antMatchers("/super-heroes/create/**").permitAll();
		http.csrf().disable();
		http.headers().frameOptions().disable();

	}
  
  

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
