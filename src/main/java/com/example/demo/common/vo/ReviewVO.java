package com.example.demo.common.vo;

import lombok.Data;

@Data
public class ReviewVO {

    private int reviewNo;
    private int projectNo;
    private String projectName;
    private int reviewGrade;
    private String reviewComment;
    private String userId;

}
