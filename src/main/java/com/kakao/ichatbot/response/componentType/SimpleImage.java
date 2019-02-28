package com.kakao.ichatbot.response.componentType;

import com.kakao.ichatbot.response.componentType.exception.IllegalStringLengthException;
import lombok.*;

@Data
public class SimpleImage{

    public static final int MAX_TEXT_COUNT = 400;

    @NonNull
    private String imageUrl;
    @NonNull
    private String altText;

    @Builder
    public SimpleImage(String imageUrl, String altText){

        // URL 유효성 검사를 여기서 해야하나?
        // assertImageUrl(imageUrl);

        assertAltText(altText);
        this.imageUrl = imageUrl;
        this.altText = altText;
    }

    private void assertAltText(String altText) {
        if (altText.length() > MAX_TEXT_COUNT)
            throw new IllegalStringLengthException(MAX_TEXT_COUNT);
    }

    @Getter
    @NoArgsConstructor
    public static class Adapter{

        private SimpleImage simpleImage;

        public static Adapter of(SimpleImage simpleImage){
            Adapter instance = new Adapter();
            instance.simpleImage = simpleImage;
            return instance;
        }
    }
}
