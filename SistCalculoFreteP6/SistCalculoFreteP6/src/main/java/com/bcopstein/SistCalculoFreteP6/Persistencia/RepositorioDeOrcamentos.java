package com.bcopstein.SistCalculoFreteP6.Persistencia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcopstein.SistCalculoFreteP6.Dominio.Orcamento;

@Repository
public class RepositorioDeOrcamentos {
    private List<Orcamento> orcamentos;

    public RepositorioDeOrcamentos(){
        orcamentos = new LinkedList<>();
    }

    public List<Orcamento> todos(){
        return new ArrayList<Orcamento>(orcamentos);
    }

    public List<Orcamento> deUmaData(int dia,int mes,int ano){
        return orcamentos.stream()
            .filter(o->o.getData().getYear() == ano)
            .filter(o->o.getData().getMonthValue() == mes)
            .filter(o->o.getData().getDayOfMonth() == dia)
            .toList();
    }

    public Orcamento cadastra(Orcamento orcamento){
        orcamentos.add(orcamento);
        return orcamento;
    }
}