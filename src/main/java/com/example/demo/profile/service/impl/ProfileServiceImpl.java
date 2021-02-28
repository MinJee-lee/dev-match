package com.example.demo.profile.service.impl;

import com.example.demo.common.vo.BookmarkVO;
import com.example.demo.common.vo.ReviewVO;
import com.example.demo.profile.dao.ProfileDAO;
import com.example.demo.profile.dto.ProfileDTO;
import com.example.demo.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("profileServiceImpl")
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    @Qualifier("profileDAOImpl")
    ProfileDAO profileDAO;

    @Override
    public int updateMyProfile(ProfileDTO.UpdateMyProfileDTO updateMyProfileDTO) {
        return profileDAO.updateMyProfile(updateMyProfileDTO);
    }



    @Override
    public ProfileDTO.GetMyProfileDTO getMyProfile(String userId) {
        return profileDAO.getMyProfile(userId);
    }

    @Override
    public ProfileDTO.GetAdminProfileDTO getAdminProfile(String userId){
        return profileDAO.getAdminProfile(userId);
    }

    @Override
    /*public ProfileDTO.GetAllProfileDTO getAllMyProfile(String userId){
        return profileDAO.getAllMyProfile(userId);
    }*/
    public Map<String,Object> getAllMyProfile(String userId){
        ProfileDTO.GetAllProfileDTO getAllProfileDTO = profileDAO.getAllMyProfile(userId);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("getAllProfileDTO",getAllProfileDTO);
        return map;
    }
    @Override
    public int updateLink(ProfileDTO.UpdateMyProfileDTO updateLink){
        return profileDAO.updateLink(updateLink);
    }

    @Override
    public List<ReviewVO> getReviewList(String userId){
        return profileDAO.getReviewList(userId);
    }

    @Override
    public List<BookmarkVO> getBookmarkList(String userId){
        return profileDAO.getBookmarkList(userId);
    }

    @Override
    public int deleteBookmark(BookmarkVO bookmarkVO){
        return profileDAO.deleteBookmark(bookmarkVO);
    }
}
