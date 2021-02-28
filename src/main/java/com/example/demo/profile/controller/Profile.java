package com.example.demo.profile.controller;

import com.example.demo.common.vo.BookmarkVO;
import com.example.demo.common.vo.ReviewVO;
import com.example.demo.member.service.MemberService;
import com.example.demo.member.util.SecurityUtils;
import com.example.demo.member.vo.MemberVO;
import com.example.demo.profile.dto.ProfileDTO;
import com.example.demo.profile.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("profile/*")
@RequiredArgsConstructor
public class Profile {

    private final MemberService memberService;
    private final ProfileService profileService;

    private final String PATH = "C:\\spring-project\\src\\main\\resources\\static\\resources\\uploadImg\\";


    //기본정보 등록
    @GetMapping("addMyProfile")
    public String addMyProfileView(@RequestParam("userId") String userId, Model model){
        ProfileDTO.GetMyProfileDTO getMyProfile = profileService.getMyProfile(userId);
        model.addAttribute("profile",getMyProfile);
        return "profile/addMyProfile";
    }

    @PostMapping("addMyProfile")
    public String addMyProfile(@ModelAttribute ProfileDTO.UpdateMyProfileDTO param,
                               MultipartHttpServletRequest request,
                               HttpSession session, Model model) throws IOException {



        if (request.getFiles("imageFile").get(0).getSize() != 0) {
            List<MultipartFile> fileList = request.getFiles("imageFile");

            for (MultipartFile mf : fileList) {
                String upload = PATH+mf.getOriginalFilename();

                mf.transferTo(new File(upload));

                param.setProfileImg(mf.getOriginalFilename());
            }
        }

        param.setUserId(((MemberVO)session.getAttribute("user")).getUserId());
        profileService.updateMyProfile(param);
        model.addAttribute("profile",profileService.getMyProfile(param.getUserId()));

        session.removeAttribute("user");
        MemberVO memberVO = memberService.selectMember(SecurityUtils.getLoginSessionMemberInfo().getUsername());
        if (memberVO != null) {
            session.setAttribute("user", memberVO);
        }

        return "profile/getMyProfile";
    }

    //기본정보 조회
    @GetMapping("getMyProfile")
    public String getMyProfile(@RequestParam("userId") String userId, Model model){
        ProfileDTO.GetMyProfileDTO getMyProfile = profileService.getMyProfile(userId);

        model.addAttribute("profile",getMyProfile);
        return "profile/getMyProfile";
    }

    //admin 프로필 조회
    @GetMapping("getAdminProfile")
    public String getAdminProfile(@RequestParam("userId") String userId, Model model){
        ProfileDTO.GetAdminProfileDTO getAdminProfile = profileService.getAdminProfile(userId);
        model.addAttribute("profile",getAdminProfile);
        return "profile/getAdminProfile";
    }

    //북마크 목록조회
    @GetMapping("getBookmarkList")
    public String getBookmarkList(HttpSession session, Model model){
        String sessionId = ((MemberVO)session.getAttribute("user")).getUserId();
        List<BookmarkVO> bookmarkList = profileService.getBookmarkList(sessionId);
        model.addAttribute("bookmarkList", bookmarkList);
        for(BookmarkVO bookmarkVO : bookmarkList){
            System.out.println(bookmarkVO);
        }
        return "profile/getBookmarkList";
    }

    //리뷰 목록 조회
    @GetMapping("getReviewList")
    public String getReviewList(HttpSession session, Model model){
        /*session.setAttribute("userId",2);
        List<ReviewVO> reviewList = profileService.getReviewList((int)session.getAttribute("userId"));*/
//        List<ReviewVO> reviewList = profileService.getReviewList(((MemberVO)session.getAttribute("user")).getUserId());
        String sessionId = ((MemberVO)session.getAttribute("user")).getUserId();
        List<ReviewVO> reviewList = profileService.getReviewList(sessionId);
        model.addAttribute("reviewList",reviewList);
        return "profile/getReviewList";
    }

    //전체보기 조회
    @GetMapping("getAllMyProfile")
    public String getAllMyProfile(@RequestParam("userId") String userId, Model model){

        Map<String,Object> map = profileService.getAllMyProfile(userId);

        model.addAttribute("getAllMyProfile",map.get("getAllProfileDTO"));

        return "profile/getAllMyProfile";
    }


}
