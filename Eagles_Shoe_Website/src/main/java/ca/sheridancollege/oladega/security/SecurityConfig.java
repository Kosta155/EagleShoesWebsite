package ca.sheridancollege.oladega.security;

import org.springframework.context.annotation.Bean;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

	private AccessDeniedHandler accessDenied;
	private UserDetailsServiceImpl userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		BCryptPasswordEncoder  encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	

	@Bean
	public AuthenticationManager authManager(HttpSecurity http,
			PasswordEncoder passwordEncoder) throws Exception 
	{
		AuthenticationManagerBuilder authenticationManagerBuilder =
				http.getSharedObject(AuthenticationManagerBuilder.class);
		
		authenticationManagerBuilder.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder);
		return authenticationManagerBuilder.build();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		//Delete when switching to production code
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
		http.authorizeHttpRequests((authz)->authz
				.requestMatchers(antMatcher("/addPage")).hasRole("ADMIN")
				.requestMatchers(antMatcher("/addPageSubmition")).hasRole("ADMIN")
				.requestMatchers(antMatcher("/home/registrationPage")).permitAll()
				.requestMatchers(antMatcher("/register")).permitAll()
				.requestMatchers(antMatcher("/images/**")).permitAll()
				.requestMatchers(antMatcher("/css/**")).permitAll()
				.requestMatchers(antMatcher("/viewPage")).hasAnyRole("ADMIN","MEMBER")
				.requestMatchers(antMatcher("/edit/**")).hasRole("ADMIN")
				.requestMatchers(antMatcher("/edit")).hasRole("ADMIN")
				.requestMatchers(antMatcher("/delete/**")).hasRole("ADMIN")
				.requestMatchers(antMatcher("/h2-console/**")).permitAll()
				.requestMatchers(antMatcher("/")).permitAll()
				.requestMatchers(antMatcher("/home/**")).permitAll()
				.requestMatchers(antMatcher("/Script/**")).permitAll()
				.requestMatchers(antMatcher("/getFavorites")).permitAll()
				.anyRequest().authenticated()
				)
		.formLogin((formLogin)->formLogin
				.loginPage("/login")
				.defaultSuccessUrl("/", true)
				.failureUrl("/login?failed")
				.permitAll()
				)
		.logout((logout)->logout
				.deleteCookies("remove")
				.invalidateHttpSession(true)
				.logoutUrl("/logout")
				.logoutSuccessUrl("/?logout")
				.permitAll()
				)
		.exceptionHandling((ex)->
		
			ex.accessDeniedHandler(accessDenied)
		
		);
		return  http.build();
				
	}
	
}
