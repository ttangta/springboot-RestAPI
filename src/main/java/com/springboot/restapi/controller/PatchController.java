package com.springboot.restapi.controller;

import com.springboot.restapi.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/implement/patch-api")
public class PatchController {
    MemberDto memberDto = new MemberDto();
    public PatchController(){
        memberDto.setName("땅타");
        memberDto.setEmail("ttangta@naver.com");
        memberDto.setOrganization("student");
    }

    @GetMapping
    public MemberDto getBasicData(){
        return memberDto;
    }
    // Body를 통해 전달될 값들을 지정해 놓고 넘어온 데이터 중 공백이거나 null인 값에 대해서는 수정 진행하지 않는 방법
    @PatchMapping("/update")
    public void updateData(@RequestBody MemberDto memberDto){
        if(!memberDto.getName().isBlank() && memberDto.getName() != null){
            this.memberDto.setName(memberDto.getName());
        }
        if(!memberDto.getEmail().isBlank() && memberDto.getEmail() != null){
            this.memberDto.setEmail(memberDto.getEmail());
        }
        if(!memberDto.getOrganization().isBlank() && memberDto.getOrganization() != null){
            this.memberDto.setOrganization(memberDto.getOrganization());
        }
    }
}
