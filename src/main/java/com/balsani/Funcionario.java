package com.balsani;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Funcionario extends Pessoa{
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNasicmento, BigDecimal salario, String funcao) {
        super(nome, dataNasicmento);
        this.salario = salario;
        this.funcao = funcao;

    }



    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }
}
