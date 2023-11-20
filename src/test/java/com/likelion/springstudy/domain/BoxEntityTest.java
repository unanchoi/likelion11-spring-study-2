package com.likelion.springstudy.domain;

import com.likelion.springstudy.domain.entity.BoxEntity;
import com.likelion.springstudy.domain.entity.MemberEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BoxEntityTest {

    private static final int EXCEED_LETTER_LIMIT = 25;
    private static final String BOX_NAME = "편지박스";
    private static final String BOX_CODE = "12345678";

    @DisplayName("편지 제한 수를 초과하면 박스가 생성되지 않는다..")
    @Test
    void testBoxEntityWithInvalidLetterLimit() {
        MemberEntity member = MemberEntity.builder()
                .name("unan")
                .nickname("unan2")
                .build();

        assertThatThrownBy(
                () -> BoxEntity.builder()
                        .letterLimit(EXCEED_LETTER_LIMIT)
                        .name(BOX_NAME)
                        .code(BOX_CODE)
                        .member(member)
                        .build())
                .isInstanceOf(IllegalArgumentException.class);

    }

}
