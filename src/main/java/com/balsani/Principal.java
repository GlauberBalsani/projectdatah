package com.balsani;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    /**
     * A classe Principal realiza diversas operações sobre uma lista de funcionários, incluindo:
     * - Inserção e remoção de funcionários
     * - Impressão de informações formatadas
     * - Aumento de salário
     * - Agrupamento por função
     * - Filtros e ordenações
     * - Cálculo de salários e idade
     */


    public static void main(String[] args) {
        //3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
        List<Funcionario> funcionarios = new ArrayList<>(Arrays.asList(
                new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"),
                new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"),
                new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"),
                new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"),
                new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"),
                new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"),
                new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"),
                new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"),
                new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"),
                new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente")
        ));

        // 3.2 – Remover o funcionário "João"
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));

        // 3.3 – Imprimir todos os funcionários com formatação
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        NumberFormat numberFormat = new DecimalFormat("#,##0.00");

        System.out.println("Funcionários:");
        funcionarios.forEach(funcionario -> {
            String dataNascimentoFormatada = funcionario.getDataNascimento().format(dateFormatter);
            String salarioFormatado = numberFormat.format(funcionario.getSalario());
            System.out.printf("Nome: %s | Data Nascimento: %s | Salário: R$%s | Função: %s%n",
                    funcionario.getNome(), dataNascimentoFormatada, salarioFormatado, funcionario.getFuncao());
        });

        // 3.4 – Aumento de 10% no salário
        funcionarios.forEach(funcionario -> {
            BigDecimal novoSalario = funcionario.getSalario().multiply(new BigDecimal("1.10"));
            funcionario.setSalario(novoSalario);
        });

        // 3.5 – Agrupar funcionários por função
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        // 3.6 – Imprimir funcionários agrupados por função
        System.out.println("\nFuncionários agrupados por função:");
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("Função: " + funcao);
            lista.forEach(funcionario -> System.out.println("  - " + funcionario.getNome()));
        });

        // 3.8 – Imprimir funcionários que fazem aniversário no mês 10 e 12
        System.out.println("\nFuncionários que fazem aniversário no mês 10 e 12:");
        funcionarios.stream()
                .filter(funcionario -> {
                    int mes = funcionario.getDataNascimento().getMonthValue();
                    return mes == 10 || mes == 12;
                })
                .forEach(funcionario -> System.out.println("Nome: " + funcionario.getNome() + " | Data Nascimento: " +
                        funcionario.getDataNascimento().format(dateFormatter)));

        // 3.9 – Imprimir o funcionário com a maior idade
        Funcionario maisVelho = funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElseThrow();

        long idade = ChronoUnit.YEARS.between(maisVelho.getDataNascimento(), LocalDate.now());
        System.out.printf("\nFuncionário mais velho: %s | Idade: %d anos%n", maisVelho.getNome(), idade);

        // 3.10 – Imprimir funcionários em ordem alfabética
        System.out.println("\nFuncionários em ordem alfabética:");
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(funcionario -> System.out.println(funcionario.getNome()));

        // 3.11 – Imprimir o total dos salários
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.printf("\nTotal dos salários: R$%s%n", numberFormat.format(totalSalarios));

        // 3.12 – Imprimir quantos salários mínimos cada funcionário ganha
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        System.out.println("\nSalários em termos de salários mínimos:");
        funcionarios.forEach(funcionario -> {
            BigDecimal salariosMinimos = funcionario.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.printf("%s ganha %s salários mínimos%n", funcionario.getNome(), salariosMinimos);
        });
    }
}
