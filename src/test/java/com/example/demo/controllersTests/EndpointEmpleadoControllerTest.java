package com.example.demo.controllersTests;

import com.example.demo.controllers.EmpleadoController;
import com.example.demo.controllers.PapaController;
import com.example.demo.domain.Empleado;
import com.example.demo.domain.Papa;
import com.example.demo.repository.EmpleadoRepository;
import com.example.demo.repository.PapaRepository;
import com.example.demo.service.EmpleadoService;
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

@WebMvcTest(EmpleadoController.class)
public class EndpointEmpleadoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmpleadoRepository empleadoRepository;

    @MockBean
    private EmpleadoService empleadoService;

    @Autowired
    private EmpleadoController empleadoController;


    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.standaloneSetup(empleadoController);
    }

    @Test
    void findAllEmpleadosOk() {
        Empleado empleado = new Empleado();
        empleado.setId(1L);
        empleado.setNombre("testing");
        empleado.setEdad(23);

        Mockito.when(empleadoRepository.findAll()).thenReturn(List.of(empleado));

        RestAssuredMockMvc.given().when().get("/empleados")
                .then().statusCode(200)
                .body("$.size()", Matchers.equalTo(1))
                .body("[0].id", Matchers.equalTo(1))
                .body("[0].nombre", Matchers.equalTo("testing"))
                .body("[0].edad", Matchers.equalTo(23));
    }

    @Test
    void findEmpleadosByIdOk() {
        Empleado empleado = new Empleado();
        empleado.setId(1L);
        empleado.setNombre("testing");
        empleado.setEdad(23);

        Mockito.when(empleadoRepository.findById(1L)).thenReturn(Optional.of(empleado));

        RestAssuredMockMvc.given().when().get("/empleados/1")
                .then().statusCode(200)
                .body("id", Matchers.equalTo(1))
                .body("nombre", Matchers.equalTo("testing"))
                .body("edad", Matchers.equalTo(23));
    }

    @Test
    void findEmpleadosByIdNotFound() {
        Mockito.when(empleadoRepository.findById(any(Long.class))).thenReturn(Optional.empty());

        RestAssuredMockMvc.given().when().get("/papas/1")
                .then().statusCode(404);
    }
}
