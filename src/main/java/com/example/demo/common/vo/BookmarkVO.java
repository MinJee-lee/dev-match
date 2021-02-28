package com.example.demo.common.vo;

import com.example.demo.community.vo.PostVO;
import com.example.demo.project.vo.ProjectVO;

public class BookmarkVO {
    private int bookmarkNo;
    private String userId;
    private ProjectVO project;
    private PostVO post;

    public int getBookmarkNo() {
        return bookmarkNo;
    }

    public void setBookmarkNo(int bookmarkNo) {
        this.bookmarkNo = bookmarkNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ProjectVO getProject() {
        return project;
    }

    public void setProject(ProjectVO project) {
        this.project = project;
    }

    public PostVO getPost() {
        return post;
    }

    public void setPost(PostVO post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "BookmarkVO{" +
                "bookmarkNo=" + bookmarkNo +
                ", userId='" + userId + '\'' +
                ", project=" + project +
                ", post=" + post +
                '}';
    }

}
