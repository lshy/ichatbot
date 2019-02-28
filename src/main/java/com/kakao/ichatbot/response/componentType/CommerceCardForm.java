package com.kakao.ichatbot.response.componentType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommerceCardForm  implements ISkillCardComponent {
    private CommerceCard commerceCard;
}
