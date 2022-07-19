package com.example.jpastudy.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpastudy.domain.dto.MemberListDto;
import com.example.jpastudy.domain.entity.Member;
import com.example.jpastudy.response.CommonResponse;
import com.example.jpastudy.service.MemberService;

@RequestMapping("/member")
@RestController
public class MemberController {
    
    private final MemberService memberService;

    MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<MemberListDto>> getEveryMemberList() {
        List<Member> memberList = memberService.findAllMember();
        return new ResponseEntity<List<MemberListDto>>(
            memberList.stream()
                .map(memberEntity -> new MemberListDto(memberEntity.getId(), memberEntity.getName()))
                .toList(), 
            HttpStatus.OK);
    }

    @PostMapping("/join")
    public ResponseEntity<CommonResponse> joinMember(@RequestParam String name) {
        Member newMember = new Member();
        newMember.setName(name);
        Long memberId = memberService.join(newMember);
        return new ResponseEntity<CommonResponse>(
            CommonResponse.builder()
                .code(0).message("회원가입 완료 : " + memberId.toString()).success(true).build(), 
            HttpStatus.OK);
    }
}
