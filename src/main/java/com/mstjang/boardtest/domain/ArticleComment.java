package com.mstjang.boardtest.domain;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class ArticleComment {
    private BigInteger id;
    private Article article;            // 게시글 (ID)
    private String content;             // 본문
    private String hashtag;             // 해시태그

    private LocalDateTime createdAt;    // 생성일시
    private String createdBy;           // 생성자
    private LocalDateTime modifiedAt;   // 수정일시
    private String modifiedBy;          // 수정자
}
