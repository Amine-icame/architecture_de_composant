package com.example.tpdatarest.service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Categorie {
    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String categorie;

    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Article> articles = new ArrayList<>();

    // Méthode utilitaire pour lier les objets
    public void addArticle(Article article) {
        article.setCategorie(this);
        articles.add(article);
    }
}