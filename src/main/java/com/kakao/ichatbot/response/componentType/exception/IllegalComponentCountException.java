package com.kakao.ichatbot.response.componentType.exception;

public class IllegalComponentCountException extends RuntimeException {

    // 컴포넌트 숫자
    public IllegalComponentCountException(int s) {
        super("삽입 가능 컴포넌트 최대 " +s+"자 까지 가능");
    }
}
