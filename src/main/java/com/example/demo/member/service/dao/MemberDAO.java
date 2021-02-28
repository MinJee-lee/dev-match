package com.example.demo.member.service.dao;


import com.example.demo.member.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class MemberDAO {

    private final SqlSession sqlSession;


    /**
     * 성공일때 return - 1
     *
     * @param member
     * @return
     */
    public int addMember(MemberVO member) {
        return sqlSession.insert("member.addMember", member);
    }

    public MemberVO selectMember(String userId) {
        return sqlSession.selectOne("member.selectMember", userId);
    }

    public List<MemberVO> selectMemberList(MemberVO param) {
        return sqlSession.selectList("member.selectMemberList", param);
    }

    public List<MemberVO> selectMemberReportList(MemberVO param) {
        return sqlSession.selectList("member.selectReportMemberList", param);
    }

    public List<MemberVO> selectMemberDormantList(MemberVO param) {
        return sqlSession.selectList("member.selectDormantMemberList", param);
    }

    public List<MemberVO> selectMemberBackList(MemberVO param) {
        return sqlSession.selectList("member.selectBlackMemberList", param);
    }

    public int deleteMember(MemberVO member) {
        return sqlSession.delete("member.deleteMember", member);
    }

    //아이디 중복체크
    public int checkOverId(String userId) {
        return sqlSession.selectOne("member.checkOverId", userId);
    }

    //아이디 찾기
    public MemberVO findUserByUserId(String userId) {
        return null;
    }

    //비밀번호 찾기
    public MemberVO findUserByUserPassword(Map<String, Object> param) {
        return sqlSession.selectOne("member.selectFindUserByPassword", param);
    }

    //로그인 실패 이력 업데이트
    public int loginFailCountIncrease(String userId) {
        return sqlSession.update("member.updateFailureCount", userId);
    }

    //유저의 로그인 실패 이력 조회
    public int getLoginFailCount(String userId) {
        return sqlSession.selectOne("member.checkFailureCount", userId);
    }

    //로그인 성공일때 fail count 초기화
    public int loginFailCountInitialize(String userId) {
        return sqlSession.update("member.updateFailureCountReset", userId);
    }

    public void updatePassword(Map <String,Object> map){
        sqlSession.update("member.updatePassword",map);
    }
    public int deleteMember(String userId){
        return sqlSession.update("member.withdrawal",userId);

    }

    public int changeDormant(Map<String, Object> map) {
        return sqlSession.update("member.changeDormant",map);
    }
    public int changeNormal(Map<String, Object> map) {
        return sqlSession.update("member.changeNormal", map);
    }
}



