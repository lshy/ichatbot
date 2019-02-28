package com.kakao.ichatbot.weather.controller;

import com.kakao.ichatbot.request.SkillPayload;
import com.kakao.ichatbot.response.SkillResponse;
import com.kakao.ichatbot.weather.service.DustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/weather/dust")
public class WeatherController{

    @Autowired
    DustService dustService;

    @PostMapping("/location")
    @ResponseStatus(value = HttpStatus.OK)
    private ResponseEntity<SkillResponse> dataResponse(@RequestBody SkillPayload skillPayload) {


        URI uri = linkTo(WeatherController.class).toUri();

        //body의 SkillResponse는 Service에서 구현 후 반환
        SkillResponse skillResponse = dustService.getDustWithLocation(skillPayload);
        return ResponseEntity.created(uri).body(skillResponse);
    }

}
