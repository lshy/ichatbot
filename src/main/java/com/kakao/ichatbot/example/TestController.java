package com.kakao.ichatbot.example;

import com.kakao.ichatbot.request.SkillPayload;
import com.kakao.ichatbot.response.SkillResponse;
import com.kakao.ichatbot.response.SkillTemplate;
import com.kakao.ichatbot.response.componentType.ISkillComponent;
import com.kakao.ichatbot.response.componentType.SimpleText;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @PostMapping("/data")
    @ResponseStatus(value = HttpStatus.OK)
    private ResponseEntity<SkillResponse> dataResponse() {


        URI uri = linkTo(TestController.class).toUri();
        Tester tester = Tester.builder().name("asd").address("asdaaaa").build();

        //body의 SkillResponse는 Service에서 구현 후 반환
        SkillResponse skillResponse = SkillResponse
                .builder()
                .data(tester)
                .build();

        return ResponseEntity.created(uri).body(skillResponse);
    }

    @PostMapping("/template")
    @ResponseStatus(value = HttpStatus.OK)
    private ResponseEntity<SkillResponse> templateResponse() {


        URI uri = linkTo(TestController.class).toUri();
        List<ISkillComponent> outputs = Stream.of(
                SimpleText.builder().text("hello my name is Yoongi!").build()
        ).collect(Collectors.toList());

        //body의 SkillResponse는 Service에서 구현 후 반환
        SkillResponse skillResponse = SkillResponse.builder()
                .template(SkillTemplate.builder()
                        .outputs(outputs)
                        .build()).build();

        return ResponseEntity.created(uri).body(skillResponse);
    }

    @PostMapping("/payload")
    @ResponseStatus(value = HttpStatus.OK)
    private ResponseEntity<SkillResponse> payloadResponse(@RequestBody SkillPayload skillPayload) {


        URI uri = linkTo(TestController.class).toUri();
        List<ISkillComponent> outputs = Stream.of(
                SimpleText.builder().text(skillPayload.getAction().getName()).build()
        ).collect(Collectors.toList());
      
        //body의 SkillResponse는 Service에서 구현 후 반환
        SkillResponse skillResponse = SkillResponse
                .builder()
                .template(SkillTemplate
                        .builder()
                        .outputs(outputs)
                        .build()).build();

        return ResponseEntity.created(uri).body(skillResponse);

    }
}
