package com.example.demo.profile.dao.impl;

import com.example.demo.common.vo.BookmarkVO;
import com.example.demo.common.vo.ReviewVO;
import com.example.demo.profile.dao.ProfileDAO;
import com.example.demo.profile.dto.ProfileDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("profileDAOImpl")
public class ProfileDAOImpl implements ProfileDAO {

    @Autowired
    @Qualifier("sqlSessionTemplate")
    private SqlSession sqlSession;

    @Override
    public int updateMyProfile(ProfileDTO.UpdateMyProfileDTO updateMyProfileDTO){
        return sqlSession.insert("profileMapper.updateMyProfile", updateMyProfileDTO);
    }

    @Override
    public ProfileDTO.GetMyProfileDTO getMyProfile(String userId){
        return sqlSession.selectOne("profileMapper.getMyProfile", userId);
    }

    @Override
    public ProfileDTO.GetAdminProfileDTO getAdminProfile(String userId){
        return sqlSession.selectOne("profileMapper.getAdminProfile", userId);
    }

    @Override
//    public ProfileDTO.GetAllProfileDTO getAllMyProfile(String userId){
//        return sqlSession.selectOne("profileMapper.getAllProfileList",userId);
//    }
    public ProfileDTO.GetAllProfileDTO getAllMyProfile(String userId){
        return sqlSession.selectOne("profileMapper.getAllProfileList",userId);
    }

    @Override
    public int updateLink(ProfileDTO.UpdateMyProfileDTO updateLink){
        return sqlSession.update("profileMapper.updateLink ", updateLink);
    }

    @Override
    public List<ReviewVO> getReviewList(String userId){
        return sqlSession.selectList("profileMapper.getReviewList",userId);
    }

    @Override
    public List<BookmarkVO> getBookmarkList(String userId){
        return sqlSession.selectList("profileMapper.getBookmarkList",userId);
    }

    @Override
    public int deleteBookmark(BookmarkVO bookmarkVO){
        return sqlSession.delete("profileMapper.deletePostBookmarkList",bookmarkVO);
    }
}
