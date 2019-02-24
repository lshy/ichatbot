package com.kakao.ichatbot.response.componentType.exception;

public class IllegalStringLengthException extends RuntimeException {

    // 글자 길이 넣어주면 알아서 문구로 바꿔서
    public IllegalStringLengthException(int s) {
        super("출력 텍스트는 최대 " +s+"자 까지 가능");
    }
}
