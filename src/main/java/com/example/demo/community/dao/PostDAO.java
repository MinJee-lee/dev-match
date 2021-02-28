package com.example.demo.community.dao;


import com.example.demo.common.vo.SearchVO;
import com.example.demo.community.vo.PostVO;
import com.example.demo.community.vo.ReplyVO;

import java.util.List;

public interface PostDAO {

    //Post등록
    public void addPost(PostVO postVO);

    //reply등록
    public ReplyVO addReply(ReplyVO replyVO);

    //포스트 상세조회
    public PostVO getPost(int postNo);

    //reply상세조회
//    public ReplyVO getReply(String replyUserId);

    //udpatePost
    public void updatePost(PostVO postVO);

    //reply수정
    public int updateReply(ReplyVO replyVO);

    //deletePost
    public void deletePost(int postNo);

    //reply삭제
    public int deleteReply(int replyNo);

    //getPostList
    public List<PostVO> getPostList(SearchVO searchVO);
//    public List<PostVO> getPostList(PostVO postVO);

    //검색
    public int getTotalCount(SearchVO searchVO);

    public int plusViewCnt(int postNo);




}
