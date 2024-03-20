package br.com.fiap.store.Aula04.dto;

import br.com.fiap.store.Aula04.model.CategoriaCliente;
import br.com.fiap.store.Aula04.model.Cliente;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DetalhesClienteDto(Long codigo, String nome,String cpf,
                                 LocalDate nascimento, LocalDateTime dataCadastro,
                                 CategoriaCliente categoria, Integer pontos) {
    public DetalhesClienteDto(Cliente cliente) {
        this(cliente.getCodigo(), cliente.getNome(), cliente.getCpf(), cliente.getNascimento(),
                cliente.getDataCadastro(), cliente.getCategoriaCliente(), cliente.getPontos());
    }



}
