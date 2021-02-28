package com.example.demo.project.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProjectSearchDTO {
    private int currentPage;
    private List<Integer> projectCategory;
    private List<Integer> meetingMethod;
    private int searchCondition;
    private List<Integer> projectStatus;
    private String searchKeyword;
    private int pageSize;
    private int endRowNum;
    private int startRowNum;
    private int sort;
    private String userId;

    public int getEndRowNum() {
        return getCurrentPage()*getPageSize();
    }

    public void setEndRowNum(int endRowNum) {
        this.endRowNum = endRowNum;
    }

    public int getStartRowNum() {
        return (getCurrentPage()-1)*getPageSize()+1;
    }

    public void setStartRowNum(int startRowNum) {
        this.startRowNum = startRowNum;
    }
}
