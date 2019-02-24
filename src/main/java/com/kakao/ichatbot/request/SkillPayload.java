package com.kakao.ichatbot.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillPayload {
    private Action action;
    private UserRequest userRequest;
    private Bot bot;
}
