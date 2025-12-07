package com.example.tprest.service;
import com.example.tprest.domaine.ArticleDTO;
import com.example.tprest.service.model.Article;

import java.util.List;

public interface IService {
    ArticleDTO getById(Long id);
    List<ArticleDTO> getAll();
    void create(ArticleDTO article);
    void update(Long id, ArticleDTO article);
    void deleteById(Long id);
}