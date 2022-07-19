package com.example.jpastudy.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class CommonResponse {
    
    private Integer code;
    private Boolean success;
    private String message;
}
