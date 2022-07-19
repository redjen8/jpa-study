package com.example.jpastudy.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class MemberListDto {
    
    private Long id;
    private String name;
}
