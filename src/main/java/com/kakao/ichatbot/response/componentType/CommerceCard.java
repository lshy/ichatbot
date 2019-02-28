package com.kakao.ichatbot.response.componentType;


import com.kakao.ichatbot.response.componentType.common.Button;
import com.kakao.ichatbot.response.componentType.common.Thumbnail;
import com.kakao.ichatbot.response.componentType.exception.IllegalStringLengthException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@Builder
public class CommerceCard{

    public static final int MAX_DESCRIPTION_LENGTH = 76;
    public static final int MAX_THUMBNAIL_COUNT = 1;
    public static final int MAX_BUTTON_COUNT = 3;
    public static final int MIN_BUTTON_COUNT = 1;

    @NonNull
    private String description;
    @NonNull
    private int price;
    @NonNull
    private String currency;
    @NonNull
    private List<Thumbnail> thumbnails;
    @NonNull
    private List<Button> buttons;

    private int discount;

    //    현재 미지원
    //    private Profile profile;

    public static class CommerceCardBuilder {
        public CommerceCardBuilder description(String description) {
            assertDescription(description);
            this.description = description;
            return this;
        }

        public CommerceCardBuilder price(int price) {
            assertPrice(price);
            this.price = price;
            return this;
        }

        public CommerceCardBuilder currency(String currency) {
            assertCurrency(currency);
            this.currency = currency;
            return this;
        }

        public CommerceCardBuilder thumbnails(List<Thumbnail> thumbnails) {
            assertThumbnails(thumbnails);
            this.thumbnails = thumbnails;
            return this;
        }

        public CommerceCardBuilder buttons(List<Button> buttons) {
            assertButtons(buttons);
            this.buttons = buttons;
            return this;
        }


        private void assertDescription(String description){
            if (description.length() > MAX_DESCRIPTION_LENGTH)
                throw new IllegalStringLengthException(MAX_DESCRIPTION_LENGTH);
        }

        private void assertPrice(int price){
            if(price < 0)
                throw new IllegalArgumentException("금액은 마이너스일 수 없습니다.");
        }

        private void assertCurrency(String currency){
            // 금액 검증 추가
        }

        private void assertThumbnails(List<Thumbnail> thumbnails){
            if(thumbnails.size() != MAX_THUMBNAIL_COUNT)
                throw new IllegalArgumentException("썸내일은 "+MAX_THUMBNAIL_COUNT+"개 만 넣을수 있습니다.");
        }

        private void assertButtons(List<Button> buttons){
            if(buttons.size() > MAX_BUTTON_COUNT || buttons.size() < MIN_BUTTON_COUNT)
                throw new IllegalArgumentException("버튼 숫자 제한을 넘음");
        }
    }







}
