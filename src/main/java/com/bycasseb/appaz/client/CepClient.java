package com.bycasseb.appaz.client;

import com.bycasseb.appaz.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="https://viacep.com.br/ws/", name = "myjson")
public interface CepClient {

    @GetMapping("{cep}/json")
    Endereco getByCep(@PathVariable("cep") String cep);

}