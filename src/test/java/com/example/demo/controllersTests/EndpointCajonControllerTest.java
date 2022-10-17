package com.example.demo.controllersTests;

import com.example.demo.controllers.CajonController;
import com.example.demo.domain.Cajon;
import com.example.demo.repository.CajonRepository;
import com.example.demo.service.CajonService;
import io.restassured.mapper.ObjectMapper;
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

@WebMvcTest(CajonController.class)
public class EndpointCajonControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CajonRepository cajonRepository;

    @MockBean
    private CajonService cajonService;

    @Autowired
    private CajonController cajonController;


    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.standaloneSetup(cajonController);
    }

    @Test
    void findAllCajonesOk() {
        Cajon cajon = new Cajon(1, "testing");

        Mockito.when(cajonRepository.findAll()).thenReturn(List.of(cajon));

        RestAssuredMockMvc.given().when().get("/cajones")
                .then().statusCode(200)
                .body("$.size()", Matchers.equalTo(1))
                .body("[0].idCajon", Matchers.equalTo(1))
                .body("[0].ubicacion", Matchers.equalTo("testing"));
    }

    @Test
    void findCajonByIdOk() {
        Cajon cajon = new Cajon(1, "testing");

        Mockito.when(cajonRepository.findById(1L)).thenReturn(Optional.of(cajon));

        RestAssuredMockMvc.given().when().get("/cajones/1")
                .then().statusCode(200)
                .body("idCajon", Matchers.equalTo(1))
                .body("ubicacion", Matchers.equalTo("testing"));
    }

    @Test
    void findCajonByIdNotFound() {
        Mockito.when(cajonRepository.findById(any(Long.class))).thenReturn(Optional.empty());

        RestAssuredMockMvc.given().when().get("/cajones/1")
                .then().statusCode(404);
    }

    @Test
    void insertCajonOk(){
        Cajon cajon = new Cajon(1, "testing");
        Mockito.when(cajonRepository.save(any(Cajon.class))).thenReturn(cajon);

        RestAssuredMockMvc.given().header("Content-type", "application/json").
                and().body("{\"ubicacion\": \"testing\"}")
                .when().post("/cajones")
                .then()
                .statusCode(200)
                .body("ubicaion", Matchers.equalTo("testing"));
    }
}
