package com.kakao.ichatbot.response.componentType;


import com.fasterxml.jackson.annotation.JsonRootName;
import com.kakao.ichatbot.response.componentType.exception.IllegalStringLengthException;
import lombok.*;

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

    @Getter
    @NoArgsConstructor
    public static class Adapter{

        private SimpleText simpleText;

        public static Adapter of(SimpleText simpleText){
            Adapter instance = new Adapter();
            instance.simpleText = simpleText;
            return instance;
        }
    }
}
