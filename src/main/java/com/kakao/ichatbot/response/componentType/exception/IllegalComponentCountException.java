package com.kakao.ichatbot.response.componentType.exception;

public class IllegalComponentCountException extends RuntimeException {

    // 컴포넌트 숫자
    public IllegalComponentCountException(int s) {
        super("출력 텍스트는 최대 " +s+"자 까지 가능");
    }
}
