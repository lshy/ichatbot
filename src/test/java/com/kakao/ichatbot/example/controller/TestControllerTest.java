package com.kakao.ichatbot.example.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testDataController() throws Exception {
        mockMvc.perform(post("/test/data")
                .contentType(MediaType.APPLICATION_JSON)
                .content("data"))
                .andDo(print());

    }

    @Test
    public void testTemplateController() throws Exception {
        mockMvc.perform(post("/test/template")
                .contentType(MediaType.APPLICATION_JSON)
                .content("template"))
                .andDo(print());

    }


    @Test
    public void testWrapper() throws Exception {
        mockMvc.perform(post("/test/dust")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"intent\": {\n" +
                        "    \"id\": \"knnslvbs3ylyn49xkv6yc0be\",\n" +
                        "    \"name\": \"블록 이름\"\n" +
                        "  },\n" +
                        "  \"userRequest\": {\n" +
                        "    \"timezone\": \"Asia/Seoul\",\n" +
                        "    \"params\": {\n" +
                        "      \"ignoreMe\": \"true\"\n" +
                        "    },\n" +
                        "    \"block\": {\n" +
                        "      \"id\": \"knnslvbs3ylyn49xkv6yc0be\",\n" +
                        "      \"name\": \"블록 이름\"\n" +
                        "    },\n" +
                        "    \"utterance\": \"발화 내용\",\n" +
                        "    \"lang\": null,\n" +
                        "    \"user\": {\n" +
                        "      \"id\": \"658047\",\n" +
                        "      \"type\": \"accountId\",\n" +
                        "      \"properties\": {}\n" +
                        "    }\n" +
                        "  },\n" +
                        "  \"bot\": {\n" +
                        "    \"id\": \"5c625f78384c553f07cd2d47\",\n" +
                        "    \"name\": \"봇 이름\"\n" +
                        "  },\n" +
                        "  \"action\": {\n" +
                        "    \"name\": \"h044di1bkp\",\n" +
                        "    \"clientExtra\": null,\n" +
                        "    \"params\": {\n" +
                        "      \"hello\": \"hello\"\n" +
                        "    },\n" +
                        "    \"id\": \"y0gl2dtqrlnhbisgnyfip5ht\",\n" +
                        "    \"detailParams\": {\n" +
                        "      \"hello\": {\n" +
                        "        \"origin\": \"hello\",\n" +
                        "        \"value\": \"hello\",\n" +
                        "        \"groupName\": \"\"\n" +
                        "      }\n" +
                        "    }\n" +
                        "  }\n" +
                        "}"))
                .andDo(print());

    }

    @Test
    public void testRequestCheck() throws Exception {
        mockMvc.perform(post("/test/payload")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"intent\": {\n" +
                        "    \"id\": \"knnslvbs3ylyn49xkv6yc0be\",\n" +
                        "    \"name\": \"블록 이름\"\n" +
                        "  },\n" +
                        "  \"userRequest\": {\n" +
                        "    \"timezone\": \"Asia/Seoul\",\n" +
                        "    \"params\": {\n" +
                        "      \"ignoreMe\": \"true\"\n" +
                        "    },\n" +
                        "    \"block\": {\n" +
                        "      \"id\": \"knnslvbs3ylyn49xkv6yc0be\",\n" +
                        "      \"name\": \"블록 이름\"\n" +
                        "    },\n" +
                        "    \"utterance\": \"발화 내용\",\n" +
                        "    \"lang\": null,\n" +
                        "    \"user\": {\n" +
                        "      \"id\": \"658047\",\n" +
                        "      \"type\": \"accountId\",\n" +
                        "      \"properties\": {}\n" +
                        "    }\n" +
                        "  },\n" +
                        "  \"bot\": {\n" +
                        "    \"id\": \"5c625f78384c553f07cd2d47\",\n" +
                        "    \"name\": \"봇 이름\"\n" +
                        "  },\n" +
                        "  \"action\": {\n" +
                        "    \"name\": \"h044di1bkp\",\n" +
                        "    \"clientExtra\": null,\n" +
                        "    \"params\": {\n" +
                        "      \"hello\": \"hello\"\n" +
                        "    },\n" +
                        "    \"id\": \"y0gl2dtqrlnhbisgnyfip5ht\",\n" +
                        "    \"detailParams\": {\n" +
                        "      \"hello\": {\n" +
                        "        \"origin\": \"hello\",\n" +
                        "        \"value\": \"hello\",\n" +
                        "        \"groupName\": \"\"\n" +
                        "      }\n" +
                        "    }\n" +
                        "  }\n" +
                        "}"))
                .andDo(print());

    }


}