package com.example.tpioc;

import com.example.tpioc.service.IService;
import com.example.tpioc.service.ServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestService {
	static AnnotationConfigApplicationContext context = null;

	@BeforeAll
	static void init() {
		context = new AnnotationConfigApplicationContext(TpiocApplication.class);
	}

	@AfterAll
	static void close() { context.close(); }

	@Test
	void test1() {
		IService service = context.getBean(ServiceImpl.class);
		Assertions.assertAll("Vérification données",
				() -> Assertions.assertEquals(1L, service.findById(1L).getId()),
				() -> Assertions.assertEquals("PC HP I7", service.findById(1L).getDescription())
		);
	}
}