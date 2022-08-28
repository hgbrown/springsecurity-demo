@file:Suppress("DEPRECATION") // use of NoOpPasswordEncoder only used in demo

package dev.hbrown.springsecuritydemo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.provisioning.UserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun userDetailsManager(): UserDetailsManager = InMemoryUserDetailsManager(
        User.withUsername("user").password("password").authorities("USER").build(),
        User.withUsername("admin").password("password").authorities("ADMIN").build(),
    )

    @Bean
    fun passwordEncoder(): PasswordEncoder = NoOpPasswordEncoder.getInstance()

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain =
        http
            .csrf { it.disable() }
            .authorizeRequests {
                it.mvcMatchers("/user").hasAuthority("USER")
                it.mvcMatchers("/admin").hasAuthority("ADMIN")
                it.mvcMatchers("/").permitAll()
                it.anyRequest().denyAll()
            }
            .httpBasic(Customizer.withDefaults())
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .build()
}
