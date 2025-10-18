package com.springboot.restapi.controller;

import com.springboot.restapi.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/implement/post-api")
public class PostController {

    // @RequestMapping을 통한 POST API Handler Method 구현
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String useBasicAnnotation(){
        return "@RequestMapping은 @PostMapping 어노테이션 개발 Handler Method 작성 상황에서는 거진 사용하지 않는다";
    }

    // @PostMapping + @RequestBody 활용 POST API Handler Method
    // 1. Body를 통해 서버로 전달될 데이터가 명확하지 않은 경우
    @PostMapping("/post-map")
    public String useMapObject(@RequestBody Map<String, String> map){
        StringBuilder sb = new StringBuilder();

        map.forEach((key, value) -> sb.append(key + " : " + value + " "));
        System.out.println(map.toString());
        return "Body를 통해 전달될 데이터가 명확하지 않은 경우 Handler Method의 매개변수를 Map객체로 사용 "
                + "Body에서 전달된 값 : " + sb.toString();
    }

    // 2. Body를 통해 서버로 전달될 데이터가 DTO객체의 필드로 명확하게 지정되어 있는 경우
    @PostMapping("/post-dto")
    public String useDtoObject(@RequestBody MemberDto memberDto){
        return "Body를 통해 전달될 데이터가 DTO 객체의 필드로 명확하게 지정된 경우 " +
                "해당 Handler Method의 매개변수 : " + memberDto.toString();
    }
}
