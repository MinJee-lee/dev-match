package com.example.demo.project.dto;

import lombok.Data;

@Data
public class AddTodoDTO {
    private int todoNo;
    private int projectNo;
    private String userId;
    private String todoContent;

}
