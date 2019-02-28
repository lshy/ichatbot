package com.kakao.ichatbot.weather.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DustWithLocation {

    private String dataTime;

    private String pm10Grade;
    private String pm10Value;

    private String pm25Grade;
    private String pm25Value;

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();

        return st.append("측정 시간은 ").append(dataTime).append("\n")
                .append("미세먼지 농도 : ").append(pm10Value).append("\n")
                .append("미세먼지 등급 : ").append(pm10Grade).append("\n")
                .append("초미세먼지 농도 : ").append(pm25Value).append("\n")
                .append("초미세먼지 등급 : ").append(pm25Value).append("\n")
                .toString();
    }
}
