package com.bycasseb.appaz.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CepClientTest {

    @Autowired
    private CepClient cepClient;

    @Test
    public void getTest(){
        assertEquals("Rua Roberto Bianchi",cepClient.getByCep("12226620").getLogradouro());
    }

}
