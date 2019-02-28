package com.kakao.ichatbot.response.componentType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarouselForm  implements ISkillComponent  {
    private Carousel carousel;
}
