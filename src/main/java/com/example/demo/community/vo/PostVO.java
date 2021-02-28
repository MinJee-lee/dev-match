package com.example.demo.community.vo;


import java.util.Date;
import java.util.List;

public class PostVO {
    private int postNo;
    private String postName;
    private String postContent;
    private String commFile;
    private String userId;
    private Date regDate;
    private int replyCnt;
    private int viewCnt;
    private List<ReplyVO> PostReply;
//    private String commBookmark;

//    공지여부
//    private String noticeYn;
//    삭제여부
//    private String deleteYn;


    public PostVO() {
    }

    public int getPostNo() {

        return postNo;
    }

    public void setPostNo(int postNo) {

        this.postNo = postNo;
    }

    public String getPostName() {

        return postName;
    }

    public void setPostName(String postName) {

        this.postName = postName;
    }

    public String getPostContent() {

        return postContent;
    }

    public void setPostContent(String postContent) {

        this.postContent = postContent;
    }

    public String getCommFile() {

        return commFile;
    }

    public void setCommFile(String commFile) {

        this.commFile = commFile;
    }

    public String getUserId() {

        return userId;
    }

    public void setUserId(String userId) {

        this.userId = userId;
    }

    public Date getRegDate() {

        return regDate;
    }

    public void setRegDate(Date regDate) {

        this.regDate = regDate;
    }

    public int getReplyCnt() {

        return replyCnt;
    }

    public void setReplyCnt(int replyCnt) {

        this.replyCnt = replyCnt;
    }

    public int getViewCnt() {

        return viewCnt;
    }

    public void setViewCnt(int viewCnt) {

        this.viewCnt = viewCnt;
    }

    public List<ReplyVO> getPostReply() {
        return PostReply;
    }

    public void setPostReply(List<ReplyVO> postReply) {
        PostReply = postReply;
    }
    //    public String getCommBookmark() {
//
//        return commBookmark;
//    }
//
//    public void setCommBookmark(String commBookmark) {
//
//        this.commBookmark = commBookmark;
//    }
//    private List<ReplyVO>;

    @Override
    public String toString() {
        return "PostVO{" +
                "postNo=" + postNo +
                ", postName='" + postName + '\'' +
                ", postContent='" + postContent + '\'' +
                ", commFile='" + commFile + '\'' +
                ", userId='" + userId + '\'' +
                ", regDate=" + regDate +
                ", replyCnt=" + replyCnt +
                ", viewCnt=" + viewCnt +
                ", PostReply=" + PostReply +
                '}';
    }
}
