package com.example.demo.member.service.impl;


import com.example.demo.common.cd.MemberStatusCd;
import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.service.MemberService;
import com.example.demo.member.service.dao.MemberDAO;
import com.example.demo.member.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    public static final int MAX_FAILED_ATTEMPTS = 3;
    private static final long LOCK_TIME_DURATION = 24 * 60 * 60 * 1000; // 24 hours

    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MemberDAO memberDAO;

    @Override
    public ResponseEntity<Object> loginReq(String id, String password) {
        // id가 존재하지 않는 경우
        if (false) {
            return ResponseEntity.badRequest().body("아이디가 존재하지 않습니다.");
        }

        // password fail
        if (false) {
            return ResponseEntity.badRequest().body("비밀번호가 틀렸습니다.");
        }

        return ResponseEntity.ok().body("로그인 성공");
    }

    //회원가입
    @Override
    @Transactional
    public boolean signUp(MemberDTO.SignUpDTO signUpDTO) {

        signUpDTO.setPassword(passwordEncoder.encode(signUpDTO.getPassword())); // 비밀번호 단방향 암호화

        int dbResult = memberDAO.addMember(signUpDTO.convertSignUpDTOToMemberVO());
        if (dbResult != 1) { // transaction rollback을 위해서 의도적으로 예외처리를 함.
            throw new RuntimeException();
        }

        return true;
    }

    @Override
    public ResponseEntity<Object> logOutReq(String userId, String password) {
        return null;
    }

    //회원탈퇴
    @Override
    @Transactional
    public boolean withdrawal(MemberDTO.WithdrawalDTO withdrawalDTO) {

        withdrawalDTO.setPassword(passwordEncoder.encode(withdrawalDTO.getPassword()));

        int dbResult = memberDAO.deleteMember(withdrawalDTO.convertSignUpDTOToMemberVO());
        if (dbResult != 1) {
            throw new RuntimeException();
        }
        return true;
    }

    //이메일 중복체크
    public boolean userEmailCheck(String Email, String Name) {

        MemberVO user = memberDAO.findUserByUserId(Email);
        if (user != null && user.getName().equals(Name)) {
            return true;
        } else {
            return false;
        }
    }

    //아이디 중복체크
    @Override
    public int userIdCheck(String userId) {
        return memberDAO.checkOverId(userId);
    }

    @Override
    public MemberVO selectMember(String userId) {
        return memberDAO.selectMember(userId);
    }

    /**
     * 로그인 실패 - 비밀번호가 틀린경우, 로그인 실패 이력 업데이트
     * @param userId
     * @return
     */
    @Override
    public int loginFailCountIncrease(String userId) {
        return memberDAO.loginFailCountIncrease(userId);
    }

    /**
     * 유저의 로그인 실패 이력 조회
     * @param userId
     * @return
     */
    @Override
    public int getLoginFailCount(String userId) {
        return memberDAO.getLoginFailCount(userId);
    }


    /**
     * 로그인 성공일때 fail count 초기화
     * @param userId
     * @return
     */
    @Override
    public int loginFailCountInitialize(String userId) {
        return memberDAO.loginFailCountInitialize(userId);
    }

    @Override
    public int deleteMember(String userId) {
        return memberDAO.deleteMember(userId);
    }

    @Override
    public int changeDormant(String userId) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("memberStatus", MemberStatusCd.DORMANT);
        return memberDAO.changeDormant(map);
    }

    @Override
    public int changeNormal(String userId) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("memberStatus", MemberStatusCd.NORMAL);
        return memberDAO.changeNormal(map);
    }

}



