package br.com.fiap.store.Aula04.dto.cliente;

import br.com.fiap.store.Aula04.model.CategoriaCliente;

import java.time.LocalDate;
//esta classe esta definindo quais informacoes sao necessarias para o cadastro
public record CadastroClienteDto(String nome, String cpf, LocalDate nascimento, CategoriaCliente categoriaCliente) {
}
