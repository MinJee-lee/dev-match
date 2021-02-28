package com.example.demo.profile.controller;

import com.example.demo.common.vo.BookmarkVO;
import com.example.demo.member.vo.MemberVO;
import com.example.demo.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/restProfile/*")
public class ProfileRest {

        @Autowired
        ProfileService profileService;


        @GetMapping("deleteBookmarkList")
        public int deleteBookmarkList(@ModelAttribute BookmarkVO bookmarkVO, HttpSession session){
            bookmarkVO.setUserId(((MemberVO)session.getAttribute("userId")).getUserId());
            int result = profileService.deleteBookmark(bookmarkVO);
            /*result 값은 Rest컨트롤러에 alert(data)에서 data에 해당됨*/
        return result;
        }


}
