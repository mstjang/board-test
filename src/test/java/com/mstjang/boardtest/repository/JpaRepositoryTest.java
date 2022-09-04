package com.mstjang.boardtest.repository;

import com.mstjang.boardtest.config.JpaConfig;
import com.mstjang.boardtest.domain.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleCommentRepository articleCommentRepository;

    @DisplayName("select 테스트")
    @Test
    void givenTestData_whenSelecting_thenFine(){
        // Given


        // When
        List<Article> articleList = articleRepository.findAll();


        // Then
        assertThat(articleList)
                .isNotNull()
                .hasSize(1000);
    }

    @DisplayName("insert 테스트")
    @Test
    void givenTestData_whenInserting_thenFine(){
        // Given
        long count = articleRepository.count();

        // When
        Article article = articleRepository.save(
                Article.of("new article", "new contents", "new hashTag"));


        // Then
        assertThat(articleRepository.count())
                .isEqualTo(count + 1);
    }

    @DisplayName("update 테스트")
    @Test
    void givenTestData_whenUpdating_thenFine(){
        // Given
        Article article = articleRepository.findById(1L).orElseThrow();
        article.setContent("컨텐츠 업데이트!");
        // When
        Article updatedArticle = articleRepository.save(article);
        articleRepository.flush();


        // Then
        assertThat(updatedArticle).hasFieldOrPropertyWithValue("content", "컨텐츠 업데이트!");
    }

    @DisplayName("Delete 테스트")
    @Test
    void givenTestData_whenDeleting_thenFine(){
        // Given
        Article article = articleRepository.findById(1L).orElseThrow();
        long previousArticleCount = articleRepository.count();

        // When
        articleRepository.delete(article);
        articleRepository.flush();


        // Then
        assertThat(articleRepository.count()).isEqualTo(previousArticleCount - 1);
    }
}