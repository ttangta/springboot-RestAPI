package com.springboot.restapi.controller;

import com.springboot.restapi.dto.MemberDto;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/implement/put-api")
public class PutController {

    // 1. 클라이언트가 서버로 전달할 Body의 데이터가 명확하지 않은경우 = Handler Method의 매개변수를 Map 객체로 활용
    @PutMapping("/put-map")
    public String putMap(@RequestBody Map<String, String> map){
        StringBuilder sb = new StringBuilder();
        map.forEach((key, value) -> sb.append(key + " : " + value + " "));
        return "서버로 전달될 Body의 값이 지정되지 않은 경우 " +
                "전달된 Map객체의 값 : " + sb.toString();
    }

    // 2. 클라이언트가 서버로 전달할 Body의 데이터가 명확한 경우 = Handler Method의 매개변수를 DTO 객체로 활용
    @PutMapping("/put-dto")
    public String putDto(@RequestBody MemberDto memberDto){
        return "서버로 전달될 Body의 값을 특정 DTO의 필드 값으로 명확히 지정 "
                + "전달된 DTO객체의 값 : " + memberDto.toString();
    }

    // Handler Method의 리턴타입이 DTO 객체인 경우
    @PutMapping("/put-dto-return-dto")
    public MemberDto putAndReturnDto(@RequestBody MemberDto memberDto){
        return memberDto;
    }
}
