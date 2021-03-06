package com.example.demo.profile.service;

import com.example.demo.common.vo.BookmarkVO;
import com.example.demo.common.vo.ReviewVO;
import com.example.demo.profile.dto.ProfileDTO;

import java.util.List;
import java.util.Map;

public interface ProfileService {

    //기본정보 등록
    public int updateMyProfile(ProfileDTO.UpdateMyProfileDTO updateMyProfileDTO);

    //기본정보 조회
    public ProfileDTO.GetMyProfileDTO getMyProfile(String userId);

    //관리자 프로필 조회
    public ProfileDTO.GetAdminProfileDTO getAdminProfile(String userId);

    // 전체보기 조회
//    public ProfileDTO.GetAllProfileDTO getAllMyProfile(String userId);
    public Map<String,Object> getAllMyProfile(String userId);

    //링크 등록/수정
    public int updateLink(ProfileDTO.UpdateMyProfileDTO updateLink);

    //리뷰 목록 조회
    public List<ReviewVO> getReviewList(String userId);

    //북마크 목록 조회
    public List<BookmarkVO> getBookmarkList(String userId);

    //북마크 목록 삭제
    public int deleteBookmark(BookmarkVO bookmarkVO);
}
