package com.smat.app.empresas.service;

import com.smat.app.empresas.repository.EmpregadoresRepository;
import com.smat.app.fiscalizacoes.model.Empregadores;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmpresasService {

    private final EmpregadoresRepository repository;

    public List<Empregadores> findAll(String razaoSocial) {

        if(razaoSocial == null || razaoSocial.isEmpty()){
            return repository.findAll();
        }
        return repository.findByRazaoSocialContainingIgnoreCase(razaoSocial);
    }
}
