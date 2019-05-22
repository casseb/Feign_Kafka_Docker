package com.bycasseb.appaz.listener;

import com.bycasseb.appaz.model.Endereco;
import com.bycasseb.appaz.stream.EnderecoStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EnderecoListener {

    @StreamListener(EnderecoStream.INPUT)
    public void hendleEndereco(@Payload Endereco endereco){
        log.info("Endereço recebido: {}",endereco);
    }

}