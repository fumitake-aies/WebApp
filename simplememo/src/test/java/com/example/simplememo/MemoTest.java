package com.example.simplememo;



import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


import com.example.simplememo.model.Memo;

public class MemoTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testValidMemoContent() {
        Memo memo = new Memo(1, "テスト", LocalDateTime.now(), LocalDateTime.now());
        Set<ConstraintViolation<Memo>> violations = validator.validate(memo);
        assertTrue(violations.isEmpty(), "バリデーションに成功するはず");
    }

    @Test
    void testTooLongMemoContent() {
        Memo memo = new Memo(2, "これは長すぎるメモです。", LocalDateTime.now(), LocalDateTime.now());
        Set<ConstraintViolation<Memo>> violations = validator.validate(memo);
        assertFalse(violations.isEmpty(), "メモの内容が10文字以上なのでバリデーションに失敗するはず");
    }

    @Test
    void testEmptyMemoContent() {
        Memo memo = new Memo(3, "", LocalDateTime.now(), LocalDateTime.now());
        Set<ConstraintViolation<Memo>> violations = validator.validate(memo);
        assertTrue(violations.isEmpty(), "空のメモは許容される場合があるため成功するはず");
    }
}