package com.bycasseb.appaz.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EnderecoControllerTest {

    @LocalServerPort
    public int PORT;

    @Test
    public void get() {
        port = PORT;
        when().
                get("/12226620").
        then().
                statusCode(200).assertThat().
                body("logradouro", equalTo("Rua Roberto Bianchi"));
    }
}