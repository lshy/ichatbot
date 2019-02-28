package com.kakao.ichatbot.response.componentType;

import com.kakao.ichatbot.response.componentType.common.Button;
import com.kakao.ichatbot.response.componentType.common.ListItem;
import com.kakao.ichatbot.response.componentType.common.Thumbnail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ComponentTypeTest {

    @Test
    public void SimpleTextTest() {
        SimpleText.builder().text("hello").build();
    }

    @Test
    public void SimpleImageTest() {
        SimpleImage.builder()
                .imageUrl("kakak.com")
                .altText("this is kakao")
                .build();
    }

    @Test
    public void BasicCardTest() {
        BasicCard.builder().title("this is BasicCard").build();
    }

    @Test
    public void ListCardTest(){
        ListItem listItem = ListItem.builder().title("listItem1").build();

        List<ListItem> list = Stream.of(listItem)
                .collect(Collectors.toList());

        ListCard.builder()
                .header(listItem)
                .items(list)
                .build();
    }


    @Test
    public void CommerceCardTest() {

        List<Thumbnail> thumbnails = Stream.of(
                Thumbnail.builder().imageUrl("asd").build()
        ).collect(Collectors.toList());

        List<Button> buttons = Stream.of(
                Button.builder().action("action1").label("label1").build(),
                Button.builder().action("action2").label("label2").build()
        ).collect(Collectors.toList());

        CommerceCard.builder()
                .thumbnails(thumbnails)
                .buttons(buttons)
                .currency("currency")
                .description("hi")
                .discount(20)
                .price(1000).build();

    }
}