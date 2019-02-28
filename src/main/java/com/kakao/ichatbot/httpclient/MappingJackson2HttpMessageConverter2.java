package com.kakao.ichatbot.httpclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.util.Collections;

@Component
public class MappingJackson2HttpMessageConverter2 extends AbstractJackson2HttpMessageConverter {

    public MappingJackson2HttpMessageConverter2() {
        this(Jackson2ObjectMapperBuilder.json().build());
        this.setSupportedMediaTypes(Collections.singletonList(new MediaType(MediaType.TEXT_PLAIN, Charset.forName("utf-8"))));
    }

    protected MappingJackson2HttpMessageConverter2(ObjectMapper objectMapper) {
        super(objectMapper, MediaType.TEXT_PLAIN);
    }





}
