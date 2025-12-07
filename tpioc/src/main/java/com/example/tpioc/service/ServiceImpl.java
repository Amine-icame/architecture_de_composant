package com.example.tpioc.service;

import com.example.tpioc.dao.IDao;
import com.example.tpioc.service.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements IService {
    private IDao dao;

    @Autowired
    //@Qualifier("dao1")
    public void setDao(IDao dao) {
        this.dao = dao;
    }
    /*
    // Injection par constructeur
    public ServiceImpl(@Qualifier("dao1") IDao dao) {
        this.dao = dao;
    }*/

    // Méthodes déléguées
    public List<Article> getAll() { return dao.getAll(); }
    public void save(Article article) { dao.save(article); }
    public void deleteById(Long id) { dao.deleteById(id); }
    public Article findById(Long id) { return dao.findById(id); }
}