package com.example.tpdatarest;

import com.example.tpdatarest.dao.ArticleRepository;
import com.example.tpdatarest.dao.CategorieRepository;
import com.example.tpdatarest.service.model.Article;
import com.example.tpdatarest.service.model.Categorie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TpdatarestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpdatarestApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDatabase(CategorieRepository categorieRepository,
										  ArticleRepository articleRepository) {
		return (a) -> {
			// Création des catégories
			var cat1 = Categorie.builder().categorie("CATEGORIE_1").build();
			var cat2 = Categorie.builder().categorie("CATEGORIE_2").build();
			var cat3 = Categorie.builder().categorie("CATEGORIE_3").build();

			categorieRepository.save(cat1);
			categorieRepository.save(cat2);
			categorieRepository.save(cat3);

			// Création des articles
			var art1 = Article.builder().description("Article_1").price(5000.0).quantity(10.0).build();
			var art2 = Article.builder().description("Article_2").price(6000.0).quantity(20.0).build();
			var art3 = Article.builder().description("Article_3").price(7000.0).quantity(30.0).build();

			// Liaison bi-directionnelle (optionnelle si on sauvegarde manuellement, mais bonne pratique)
			cat1.addArticle(art1);
			cat1.addArticle(art2);
			cat2.addArticle(art3);

			// Sauvegarde des articles (avec la catégorie liée)
			articleRepository.save(art1);
			articleRepository.save(art2);
			articleRepository.save(art3);
		};
	}

}
