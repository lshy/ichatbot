package com.kakao.ichatbot.response.componentType;


import com.kakao.ichatbot.response.componentType.exception.IllegalStringLengthException;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
public class SimpleText{

    public static final int MAX_TEXT_COUNT = 400;

    @NonNull
    private String text;

    @Builder
    public SimpleText(String text){
        assertText(text);
       this.text =text;
    }

    private void assertText(String text) {
            if (text.length() > MAX_TEXT_COUNT)
                throw new IllegalStringLengthException(MAX_TEXT_COUNT);

    }
}
