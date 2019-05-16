package com.bycasseb.appaz.service;

import com.bycasseb.appaz.client.CepClient;
import com.bycasseb.appaz.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    CepClient cepClient;

    public Endereco getByCep(String cep){
        return cepClient.getByCep(cep);
    }

}
