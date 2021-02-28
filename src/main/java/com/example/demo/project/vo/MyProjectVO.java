package com.example.demo.project.vo;

import com.example.demo.member.vo.MemberVO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Getter
@ToString
@NoArgsConstructor
public class MyProjectVO {

    private int projectNo;
    private String leaderId;
    private String projectName;
    private List<MemberVO> teamMember;
    private List<TodoVO> todoList;
    private List<String> votedMember;
}
