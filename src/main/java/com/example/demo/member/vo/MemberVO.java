package com.example.demo.member.vo;

import com.example.demo.common.cd.MemberGradeCd;
import com.example.demo.common.cd.MemberStatusCd;
import com.example.demo.common.vo.ReviewVO;
import com.example.demo.member.cd.AuthorityCd;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class MemberVO implements Serializable {
    private String userId;
    private String password;
    private String email;
    private String role; // 권한
    private String name;
    private String grade; //등급
    private String status; // 회원의 상태
    private int failCnt; // 비밀번호 실패횟수
    private LocalDateTime lastLoginDate; // 마지막 로그인 일시
    private LocalDateTime regDate; // 계정 생성일시

    private Date projectWithdrawalDate; //프로젝트 탈퇴날짜
    private int projectNo; //프로젝트No
    private int projectTotalCnt; //프로젝트 총 참여 수
    private String profileImg; //회원 프로필 이미지
    private String selfIntro; //프로필_자기소개
    private List<ReviewVO> review;
    private String link;


    /**
     * 회원 가입 할때 사용하는 생성
     * (기본값을 포함한 생성자)
     *
     * @param userId
     * @param password
     * @param name
     * @param email
     */
    public MemberVO(String userId, String password, String email, String name) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.role = AuthorityCd.USER.name();
        this.status = MemberStatusCd.NORMAL.name();
        this.name = name;
        this.grade = MemberGradeCd.BRONZE.name();
    }

    /**
     * 회원 관리자 페이지에서 회원 조회를 위해 사용하는 생성자
     *
     * @param userId
     */
    public MemberVO(String userId) {
        this.userId = userId;
    }

    /**
     * 신고회원을 조회하는 생성자
     *
     * @param userId
     * @param name
     */
    public MemberVO(String userId, String name) {
        this.userId = userId;
        this.name = name;

    }

    /**
     * 비 활성화 회원을 조회하는 생성자
     *
     * @param userId
     * @param name
     * @param status
     */
    public MemberVO(String userId, String name, String status) {
        this.userId = userId;
        this.name = name;
        this.status = status;

    }


    public MemberVO(String profileImg, String selfInfo, List<String> link) {

    }
}
