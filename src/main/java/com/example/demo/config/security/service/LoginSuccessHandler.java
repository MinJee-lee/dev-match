package com.example.demo.config.security.service;

import com.example.demo.config.security.vo.SecurityMemberVO;
import com.example.demo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private final MemberService memberService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        // IP, 세션 ID
        WebAuthenticationDetails web = (WebAuthenticationDetails) authentication.getDetails();
        log.info("IP : {}", web.getRemoteAddress());
        log.info("Session ID : {}", web.getSessionId());

        // 인증 ID
        SecurityMemberVO member = (SecurityMemberVO) authentication.getPrincipal();
        log.info("username : {}", member.getUsername());
        log.info("role : {}", member.getAuthorities().stream().map(SimpleGrantedAuthority::getAuthority).collect(Collectors.joining(", ")));

        memberService.loginFailCountInitialize(member.getUsername()); // 실패이력 초기화
        request.getSession().setAttribute("user",memberService.selectMember(member.getUsername()));

        response.sendRedirect("/welcome");




    }

}


