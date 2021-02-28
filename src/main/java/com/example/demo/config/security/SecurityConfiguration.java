package com.example.demo.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.session.Session;
import org.springframework.session.security.SpringSessionBackedSessionRegistry;

/**
 * spring security에 전반적인 설정을 셋팅하는 설정 클래스 정의
 */
@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final AuthenticationFailureHandler authenticationFailureHandler;
    private final AuthenticationSuccessHandler authenticationSuccessHandler;

    private final SpringSessionBackedSessionRegistry<Session> sessionRegistry;

    private final String[] ALLOW_AUTH_URI_PATTERN = {
      "/login/**",
      "/welcome"
    };

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().mvcMatchers("/resources/**");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Spring Security Filter Chain

        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();

        // 모든 리퀘스트에 대해 인증을 요구하는 설정
        http.authorizeRequests(authorize -> {

            // 로그인 관련 페이지는 권한 없는 유저도 사용할 수 있어야 함(비로그인 상태 유저도 가능해야함)
            authorize.antMatchers("/login/**", "/signUp").anonymous();

            // start uri 에 따라 필요한 권한 설정
            authorize
                    .antMatchers(ALLOW_AUTH_URI_PATTERN).hasAnyRole("ADMIN", "USER", "ANONYMOUS")
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/user/**").hasRole("USER")
                    .antMatchers("/project/**").hasRole("USER")
                    .antMatchers("/applicant/**").hasRole("USER")
                    .antMatchers("/port/**").hasRole("USER")
                    .antMatchers("/comm/**").hasRole("USER");

        });


        http.formLogin()
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .loginPage("/login") // 로그인 페이지 설정
                .usernameParameter("username") // 로그인 페이지의 id에 해당하는 부분의 name attribute
                .passwordParameter("password") // 로그인 페이지의 password에 해당하는 부분의 name attribute
                .loginProcessingUrl("/login/req") // 로그인 요청시 사용하는 uri(로그인 페이지의 로그인 요청 버튼의 uri 임)
//                .defaultSuccessUrl("/loginSuccess") // 로그인 성공 시 이동할 경로
//                .failureUrl("/login?error=true") // 인증에 실패했을 때 보여주는 화면 url, 로그인 form으로 파라미터값 error=true로 보냄
        ;



        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true);


        http.sessionManagement((management) ->
           management
                   .maximumSessions(2)
                   .maxSessionsPreventsLogin(false)
                   .expiredUrl("/login")
                   .sessionRegistry(this.sessionRegistry) // 위에 세션 관리 정책들을 적용하는 타겟 세션 레포지토리 설정.
//                    .expiredSessionStrategy() // default 전략은 LAST_ACCESS_TIME이 마지막인 세션이 expired됨.
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 인증 처리하는 클래스 필요한 설정 추가 빈 등록
     */
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(@Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setHideUserNotFoundExceptions(false);
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

}
