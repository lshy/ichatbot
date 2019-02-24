package com.kakao.ichatbot.request;

import lombok.Data;

import java.util.Map;

@Data
public class Action {

    private String id;
    private String name;

    //Key value로 봇에서 보낸 파라미터가 넘어옴
    private Map<String, String> params;
}
