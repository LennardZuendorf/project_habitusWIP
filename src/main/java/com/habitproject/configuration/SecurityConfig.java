package com.habitproject.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

import java.net.URI;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    ClientRegistrationRepository clientRegistrationRepository;

    OidcClientInitiatedLogoutSuccessHandler oidcLogoutSuccessHandler() {
        OidcClientInitiatedLogoutSuccessHandler successHandler = new OidcClientInitiatedLogoutSuccessHandler(clientRegistrationRepository);
        successHandler.setPostLogoutRedirectUri(URI.create("https://habit-project.herokuapp.com/"));
        return successHandler;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()

                // public pages
                .antMatchers(
                        Endpoints.Site.INDEX,
                        Endpoints.Site.SLASH,
                        Endpoints.Site.LOGIN,
                        Endpoints.Site.DASH
                ).permitAll()
                // static resources
                .antMatchers(
                        "/css/**",
                        "/img/**",
                        "/js/**"
                ).permitAll()
                .anyRequest().authenticated()

                // send the user back to the root page when they logout
                .and().logout().logoutSuccessHandler(oidcLogoutSuccessHandler())

                .and().oauth2Client()
                .and().oauth2Login().loginPage("/login");
    }

}