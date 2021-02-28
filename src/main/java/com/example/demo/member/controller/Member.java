package com.example.demo.member.controller;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class Member {

    private final MemberService memberService;

    /**
     * 로그인 페이지
     *
     * @return
     */

    @GetMapping("/login")
    public String loginPage() {

        return "login";
    }

    // 회원 가입 페이지
    @GetMapping("/signUp")
    public String signUpPage() {
        return "signUp";
    }

    // 회원 가입 요청
    @PostMapping("/signUp")
//    @ResponseBody
//    public ResponseEntity<Object> signUpReq(@Valid MemberDTO.SignUpDTO param) {
//        System.out.println(param.getName());
//
//        return memberService.signUp(param) ? ResponseEntity.ok().body("회원이 되신걸 축하합니다.") :
//                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버에 문제가 발생해 회원 가입에 실패 했습니다.");
    public String signUpReq(@Valid MemberDTO.SignUpDTO param) {
        if (memberService.signUp(param)) {
            return "/login";
        }else{
            return "/signUp";
        }
    }

    @GetMapping("/member/idCheck")
    @ResponseBody
    public int idCheck(@RequestParam("userId") String userId) {
        return memberService.userIdCheck(userId);
    }

    @GetMapping("/login/password/settings")
    public String changePassword() {
        return "member/manage/findPassword1";
    }


}

