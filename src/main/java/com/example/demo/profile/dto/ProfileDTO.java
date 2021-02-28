package com.example.demo.profile.dto;

import com.example.demo.portfolio.vo.PortfolioVO;
import lombok.Data;

import java.util.List;

public class ProfileDTO {

    //기본정보 등록
    @Data
    public static class UpdateMyProfileDTO {
        private String userId;
        private String profileImg;
        private String selfIntro;
        private String link;
        private List<String> skillHashTag;
    }

    //기본정보 조회
    @Data
    public static class GetMyProfileDTO {
        private String userId;
        private String email;
        private String name;
        private String grade;
        private int reportCnt;
        private String profileImg;
        private String selfIntro;
        private String link;
        private List<String> skillHashTag;
    }

    //관리자 프로필 조회
    @Data
    public static class GetAdminProfileDTO{
        private String userId;
        private String email;
        private String name;
        private String role;
    }

    //전체보기 조회
    @Data
    public static class GetAllProfileDTO{
        private String userId;
        private String profileImg;
        private String link;
        private String selfIntro;
        private List<PortfolioVO> portfolio;
        private List<String> skillHashTag;
    }

}
