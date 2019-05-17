package com.bycasseb.appaz.controller;

import com.bycasseb.appaz.model.Endereco;
import com.bycasseb.appaz.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("{cep}")
    public Endereco get(@PathVariable String cep){
        return enderecoService.getByCep(cep);
    }

    @GetMapping("message/{cep}")
    public Endereco messageGet(@PathVariable String cep){
        Endereco endereco = enderecoService.getByCep(cep);
        enderecoService.sendEnderecoMessage(endereco);
        return endereco;
    }

}
