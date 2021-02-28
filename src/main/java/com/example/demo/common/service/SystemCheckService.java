package com.example.demo.common.service;

import com.example.demo.common.dto.SystemCheckReqDTO;

public interface SystemCheckService {
    /**
     * 시스템 체크시 사용되는 인증 서비스
     *
     * @param authPwd
     * @return
     */
    boolean canUseSystemCheckService(String authPwd);

    /**
     * 웹 서버에서 필요한 시스템 자원들의 정상여부 체크
     *
     * @return
     */
    boolean checkAllRelationSystem(SystemCheckReqDTO param);

}