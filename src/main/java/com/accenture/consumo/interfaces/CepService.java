package com.accenture.consumo.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.accenture.consumo.model.Endereco;

@FeignClient(name = "cepService", url = "https://viacep.com.br/ws")
public interface CepService {

    @GetMapping("/{cep}/json/")
    Endereco getEnderecoByCep(@RequestParam("cep") String cep);
}