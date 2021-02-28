package com.example.demo.member.service;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.vo.MemberVO;
import org.springframework.http.ResponseEntity;

public interface MemberService {


    ResponseEntity<Object> loginReq(String userId, String password);

    // 해당 기능은 내부 서비스 회원만 사용하는 기능입니다.
    default boolean signUp(MemberDTO.SignUpDTO param) {
        return false;
    }

    ResponseEntity<Object> logOutReq(String userId,String password);

    default boolean withdrawal(MemberDTO.WithdrawalDTO param) {
        return false;
    }

    boolean userEmailCheck(String email, String name);

    int userIdCheck(String userId);

    MemberVO selectMember(String userId);

    /**
     * 로그인 실패 - 비밀번호가 틀린경우, 로그인 실패 이력 업데이트
     *
     *
     * @param userId
     * @return
     */
    int loginFailCountIncrease(String userId);

    /**
     * 유저의 로그인 실패 이력 조회
     *
     *
     * @param userId
     * @return
     */
    int getLoginFailCount(String userId);

    /**
     * 로그인 성공일때 fail count 초기화
     *
     *
     * @param userId
     * @return
     */
    int loginFailCountInitialize(String userId);


    int deleteMember(String userId);

    int changeDormant(String userId);

    int changeNormal(String userId);
}

