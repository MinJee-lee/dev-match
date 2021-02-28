package com.example.demo.common.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 *  dto = data transfer object
 *  - client -> server(request)
 *  - server -> client(response)
 *
 */
@Data
public class SystemCheckReqDTO {

    @NotBlank(message = "authPwd is can not be null or empty.")
    private String authPwd;

    private Integer min;
}
