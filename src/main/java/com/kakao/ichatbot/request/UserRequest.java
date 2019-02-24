package com.kakao.ichatbot.request;


import com.kakao.ichatbot.request.common.Block;
import com.kakao.ichatbot.request.common.User;
import lombok.Data;

@Data
public class UserRequest {
    private String timezone;
    private Block block;
    //발화 내용
    private String utterance;
    private String lang;
    private User user;

}
