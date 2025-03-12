package com.example.simplememo.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Memo {
    private int id;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Memo(int id, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}