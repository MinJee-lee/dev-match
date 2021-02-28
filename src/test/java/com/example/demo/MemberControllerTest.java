//package com.example.demo;
//
//import com.example.demo.member.controller.Member;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(Member.class)
//public class MemberControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Test
//    public void signUpReq() throws Exception {
//        mockMvc.perform(get("/signUp"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(view().name("signUp"));
//    }
//}
