package com.example.tprest.service;

import com.example.tprest.dao.IDao;
import com.example.tprest.domaine.ArticleConverter;
import com.example.tprest.service.exception.BusinessException;
import com.example.tprest.service.model.Article;
import com.example.tprest.domaine.ArticleDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceImpl implements IService {
    private IDao dao;

    @Override
    public ArticleDTO getById(Long id) {
        Article found = dao.findById(id);
        if (found == null) throw new BusinessException("No article with id=" + id + " exists");
        return ArticleConverter.toDTO(found);
    }

    @Override
    public List<ArticleDTO> getAll() {
        return ArticleConverter.toDTOs(dao.findAll());
    }

    @Override
    public void create(ArticleDTO article) {
        if (dao.findById(article.getId()) != null)
            throw new BusinessException("Article with same Id=" + article.getId() + " exists");
        dao.save(ArticleConverter.toBO(article));
    }

    @Override
    public void update(Long id, ArticleDTO article) {
        Article found = dao.findById(id);
        if (found == null) throw new BusinessException("Article id=" + id + " does not exist");
        found.setDescription(article.getDescription());
        found.setPrice(article.getPrice());
        found.setQuantity(article.getQuantity());
    }

    @Override
    public void deleteById(Long id) {
        if (dao.findById(id) == null) throw new BusinessException("No article with id=" + id + " exists");
        dao.deleteById(id);
    }
}