package com.example.tpioc.dao;
import com.example.tpioc.service.model.Article;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

//@Repository("dao1")
public class DaoImpl1 implements IDao {
    private static final List<Article> repository = new ArrayList<>();

    static {
        repository.add(new Article(1L, "PC HP I7", 25000d, 5d));
        repository.add(new Article(2L, "PC HP I5", 15000d, 10d));
        repository.add(new Article(3L, "TV LG 32p", 3500d, 8d));
        repository.add(new Article(4L, "TV SAMSUNG 60p", 9000d, 15d));
    }

    @Override
    public List<Article> getAll() { return repository; }
    @Override
    public void save(Article article) { repository.add(article); }
    @Override
    public void deleteById(Long id) {
        repository.removeIf(a -> a.getId().equals(id));
    }
    @Override
    public Article findById(Long id) {
        return repository.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
    }
}