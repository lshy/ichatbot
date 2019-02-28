package com.kakao.ichatbot.response.componentType;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@Builder
public class Carousel{

    /*
    케로셀 개수

    현재 케로셀은 내부 문제로 인하여 최대 10개가 온전히 노출되지 않는 케이스가 있습니
    */

    public static final int MAX_ITEM_COUNT = 10;
    public static final int MIN_ITEM_COUNT = 1;

    @NonNull
    private String type;
    @NonNull
    private List<ISkillCardComponent> items;

    public static class CarouselBuilder{
        public CarouselBuilder items(List<ISkillCardComponent> items){
            assertItems(items);
            this.items = items;
            return this;
        }

        private void assertItems(List<ISkillCardComponent> items){
            if(items.size() > MAX_ITEM_COUNT || items.size() < MIN_ITEM_COUNT)
                throw new IllegalArgumentException("아이템의 수가 맞지 않습니다.");
        }
    }
}
