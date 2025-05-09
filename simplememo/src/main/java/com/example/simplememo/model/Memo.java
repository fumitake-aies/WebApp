package com.example.simplememo.model;

import lombok.Data;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class Memo {
    private int id;

    @Size(max = 10, message = "メモは10文字以内で入力してください。")
    private String content;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Memo() {
    }

    public Memo(int id, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}