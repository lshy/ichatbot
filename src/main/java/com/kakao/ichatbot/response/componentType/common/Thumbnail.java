package com.kakao.ichatbot.response.componentType.common;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class Thumbnail {

    @NonNull
    private String imageUrl;

    private Link link;

    //true: 이미지 영역을 1대1 비율로 두고 이미지의 원본 비율을 유지합니다. 이미지가 없는 영역은 흰색으로 노출합니다.
    //false: 이미지 영역을 1대2 비율로 두고 이미지의 가운데를 크롭하여 노출합니다.
    private boolean fixedRation;
}
