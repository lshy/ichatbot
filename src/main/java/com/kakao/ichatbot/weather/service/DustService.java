package com.kakao.ichatbot.weather.service;

import com.kakao.ichatbot.request.SkillPayload;
import com.kakao.ichatbot.response.SkillResponse;
import com.kakao.ichatbot.response.SkillTemplate;
import com.kakao.ichatbot.response.componentType.SimpleText;
import com.kakao.ichatbot.weather.data.DustWithLocations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

@Service
public class DustService {


    @Value("${setofurl.weather.dustwithlocation}")
    private String DUST_LOCATION_URL;

    @Value("${setofkeys.weather.dustwithlocation}")
    private String DUST_LOCATION_APIKEY;

    @Autowired
    private RestTemplate restTemplate;

    public SkillResponse getDustWithLocation(SkillPayload skillPayload){

        DustWithLocations dustWithLocations = getDustWithLocationApiData(skillPayload
                .getAction()
                .getParams()
                .get("location"));

        List<Object> list = new ArrayList<>();

        dustWithLocations.getList().forEach(dustWithLocation ->{

            SimpleText simpleText = SimpleText.builder()
                    .text(dustWithLocation.toString())
                    .build();

            list.add(SimpleText.Adapter.of(simpleText));
        });

        return SkillResponse.builder()
                .version()
                .template(SkillTemplate.builder()
                        .outputs(list)
                        .build()).build();
    }


    private DustWithLocations getDustWithLocationApiData(String location){

        try {

            UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(DUST_LOCATION_URL)
                    .queryParam("numOfRows", 1)
                    .queryParam("pageNo", 1)
                    .queryParam("stationName", location)
                    .queryParam("dataTerm", "DAILY")
                    .queryParam("ver", "1.3")
                    .queryParam("ServiceKey", URLDecoder.decode(DUST_LOCATION_APIKEY, "UTF-8"))
                    .queryParam("_returnType", "json");

            return restTemplate.getForObject(uriBuilder.build(false).toUri(), DustWithLocations.class);
        }catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }
}
