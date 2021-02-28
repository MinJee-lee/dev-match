package com.example.demo.common.service.impl;

import com.example.demo.common.dto.SystemCheckReqDTO;
import com.example.demo.common.service.SystemCheckService;
import com.example.demo.common.service.dao.SystemCheckDAO;
import com.example.demo.common.vo.DatabaseInfoVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SystemCheckServiceImpl implements SystemCheckService {

    private final SystemCheckDAO systemCheckDAO;
    private final String authPwd = "123";

    /**
     * 시스템 체크시 사용되는 인증 서비스
     *
     * @param authPwd
     * @return
     */
    @Override
    public boolean canUseSystemCheckService(String authPwd) {
        return this.authPwd.equals(authPwd);
    }

    /**
     * 웹 서버에서 필요한 시스템 자원들의 정상여부 체크
     *
     * @return
     */
    @Override
    public boolean checkAllRelationSystem(SystemCheckReqDTO param) {

        if (!this.canUseSystemCheckService(param.getAuthPwd())) {
            return false;
        }

        List<DatabaseInfoVO> databaseInfoVOS = systemCheckDAO.selectDatabaseInfo();
        if (databaseInfoVOS == null || databaseInfoVOS.size() == 0) {
            return false;
        }

        // TODO redis요 사용시 시스템 체크 기능을 추가해주세요

        // TODO l....


        return true;
    }

}
