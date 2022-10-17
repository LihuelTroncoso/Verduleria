package com.example.demo.controllersTests;

import com.example.demo.controllers.PapaController;
import com.example.demo.domain.Papa;
import com.example.demo.repository.PapaRepository;
import com.example.demo.service.PapaService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@WebMvcTest(PapaController.class)
public class EndpointPapaControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PapaRepository papaRepository;

    @MockBean
    private PapaService papaService;

    @Autowired
    private PapaController papaController;


    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.standaloneSetup(papaController);
    }

    @Test
    void findAllPapasOk() {
        Papa papa = new Papa();
        papa.setId(1L);
        papa.setNombre("testing");
        papa.setEdad(23);

        Mockito.when(papaRepository.findAll()).thenReturn(List.of(papa));

        RestAssuredMockMvc.given().when().get("/papas")
                .then().statusCode(200)
                .body("$.size()", Matchers.equalTo(1))
                .body("[0].id", Matchers.equalTo(1))
                .body("[0].nombre", Matchers.equalTo("testing"))
                .body("[0].edad", Matchers.equalTo(23));
    }

    @Test
    void findPapaByIdOk() {
        Papa papa = new Papa();
        papa.setId(1L);
        papa.setNombre("testing");
        papa.setEdad(23);

        Mockito.when(papaRepository.findById(1L)).thenReturn(Optional.of(papa));

        RestAssuredMockMvc.given().when().get("/papas/1")
                .then().statusCode(200)
                .body("id", Matchers.equalTo(1))
                .body("nombre", Matchers.equalTo("testing"))
                .body("edad", Matchers.equalTo(23));
    }

    @Test
    void findPapaByIdNotFound() {
        Mockito.when(papaRepository.findById(any(Long.class))).thenReturn(Optional.empty());

        RestAssuredMockMvc.given().when().get("/papas/1")
                .then().statusCode(404);
    }
}
