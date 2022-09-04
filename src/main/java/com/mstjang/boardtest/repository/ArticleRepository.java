package com.mstjang.boardtest.repository;

import com.mstjang.boardtest.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}