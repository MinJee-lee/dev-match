package com.example.demo.member.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReportVO {

    private int reportNo;
    private int postNo;
    private int replyNo;
    private String reportDate;
    private String reporterUserId;
    private String targetUserId;
    private String reportType;
    private String reportTarget;

    /**
     * 신고 상세 내역 조회 생성자
     * @param reportNo
     * @param postNo
     * @param replyNo
     * @param reportDate
     * @param reporterUserId
     * @param targetUserId
     * @param reportType
     * @param reportTarget
     */

    public ReportVO(int reportNo, int postNo, int replyNo, String reportDate,
                    String reporterUserId, String targetUserId, String reportType, String reportTarget) {
        this.reportNo = reportNo;
        this.postNo = postNo;
        this.replyNo = replyNo;
        this.reportDate = reportDate;
        this.reporterUserId = reporterUserId;
        this.targetUserId = targetUserId;
        this.reportType = reportType;
        this.reportTarget = reportTarget;
    }
}
