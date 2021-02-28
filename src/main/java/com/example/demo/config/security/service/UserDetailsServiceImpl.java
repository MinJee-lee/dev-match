package com.example.demo.config.security.service;

import com.example.demo.common.cd.MemberStatusCd;
import com.example.demo.config.security.vo.SecurityMemberVO;
import com.example.demo.member.service.dao.MemberDAO;
import com.example.demo.member.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * spring security 에서 유저 인증, 인가 처리를 할 수 있게 유저 정보를 조회하는 서비스
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final MemberDAO memberDAO;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("## loadUserByUsername ##");
        MemberVO memberVO = memberDAO.selectMember(username);
        if (memberVO == null) {
            log.debug("## 계정정보가 존재하지 않습니다. ##");
            throw new UsernameNotFoundException("등록된 유저가 없습니다.");
        }

        SecurityMemberVO securityMemberVO = new SecurityMemberVO(memberVO.getUserId(), memberVO.getPassword(), memberVO.getRole());

        //유저의 각종 상태에 따른 추가 설정
        if (MemberStatusCd.BLACK.name().equals(memberVO.getStatus())) {
            securityMemberVO.setAccountNonLocked(false);
        }
        if (MemberStatusCd.DORMANT.name().equals(memberVO.getStatus())) {
            securityMemberVO.setAccountNonLocked(false);
        }

        return new SecurityMemberVO(memberVO.getUserId(), memberVO.getPassword(), memberVO.getRole());
    }
}
