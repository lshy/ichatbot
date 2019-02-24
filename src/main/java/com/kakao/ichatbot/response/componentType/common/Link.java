package com.kakao.ichatbot.response.componentType.common;

import lombok.Data;

// document
// https://i.kakao.com/docs/skill-response-format#link

@Data
public class Link {

    private String mobile;
    private String ios;
    private String android;
    private String pc;
    private String mac;
    private String win;
    private String web;
}
