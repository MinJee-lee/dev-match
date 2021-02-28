package com.example.demo.community.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//@Controller
//public class TestController {
//
//    @GetMapping(value = "/message")
//    @ResponseBody
//    public String testByResponseBody(){
//        String message = "안녕하세요.";
//
//        return message;
//    }

@RestController
public class TestController{

    @GetMapping(value = "/members")
    public Map<Integer, Object> testByResponseBody(){

        Map<Integer, Object> members = new HashMap<>();

        for(int i = 1; i<20; i++){
            Map<String, Object> member = new HashMap<>();
            member.put("no", i);
            member.put("name",i+"원하");
            member.put("height", i+20);
            member.put("weight", i+30);
            members.put(i, member);
        }
        return members;
    }
}
