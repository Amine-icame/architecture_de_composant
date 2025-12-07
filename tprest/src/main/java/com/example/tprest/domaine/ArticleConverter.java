package com.example.tprest.domaine;
import com.example.tprest.service.model.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleConverter {
    public static Article toBO(ArticleDTO dto) {
        if (dto == null) return null;
        return Article.builder()
                .id(dto.getId())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .quantity(dto.getQuantity())
                .build();
    }
    public static ArticleDTO toDTO(Article bo) {
        if (bo == null) return null;
        return ArticleDTO.builder()
                .id(bo.getId())
                .description(bo.getDescription())
                .price(bo.getPrice())
                .quantity(bo.getQuantity())
                .build();
    }
    public static List<ArticleDTO> toDTOs(List<Article> boList) {
        List<ArticleDTO> dtoList = new ArrayList<>();
        boList.forEach(a -> dtoList.add(toDTO(a)));
        return dtoList;
    }
}
