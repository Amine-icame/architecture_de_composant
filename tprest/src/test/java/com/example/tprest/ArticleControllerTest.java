package com.example.tprest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import com.example.tprest.controller.ArticleController;
import com.example.tprest.domaine.ArticleDTO;
import com.example.tprest.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ArticleController.class)
public class ArticleControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockitoBean
    private IService service;

    @Test
    void testGetAll() throws Exception {
        when(service.getAll()).thenReturn(List.of(
                new ArticleDTO(1L, "PC HP", 15000d, 10d)
        ));
        mvc.perform(get("/api/articles/all").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].description").value("PC HP"));
    }
}
