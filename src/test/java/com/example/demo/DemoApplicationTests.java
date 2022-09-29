package com.example.demo;

import com.example.demo.controllers.PapaController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    PapaController papaController;
    @Test
    void papaOk() {

    }

}
