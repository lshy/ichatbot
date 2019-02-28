package com.kakao.ichatbot.response.componentType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ListCardForm implements ISkillComponent  {
    private ListCard listCard;
}
