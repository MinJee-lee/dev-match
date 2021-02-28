package com.example.demo.project.dto;

import lombok.Data;

import java.util.List;

@Data
public class AddReviewDTO {

    private List<AddReviewDTO> reviewList;
    private int projectNo;
    private int reviewGrade;
    private String reviewComment;
    private String userId;

}
