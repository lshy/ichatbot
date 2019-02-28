package com.kakao.ichatbot.response.componentType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BasicCardForm  implements ISkillCardComponent  {
    private BasicCard basicCard;
}
