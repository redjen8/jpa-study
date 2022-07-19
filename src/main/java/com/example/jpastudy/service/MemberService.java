package com.example.jpastudy.service;

import java.util.List;

import com.example.jpastudy.domain.entity.Member;

public interface MemberService {
    
    public Long join(Member member);

    public List<Member> findAllMember();

    public Member findOne(Long memberId);
}
