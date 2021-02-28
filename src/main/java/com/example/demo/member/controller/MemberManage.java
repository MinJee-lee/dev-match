package com.example.demo.member.controller;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.service.MemberService;
import com.example.demo.member.service.dao.MemberDAO;
import com.example.demo.member.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class MemberManage {

    private final MemberDAO memberDAO;
    private final MemberService memberService;

    /**
     * 회원 목록
     *
     * @param param
     * @return
     */
    @GetMapping("/member/list")
    public String list(@Valid MemberDTO.GetListReqDTO param, Model model) {

        List<MemberVO> memberList = memberDAO.selectMemberList(param.convertSignUpDTOToMemberVO());

        model.addAttribute("memberList", memberList);

        return "admin/manage/member";
    }

    //신고회원 조회
    @GetMapping("/member/list/report")
    public String list(@Valid MemberDTO.GetListReportReqDTO param, Model model) {

        List<MemberVO> memberReportList = memberDAO.selectMemberReportList(param.convertSignUpDTOToMemberVO());

        model.addAttribute("memberReportList", memberReportList);

        return "admin/manage/report";
    }

    @GetMapping("/member/list/dormant")
    public String list(@Valid MemberDTO.GetListDormantReqDTO param, Model model) {

        List<MemberVO> memberDormantList = memberDAO.selectMemberDormantList(param.convertSignUpDTOToMemberVO());

        model.addAttribute("memberDormantList", memberDormantList);

        return "admin/manage/dormant";
    }

    @GetMapping("/member/list/black")
    public String list(@Valid MemberDTO.GetListBlackReqDTO param, Model model) {

        List<MemberVO> memberBackList = memberDAO.selectMemberBackList(param.convertSignUpDTOToMemberVO());

        model.addAttribute("memberBlackList", memberBackList);

        return "admin/manage/black";
    }

    @GetMapping("/withdrawal")
    public String withdrawal(@RequestParam("userId") String userId) {
        memberService.deleteMember(userId);
        return "admin/manage/withdrawal";
    }

    @GetMapping("/changeDormant")
    public String changeDormant(@Valid MemberDTO.GetListBlackReqDTO param,@RequestParam("userId") String userId, Model model) {
        memberService.changeDormant(userId);
        List<MemberVO> memberBackList = memberDAO.selectMemberBackList(param.convertSignUpDTOToMemberVO());

        model.addAttribute("memberBlackList", memberBackList);
        return "admin/manage/changeDormant";
    }

    @GetMapping("/changeNormal")
    public String changeNormal(@Valid MemberDTO.GetListDormantReqDTO param,@RequestParam("userId") String userId, Model model) {
        memberService.changeNormal(userId);
        List<MemberVO> memberDormantList = memberDAO.selectMemberDormantList(param.convertSignUpDTOToMemberVO());
        model.addAttribute("memberDormantList", memberDormantList);
        return "admin/manage/changeNormal";
    }

}


