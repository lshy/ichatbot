package com.kakao.ichatbot.weather.controller;

import com.kakao.ichatbot.weather.data.DustWithLocations;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import static org.junit.Assert.*;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WeatherControllerTest {

    @Value("${setofurl.weather.dustwithlocation}")
    private String DUST_LOCATION_URL;

    @Value("${setofkeys.weather.dustwithlocation}")
    private String DUST_LOCATION_APIKEY;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void dustApiTest() throws UnsupportedEncodingException {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(DUST_LOCATION_URL)
                .queryParam("numOfRows", 1)
                .queryParam("pageNo", 1)
                .queryParam("stationName", "종로구")
                .queryParam("dataTerm", "DAILY")
                .queryParam("ver", "1.3")
                .queryParam("ServiceKey", URLDecoder.decode(DUST_LOCATION_APIKEY, "UTF-8"))
                .queryParam("_returnType", "json");

        DustWithLocations dustWithLocations = restTemplate.getForObject(uriBuilder.build(false).toUri(), DustWithLocations.class);
        assertNotNull(dustWithLocations);
    }
    @Test
    public void weatherDustTest() throws Exception {
        mockMvc.perform(post("/weather/dust/location")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"intent\": {\n" +
                        "    \"id\": \"gj3zhvy7o45u16a3ano0dbod\",\n" +
                        "    \"name\": \"블록 이름\"\n" +
                        "  },\n" +
                        "  \"userRequest\": {\n" +
                        "    \"timezone\": \"Asia/Seoul\",\n" +
                        "    \"params\": {\n" +
                        "      \"ignoreMe\": \"true\"\n" +
                        "    },\n" +
                        "    \"block\": {\n" +
                        "      \"id\": \"gj3zhvy7o45u16a3ano0dbod\",\n" +
                        "      \"name\": \"블록 이름\"\n" +
                        "    },\n" +
                        "    \"utterance\": \"발화 내용\",\n" +
                        "    \"lang\": null,\n" +
                        "    \"user\": {\n" +
                        "      \"id\": \"319495\",\n" +
                        "      \"type\": \"accountId\",\n" +
                        "      \"properties\": {}\n" +
                        "    }\n" +
                        "  },\n" +
                        "  \"bot\": {\n" +
                        "    \"id\": \"5c625f78384c553f07cd2d47\",\n" +
                        "    \"name\": \"봇 이름\"\n" +
                        "  },\n" +
                        "  \"action\": {\n" +
                        "    \"name\": \"155kcd5bw0\",\n" +
                        "    \"clientExtra\": null,\n" +
                        "    \"params\": {\n" +
                        "      \"location\": \"종로구\"\n" +
                        "    },\n" +
                        "    \"id\": \"gfeouzjgvbbhxwjjcg2mg58u\",\n" +
                        "    \"detailParams\": {\n" +
                        "      \"location\": {\n" +
                        "        \"origin\": \"종로구\",\n" +
                        "        \"value\": \"종로구\",\n" +
                        "        \"groupName\": \"\"\n" +
                        "      }\n" +
                        "    }\n" +
                        "  }\n" +
                        "}"))
                .andDo(print());

    }
}