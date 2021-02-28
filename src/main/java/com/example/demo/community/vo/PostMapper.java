package com.example.demo.community.vo;

import com.example.demo.common.vo.PageVO;
import com.example.demo.common.vo.SearchVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {

    public int insertPost(PostVO params);
//    insert쿼리를 호출하는 메서드


    public PostVO selectPostDetail(int postNo);

    public int updatePost(PostVO params);

//    public int deletePost(int postNo);

    public List<PostVO> selectPostList(SearchVO searchVO);

    public int selectPostTotalCount(PageVO pageVO);
}
