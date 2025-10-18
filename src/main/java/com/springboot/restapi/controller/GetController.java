package com.springboot.restapi.controller;

import com.springboot.restapi.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/implement/get-api")
public class GetController {
    // @RequestMapping을 통해 Handler Method 구현은 스프링 4.3 버전 이후로 거의 사용하지 않음
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello(){
        return "Hello Spring Boot";
    }

    // 매개변수가 존재하지 않는(요청 URL에 아무런 데이터 전달하지 않음) GET 요청 Handler Method
    @GetMapping("/disabled-param")
    public String getNoParam(){
        return "해당 Handler Method는 아무런 매개변수가 존재하지 않습니다";
    }

    // 요청 URL내 경로에 전달 데이터를 포함한 Handler Method
    // 1. 요청 경로의 변수 명과 Handler Method의 매개변수 명이 동일한 경우
    @GetMapping("/path-variable1/{variable}")
    public String getPathParam1(@PathVariable String variable){
        return "해당 Handler Method는 요청 경로에 데이터를 포함하여 전달 \"경로에 포함된 데이터\" = " + variable;
    }

    // 2. 요청 경로의 변수명과 Handler Method의 매개변수 명이 다를 경우
    @GetMapping("/path-variable2/{variable}")
    public String getPathParam2(@PathVariable("variable") String val){
        return "요청 URL에 포함된 변수명과 Handler Method의 매개변수명이 다를 경우 " +
                "@PathVariable 어노테이션 내 URL에 포함된 변수명이 어떤 이름으로 되어있는지 지정 후 매개변수명 지정" +
                " \"경로에 포함된 데이터\" = " + val;
    }

    // 쿼리스트링 형태로 요청 ULR 전송 (1.쿼리스트링 1:1 매핑, 2.어떤 쿼리스트링이 들어올지 정해져 있지 않는 상황, 3. DTO 객체를 매개변수로 활용하는 상황)
    // 1. 각각의 쿼리스트링 매핑
    @GetMapping("/query-string1")
    public String getQueryString1(@RequestParam String name,
                                  @RequestParam String email,
                                  @RequestParam String organization){
        return "각각의 쿼리스트링을 개별 매핑 -> name = " + name + ", email = " + email + ", organization = " + organization;
    }

    // 2. 요청 시 전달할 쿼리스트링이 명확하게 정해지지 않은 경우
    @GetMapping("/query-string2")
    public String getQueryString2(@RequestParam Map<String, String> map){
        StringBuilder sb = new StringBuilder();
        map.forEach((key, value) -> sb.append(key + " : " + value + " "));
        return "요청 시 전달할 데이터가 명확하게 정해지지 않은 경우 Handler Method의 매개변수를 Map객체로 활용한다 " +
                "현재 요청으로 전달된 쿼리스트링의 키와값 : " + sb.toString();
    }

    // 3. 요청에 대한 Handler Method의 매개변수를 DTO객체로 사용
    @GetMapping("/query-string/handler-method-param-dto")
    public String handlerMethodParamIsDtoObject(MemberDto memberDto){
        return "요청 시 전달할 데이터를 DTO객체의 필드로 정의하는 경우 Handler Method의 매개변수를 해당 DTO의 객체로 받는다 " +
                memberDto.toString();
    }
}
