package com.example.demo.community.controller;

import com.example.demo.community.service.PostService;
import com.example.demo.community.vo.ReplyVO;
import com.example.demo.member.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/comm")
@Slf4j
public class CommunityRest {

    @Autowired
    @Qualifier("postServiceImpl")
    private PostService postService;

    public CommunityRest(PostService postService){
        log.info("::"+getClass().getName()+"Start::");
        this.postService = postService;
    }

    @PostMapping("/addReply")
    public ReplyVO addReply(@RequestBody ReplyVO replyVO,
                           HttpSession httpSession){
//        String sessionId = "user94";
//        replyVO.setReplyUserId(sessionId);

        replyVO.setReplyUserId(((MemberVO) httpSession.getAttribute("user")).getUserId());

//        postService.addReply(replyVO);

        return postService.addReply(replyVO);
    }

    @PostMapping("/updateReply")
//    ResponseEntity : 데이터롸 서버의 처리상태( 200 - 정상처리/ 500 - 오류/ 405 - 요청관련 오류)를 함께 넘겨준다.
    public int updateReply(@RequestBody ReplyVO replyVO){
        log.info("::"+getClass().getName()+"start::");
//        try{
//            replyVO.getReplyNo();
//            postService.updateReply(replyVO);
//            return new ResponseEntity<>("수정완료",HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//        String sessionId = "user94";
//        replyVO.setReplyUserId(sessionId);

//        replyVO.setReplyUserId(((MemberVO) httpSession.getAttribute("user")).getUserId());

//        postService.updateReply(replyVO);

        return postService.updateReply(replyVO);

    }

    @GetMapping(value = "/deleteReply")
    public int deleteReply(@RequestParam("replyNo") int replyNo){

        return postService.deleteReply(replyNo);
    }

}
