package com.example.demo.member.controller;

import com.example.demo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
//@RequestMapping("/user")
@RequiredArgsConstructor
public class KakaoLogin {

    private final MemberService memberService;

    @GetMapping("/kakaoLogin")
    public String kakaoGetToken(@RequestParam("code") String code, Model model) throws IOException {
        String access_Token = "";
        String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //    POST 요청을 위해 기본값이 false인 setDoOutput을 true로
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            //    POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=fd4e89f65c80feb60cb1a52e34ddbd2d");
            sb.append("&redirect_uri=http://localhost:8282/user/login");
            sb.append("&code=" + code);
            bw.write(sb.toString());
            bw.flush();

            //    결과 코드가 200이라면 성공
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            //    요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);

            //    Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성

            JSONObject jsonObject = new JSONObject(result);

            System.out.println(jsonObject);
            System.out.println(jsonObject.get("access_token"));
            System.out.println(jsonObject.get("refresh_token"));
            model.addAttribute("accessToken",jsonObject.get("access_token"));


            br.close();
            bw.close();
        } catch (IOException e) {
            System.out.println("변환에 실패");
            e.printStackTrace();
        }

        return "login";
    }

}
