package com.example.tpdatarest.dao;

import com.example.tpdatarest.domaine.ArticleDTO;
import com.example.tpdatarest.service.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import java.util.List;

// On expose ce repository sur l'URL /ecommerce et on utilise la projection par défaut
@RepositoryRestResource(collectionResourceRel = "articles", path = "ecommerce", excerptProjection = ArticleDTO.class)
public interface ArticleRepository extends JpaRepository<Article, Long> {

    // Service personnalisé exposé via /ecommerce/search/byCategorie
    @RestResource(path = "byCategorie", rel = "customFindByDescription")
    List<Article> findByCategorie_Categorie(@Param("categorie") String categorie);
}
