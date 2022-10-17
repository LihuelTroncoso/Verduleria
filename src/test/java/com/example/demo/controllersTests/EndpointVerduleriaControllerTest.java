package com.example.demo.controllersTests;

import com.example.demo.controllers.PapaController;
import com.example.demo.controllers.VerduleriaController;
import com.example.demo.domain.Papa;
import com.example.demo.domain.Verduleria;
import com.example.demo.repository.PapaRepository;
import com.example.demo.repository.VerduleriaRepository;
import com.example.demo.service.PapaService;
import com.example.demo.service.VerduleriaService;
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
@WebMvcTest(VerduleriaController.class)
public class EndpointVerduleriaControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private VerduleriaRepository verduleriaRepository;

    @MockBean
    private VerduleriaService verduleriaService;

    @Autowired
    private VerduleriaController verduleriaController;


    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.standaloneSetup(verduleriaController);
    }

    @Test
    void findAllVerduleriasOk() {
        Verduleria verduleria = new Verduleria();
        verduleria.setId(1L);
        verduleria.setNombre("testing");

        Mockito.when(verduleriaRepository.findAll()).thenReturn(List.of(verduleria));

        RestAssuredMockMvc.given().when().get("/verdulerias")
                .then().statusCode(200)
                .body("$.size()", Matchers.equalTo(1))
                .body("[0].id", Matchers.equalTo(1))
                .body("[0].nombre", Matchers.equalTo("testing"));
    }

    @Test
    void findVerduleriasByIdOk() {
        Verduleria verduleria = new Verduleria();
        verduleria.setId(1L);
        verduleria.setNombre("testing");

        Mockito.when(verduleriaRepository.findById(1L)).thenReturn(Optional.of(verduleria));

        RestAssuredMockMvc.given().when().get("/verdulerias/1")
                .then().statusCode(200)
                .body("id", Matchers.equalTo(1))
                .body("nombre", Matchers.equalTo("testing"));
    }

    @Test
    void findVerduleriasByIdNotFound() {
        Mockito.when(verduleriaRepository.findById(any(Long.class))).thenReturn(Optional.empty());

        RestAssuredMockMvc.given().when().get("/verdulerias/1")
                .then().statusCode(404);
    }
}
