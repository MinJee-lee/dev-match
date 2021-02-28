package com.example.demo.common.service.dao;

import com.example.demo.common.vo.DatabaseInfoVO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SystemCheckDAO {

    private final SqlSession sqlSession;

    private final String NAMESPACE = "system.check.";

    public List<DatabaseInfoVO> selectDatabaseInfo() {
        return sqlSession.selectList(NAMESPACE + "selectDatabaseInfo");
    }
}
