package com.accenture.consumo.controller;

import com.accenture.consumo.interfaces.CepService;
import com.accenture.consumo.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import com.accenture.consumo.repository.EnderecoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CepRestController {

    @Autowired
    private CepService cepService;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping("/consulta-cep")
    public Endereco consultarCep(@RequestParam("cep") String cep) {
        Endereco endereco = cepService.getEnderecoByCep(cep);
        enderecoRepository.save(endereco); // Salva no banco
        return endereco;
    }
}