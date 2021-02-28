package com.example.demo.config.security.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ErrorHandlerController implements ErrorController {

    @RequestMapping("/error")
    public Map handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        Map result = new HashMap();
        if(status != null){
            int statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()){
                result.put("code", "9997");
                result.put("message", "[404] NOT_FOUND");
                return result;
            }
            if(statusCode == HttpStatus.FORBIDDEN.value()){
                result.put("code", "9996");
                result.put("message", "[403] FORBIDDEN");
                return result;
            }
        }else{
            result.put("code", "9998");
            result.put("message", "[error] ERROR");
        }

        return result;
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
