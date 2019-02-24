package com.kakao.ichatbot.response;

import com.kakao.ichatbot.response.componentType.ISkillComponent;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class SkillTemplate {

    public static final int MAX_OUTPUTS_COUNT = 3;
    public static final int MAX_QUICKREPLIES_COUNT = 10;

    //1 <= outputs <= 3 && Not null
    @NonNull
    private List<ISkillComponent> outputs;

    // quickReplies <= 10
    private List<String> quickReplies;

    public SkillTemplate(List<ISkillComponent> outputs){
        assertOutputs(outputs);
        this.outputs = outputs;
    }

    public void insertQueicReplies(List<String> quickReplies){
        assertQueicReplies(quickReplies);
        this.quickReplies = quickReplies;
    }

    private void assertOutputs(List<ISkillComponent> outputs) {
        if (outputs.size() >= MAX_OUTPUTS_COUNT && !outputs.isEmpty())
            throw new IllegalArgumentException("1개 이상 3개 이하 까지 넣을 수 있습니다.");
    }

    private void assertQueicReplies(List<String> quickReplies) {
        if (quickReplies.size() >= MAX_QUICKREPLIES_COUNT)
            throw new IllegalArgumentException("10개 이하 까지 넣을 수 있습니다.");
    }
}
