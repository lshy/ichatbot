package com.kakao.ichatbot.response.componentType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SimpleImageForm  implements ISkillComponent {
    private SimpleImage simpleImage;
}
