//package com.example.demo.community.dao.impl;
//
//import com.example.demo.common.vo.SearchVO;
//import com.example.demo.community.service.PostService;
//import com.example.demo.community.vo.PostVO;
//import com.example.demo.community.vo.ReplyVO;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class PostDAOImplTest {
//
//    @Autowired
//    @Qualifier("postServiceImpl")
//    private PostService postService;
//
//    public PostDAOImplTest(){
//        System.out.println("TEST APP:::::");
//    }
//
//
//    @Test
//    public void addPost(){
//        //컨트롤러단에서넘어오는 정보랑 로직쓰면됨
//        PostVO postVO = new PostVO();
//        Date today = new Date();
//
////        postVO.setPostNo(4);
//        postVO.setPostName("추가제목");
//        postVO.setPostContent("추가내용");
//        postVO.setUserId("user03");
////        postVO.setRegDate(today);
//        postVO.setReplyCnt(4);
//        postVO.setViewCnt(0);
//
//        postService.addPost(postVO);
//        //애드로직 끝
//        PostVO postVO1 = postService.getPost(11);
//        //getPost() 같이 실행해서 VO생성자 또 만듦.
//        Assert.assertEquals("user02",postVO1.getUserId());
//        //assert - 내가 기대하고 있는 값, 실제로 넣은 값.
//    }
//
//    @Test
//    public void addReply(){
//        ReplyVO replyVO = new ReplyVO();
//
//        replyVO.setPostNo(2);
//        //둘중에 하나만 넣으려면 mapper에서 해당 No 주석처리...커플링?
//        replyVO.setProjectNo(2);
//        replyVO.setReplyUserId("user01");
//        replyVO.setReplyContent("reply테스트6번째");
//
//        postService.addReply(replyVO);
//
//        PostVO postVO = postService.getPost(4);
//
//        Assert.assertEquals(1,replyVO.getPostNo());
//
//    }
//
//    @Test
//    public void getPost(){
//
//        PostVO postVO = new PostVO();
//        postVO = postService.getPost(1);
//        System.out.println("getPost() TEST::"+postVO);
//
//        Assert.assertEquals("java", postVO.getPostName());
////        Assert.assertEquals(1, postVO.getPostReply().get(0).getReplyNo());
////        Assert.assertEquals(2, postVO.getPostReply().size());
//        Assert.assertEquals(0, postVO.getReplyCnt());
//    }
//
//
//
//    @Test
//    public void getReply(){
//
//        ReplyVO replyVO = new ReplyVO();
////        replyVO = postService.getReply("user02");
//        System.out.println("getReply() TEST::"+replyVO);
//
////        Assert.assertEquals("");
////        여유있을때 한번더 공부하고 적용해보기
//    }
//
//    @Test
//    public void updatePost(){
//
//        PostVO postVO = new PostVO();
//        Date today = new Date();
//
//        postVO.setPostNo(39);
//        postVO.setPostName("프리 550 vs 정규직 연봉 6000");
//        postVO.setPostContent("택1 하라면 어느것을 하실래요?");
//        postVO.setRegDate(today);
//
//        postService.updatePost(postVO);
//        PostVO postVO1 = postService.getPost(2);
//
//        Assert.assertEquals(2,postVO1.getPostNo());
//    }
//
//    @Test
//    public void updateReply(){
//
//        ReplyVO replyVO = new ReplyVO();
//        System.out.println("테스트 replyVO생성");
//
//        replyVO.setReplyNo(2);
//        System.out.println("setReplNo설정");
//        replyVO.setReplyContent("11수정댓글");
//        System.out.println("댓글내용수정");
////        replyVO.setReplyUserId("user02");
////        replyVO.setReg_date();
//
//        postService.updateReply(replyVO);
////        System.out.println("postService인터페이스 실행");
//        PostVO postVO = postService.getPost(1);
////        System.out.println("게시글 하나 가져옴");
//
////        Assert.assertEquals(1,postVO.getPostNo());
//    }
//
//    @Test
//    public void deletePost(){
//
//        PostVO postVO = new PostVO();
//        postVO = postService.getPost(4);
//
//        postService.deletePost(postVO);
////        postVO = postService.getPost(4);
//
//    }
//
//    @Test
//    public void deleteReply(){
//
//        ReplyVO replyVO = new ReplyVO();
//        replyVO = postService.getReply("user01");
//
//        postService.deleteReply(replyVO);
//    }
//
//    @Test
//    public void getPostList(){
//
//        SearchVO searchVO = new SearchVO();
//
//        searchVO.setCurrentPage(1);
//        searchVO.setPageSize(4);
//
//        //searchConditionA 검색 조건 - 1: 포스트제목 2: 포스트내용 3: 작성자
//        searchVO.setSearchConditionA(3);
//        searchVO.setSearchKeyword("");
//
//
//        Map<String, Object> map = postService.getPostList(searchVO);
//
//        List<Object> list = (List<Object>) map.get("list");
//        System.out.println("getPostList 테스트코드::"+list);
////        Assert.assertEquals(2, list.size());
//
//        Integer totalCount = (Integer) map.get("totalCount");
//        System.out.println("getPostList 테스트코드::"+totalCount);
//    }
//
////    @Test
//////    댓글번호가 조인되서 같이 나온다. mapper부분 다시 보기
////    public void getPostList(){
////
////        PostVO postVO=new PostVO();
////
//////        postVO.setUserId("user01");
////
////        List<PostVO> getPostList01= postService.getPostList(postVO);
////        System.out.println(getPostList01.get(0).getUserId());
////    }
//}