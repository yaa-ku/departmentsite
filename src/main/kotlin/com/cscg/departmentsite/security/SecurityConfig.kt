package com.cscg.departmentsite.security

import com.cscg.departmentsite.service.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer.AuthorizationManagerRequestMatcherRegistry
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class WebSecurityConfig(private val userDetailsService: AccountService) {

    @Autowired
    @Throws(Exception::class)
    fun configureGlobal(auth: AuthenticationManagerBuilder) {

        auth.userDetailsService<UserDetailsService?>(userDetailsService).passwordEncoder(passwordEncoder())
    }

    @Bean
    @Throws(java.lang.Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain? =
        http.cors().and().csrf().disable().httpBasic().and().formLogin()
            .and()
            .authorizeHttpRequests {
                it.antMatchers("/account*", "*add").hasAnyRole("ADMIN")
                    .anyRequest()
                    .permitAll()
            }

            .httpBasic(withDefaults())
            .build()

    companion object{
        @Bean
        fun passwordEncoder(): BCryptPasswordEncoder = BCryptPasswordEncoder()
    }
}