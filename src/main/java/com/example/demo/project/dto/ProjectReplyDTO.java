package com.example.demo.project.dto;

import lombok.Data;

@Data
public class ProjectReplyDTO {
    private int replyNo;
    private int projectNo;
    private String userId;
    private String replyContent;

}
