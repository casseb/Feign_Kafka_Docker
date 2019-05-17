package com.bycasseb.appaz.integration;

import com.bycasseb.appaz.listener.EnderecoListener;
import com.bycasseb.appaz.service.EnderecoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@EmbeddedKafka
public class KafkaTest {

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private EnderecoListener enderecoListener;

    @Test
    public void testReceive() throws InterruptedException {
        enderecoService.sendEnderecoMessage(enderecoService.getByCep("12226620"));
        enderecoListener.getLatch().await(10000, TimeUnit.MILLISECONDS);
        assertEquals(1,enderecoListener.getLatch().getCount());
    }

}
