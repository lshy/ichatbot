package com.kakao.ichatbot.response.componentType;

import com.kakao.ichatbot.response.componentType.common.Button;
import com.kakao.ichatbot.response.componentType.common.Thumbnail;
import com.kakao.ichatbot.response.componentType.exception.IllegalComponentCountException;
import com.kakao.ichatbot.response.componentType.exception.IllegalStringLengthException;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
@Builder
public class BasicCard{

    public static final int MAX_TITLE_LENGTH = 20;
    public static final int MAX_DESCRIPTION_LENGTH = 230;
    public static final int MAX_BUTTON_COUNT = 3;


    private String title;
    private String description;
    private Thumbnail thumbnail;
    private List<Button> buttons;
/*
    현재 미지원 앞으로 추가됨
    private Profile profile;
    private Social social;
*/

    public static class BasicCardBuilder {
        public BasicCardBuilder title(String title) {
            assertTitle(title);
            this.title = title;
            return this;
        }

        public BasicCardBuilder description(String description) {
            assertDescription(description);
            this.description = description;
            return this;
        }

        public BasicCardBuilder buttons(List<Button> buttons) {
            assertButtons(buttons);
            this.buttons = buttons;
            return this;
        }

        private void assertTitle(String title) {
            if (Optional.ofNullable(title).orElseThrow(IllegalArgumentException::new).length() > MAX_TITLE_LENGTH)
                throw new IllegalStringLengthException(MAX_TITLE_LENGTH);
        }

        private void assertDescription(String description) {
            if (Optional.ofNullable(description).orElseThrow(IllegalArgumentException::new).length() > MAX_DESCRIPTION_LENGTH)
                throw new IllegalStringLengthException(MAX_DESCRIPTION_LENGTH);
        }

        private void assertButtons(List<Button> buttons) {
            if (Optional.ofNullable(buttons).orElseThrow(IllegalArgumentException::new).size() > MAX_BUTTON_COUNT)
                throw new IllegalComponentCountException(MAX_BUTTON_COUNT);
        }
    }

}
