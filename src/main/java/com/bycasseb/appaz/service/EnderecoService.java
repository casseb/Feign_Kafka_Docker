package com.bycasseb.appaz.service;

import com.bycasseb.appaz.client.CepClient;
import com.bycasseb.appaz.model.Endereco;
import com.bycasseb.appaz.stream.EnderecoStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
@Slf4j
public class EnderecoService {

    @Autowired
    CepClient cepClient;

    private final EnderecoStream enderecoStream;

    public EnderecoService(EnderecoStream enderecoStream){
        this.enderecoStream = enderecoStream;
    }

    public Endereco getByCep(String cep){
        log.info("Recebido cep: {}", cep);
        Endereco endereco = cepClient.getByCep(cep);
        log.info("Será enviado pelo EnderecoService o endereco {}", endereco);
        return endereco;
    }

    public void sendEnderecoMessage(final Endereco endereco){
        MessageChannel messageChannel = enderecoStream.outboundEndereco();
        messageChannel.send(MessageBuilder.withPayload(endereco).setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
    }

}
