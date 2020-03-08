package com.metao.persoinfo.config;

import com.metao.persoinfo.handler.PersoInfoAccessDeniedHandler;
import com.metao.persoinfo.handler.PersoInofAuthenticationEntryPoint;
import com.metao.persoinfo.util.AuthoritiesConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  private final TokenProvider tokenProvider;

  private final CorsFilter corsFilter;
  private static String[] GLOBAL_ACCESS_POINTS = new String[]{"/api/register", "/api/authenticate", "/api/activate",
    "/api/account/reset-password/init", "/api/account/reset-password/finish", "/assets/*", "/management/health",
    "/management/info", "/management/prometheus"
  };

  public SecurityConfiguration(TokenProvider tokenProvider, CorsFilter corsFilter) {
    this.tokenProvider = tokenProvider;
    this.corsFilter = corsFilter;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring()
      .antMatchers(HttpMethod.OPTIONS, "/**")
      .antMatchers("/app/**/*.{js,html}")
      .antMatchers("/i18n/**")
      .antMatchers("/content/**")
      .antMatchers("/h2-console/**")
      .antMatchers("/swagger-ui/index.html")
      .antMatchers("/test/**");
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    // @formatter:off
    http
      .csrf()
      .disable()
      .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
      .exceptionHandling()
      .authenticationEntryPoint(new PersoInofAuthenticationEntryPoint())
      .accessDeniedHandler(new PersoInfoAccessDeniedHandler())
      .and()
      .headers()
      .frameOptions()
      .disable()
      .and()
      .sessionManagement()
      .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      .and()
      .authorizeRequests()
      .antMatchers(GLOBAL_ACCESS_POINTS).permitAll()
      .antMatchers("/api/**").authenticated()
      .antMatchers("/management/**").hasAuthority(AuthoritiesConstants.ADMIN)
      .and()
      .apply(securityConfigurerAdapter());
    // @formatter:on
  }

  private JWTConfigurer securityConfigurerAdapter() {
    return new JWTConfigurer(tokenProvider);
  }

}
