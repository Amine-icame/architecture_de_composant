package com.example.tpdatarest.domaine;

import com.example.tpdatarest.service.model.Article;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

// Cette projection permet de personnaliser le JSON retourné (inclure l'ID, renommer des champs)
@Projection(name = "articleDTO", types = Article.class)
public interface ArticleDTO {
    Long getId();

    @Value("#{target.description}")
    String getDesc();

    Double getPrice();

    @Value("#{target.quantity}")
    String getQuant();

    @Value("#{target.categorie.categorie}")
    String getCat();
}
