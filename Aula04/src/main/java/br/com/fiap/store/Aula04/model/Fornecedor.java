package br.com.fiap.store.Aula04.model;

import jakarta.persistence.*;

@Entity
@Table(name = "aula4_fornecedor")
public class Fornecedor {
    @Id
    @GeneratedValue
    @Column(name = "cd_fornecedor")
    private Long codigo;
    @Column(name = "cd_fornecedor",nullable = false,length = 50)
    private String nome;
    @Column(name = "nr_cnpj", nullable = false, length = 22)
    private String cnpj;


}
