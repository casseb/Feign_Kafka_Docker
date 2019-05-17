package com.bycasseb.appaz.service;

import com.bycasseb.appaz.client.CepClient;
import com.bycasseb.appaz.model.Endereco;
import com.bycasseb.appaz.stream.EnderecoStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
public class EnderecoService {

    @Autowired
    CepClient cepClient;

    private final EnderecoStream enderecoStream;

    public EnderecoService(EnderecoStream enderecoStream){
        this.enderecoStream = enderecoStream;
    }

    public Endereco getByCep(String cep){
        return cepClient.getByCep(cep);
    }

    public void sendEnderecoMessage(final Endereco endereco){
        MessageChannel messageChannel = enderecoStream.outboundEndereco();
        messageChannel.send(MessageBuilder.withPayload(endereco).setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
    }

}
