package com.example.demo.member.util;

import com.example.demo.config.security.vo.SecurityMemberVO;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * 로그인한 유저의 정보를 가져오는 유틸 클래스(세션에서 가져옴)
 *
 */
public class SecurityUtils {

    /**
     * 로그인한 유저의 id
     *
     * @return
     */
    public static String getCurrentLoginUserId() {
        return getLoginSessionMemberInfo().getUsername();
    }

    /**
     * 로그인한 유저의 객체
     *
     * @return
     */
    public static SecurityMemberVO getLoginSessionMemberInfo() {
        return Optional.ofNullable((SecurityMemberVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).orElseThrow(() -> new RuntimeException("로그인 상태가 아닙니다."));
    }

    /**
     * 로그인한 유저의 권한
     *
     * @return
     */
    public static String getCurrentLoginUserRole() {
        return getLoginSessionMemberInfo().getAuthorities().stream().map(SimpleGrantedAuthority::getAuthority).collect(toList()).get(0); // 최초 기획에서 유저의 권한은 항상 한개만 가질 수 있다고 정의함.
    }


}
