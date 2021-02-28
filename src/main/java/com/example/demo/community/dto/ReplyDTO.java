package com.example.demo.community.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReplyDTO {
    private int postNo;
    private String replyUserId;
    private Date regDate;
    private String replyContent;
}
