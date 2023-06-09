package com.bulletinboard.post.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class PostResponse {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    protected PostResponse() {
    }

    @Builder
    public PostResponse(Long id, String title, String content, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
}
