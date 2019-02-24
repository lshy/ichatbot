package com.kakao.ichatbot.response.componentType.common;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class ListItem {
    @NonNull
    private String title;

    private String decription;
    private String imageUrl;
    private Link link;
}
