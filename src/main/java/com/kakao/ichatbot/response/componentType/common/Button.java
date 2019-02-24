package com.kakao.ichatbot.response.componentType.common;


import lombok.Builder;
import lombok.Data;
import lombok.NonNull;


// document
// https://i.kakao.com/docs/skill-response-format#button
@Data
@Builder
public class Button {

    @NonNull
    private String label;
    @NonNull
    private String action;

    private String webLinkUrl;
    private Link osLink;
    private String messageText;
    private String phoneNumber;
    private String blockId;



}
