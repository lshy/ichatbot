package com.kakao.ichatbot.request.common;

import lombok.Data;

@Data
public class User {
    private String id;
    private String type;
    private Properties properties;
}
