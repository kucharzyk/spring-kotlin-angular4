package com.shardis.config

import com.shardis.ShardisProperties
import com.shardis.support.security.handlers.JwtAuthenticationEntryPoint
import com.shardis.support.security.filters.JwtAuthenticationTokenFilter
import com.shardis.support.security.handlers.JwtAuthenticationFailureHandler
import com.shardis.support.security.handlers.JwtAuthenticationLogoutHandler
import com.shardis.support.security.handlers.JwtAuthenticationSuccessHandler
import com.shardis.services.jwt.JwtTokenAuthService
import com.shardis.services.security.ShardisUserDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
open class SecurityConfig(
    private val jwtAuthenticationEntryPoint: JwtAuthenticationEntryPoint,
    private val shardisProperties: ShardisProperties,
    private val jwtTokenAuthService: JwtTokenAuthService,
    private val shardisUserDetailsService: ShardisUserDetailsService,
    private val jwtAuthenticationSuccessHandler: JwtAuthenticationSuccessHandler,
    private val jwtAuthenticationFailureHandler: JwtAuthenticationFailureHandler,
    private val jwtAuthenticationLogoutHandler: JwtAuthenticationLogoutHandler
) : WebSecurityConfigurerAdapter(false) {


    @Bean
    open fun passwordEncoder(): PasswordEncoder {
        return Pbkdf2PasswordEncoder(shardisProperties.security.passwordSecret)
    }

    @Bean
    open fun jwtAuthenticationTokenFilter(): JwtAuthenticationTokenFilter {
        return JwtAuthenticationTokenFilter(shardisProperties, jwtTokenAuthService)
    }

    @Autowired
    open fun configureGlobal(auth: AuthenticationManagerBuilder) {
        auth
            .userDetailsService(shardisUserDetailsService)
            .passwordEncoder(passwordEncoder())
    }

    override fun configure(httpSecurity: HttpSecurity) {
        httpSecurity
            .httpBasic()
            .disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .formLogin()
            .loginProcessingUrl("/api/authentication")
            .successHandler(jwtAuthenticationSuccessHandler)
            .failureHandler(jwtAuthenticationFailureHandler)
            .usernameParameter("username")
            .passwordParameter("password")
            .permitAll()
            .and()
            .logout()
            .logoutUrl("/api/logout")
            .logoutSuccessHandler(jwtAuthenticationLogoutHandler)
            .permitAll()
            .and()
            .authorizeRequests()
            .antMatchers("/api/test").permitAll()
            .antMatchers("/api/auth/**").permitAll()
            .antMatchers("/api/protected/**").hasRole("USER")
            .antMatchers("/api/**").authenticated()
            .anyRequest().permitAll()
            .and()
            .csrf()
            .disable()
            .anonymous()
            .and()
            .exceptionHandling()
            .authenticationEntryPoint(jwtAuthenticationEntryPoint)
            .and()
            .headers()
            .frameOptions()
            .disable()
            .and()
            .addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter::class.java)

    }


}
