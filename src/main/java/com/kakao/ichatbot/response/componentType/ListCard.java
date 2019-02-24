package com.kakao.ichatbot.response.componentType;

import com.kakao.ichatbot.response.componentType.common.Button;
import com.kakao.ichatbot.response.componentType.common.ListItem;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@Builder
public class ListCard implements ISkillComponent {

    public static final int MAX_ITEM_COUNT = 5;
    public static final int MIN_ITEM_COUNT = 1;

    @NonNull
    private ListItem header;
    @NonNull
    private List<ListItem> items;

    private List<Button> buttons;

    public static class ListCardBuilder{
        public ListCardBuilder items(List<ListItem> items){
            assertItems(items);
            this.items = items;
            return this;
        }

        private void assertItems(List<ListItem> items){
            if(items.size() > MAX_ITEM_COUNT || items.size() < MIN_ITEM_COUNT)
                throw new IllegalArgumentException("아이템 숫자가 제한을 넘었습니다");
        }
    }


}
