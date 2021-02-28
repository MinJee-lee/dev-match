package com.example.demo.portfolio.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
public class PortfolioVO {
    private int portNo;
    private String userId;
    private int projectNo;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date portProjectStartDate;  //포트포리오에 등록할 프로젝트 시작 날짜
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date portProjectEndDate;    //포트포리오에 등록할 프로젝트 종료 날짜
    private String portDescription;     //설명글
    private String portTitle;           //포트폴리오 제목
    private int portMemberCnt;          //프로젝트 참가 총 인원 수
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date regDate;
    private String portThumbnailImg;    //대표 이미지
    private String portFileName;        //첨부파일
    private String portSkillTag;

}




