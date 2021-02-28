package com.example.demo.community.service;

import com.example.demo.common.vo.SearchVO;
import com.example.demo.community.vo.PostVO;
import com.example.demo.community.vo.ReplyVO;

import java.util.Map;

public interface PostService {

    //게시물 등록
    public void addPost(PostVO postVO);

    //reply등록/조회
    public ReplyVO addReply(ReplyVO replyVO);
//    public ReplyVO addReply(int replyNo);
//    public ReplyVO getReply(String replyUserId);

    //    게시물 상세조회(postNo로 데이터 조인값 불러오기)
    public PostVO getPost(int postNo);
    
//    게시물 수정
    public void updatePost(PostVO postVO);

//    reply수정
    public int updateReply(ReplyVO replyVO);

//    게시물 삭제
//    public void deletePost(PostVO postVO);
    public void deletePost(int postNo);

//    reply삭제
    public int deleteReply(int replyNo);

//    게시물목록조회
    public Map<String, Object> getPostList(SearchVO searchVO);
//    public List<PostVO> getPostList(PostVO postVO);

    //조회수 +1
    public int plusViewCnt(int postNo);
}
