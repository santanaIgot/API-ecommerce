package br.com.fiap.store.Aula04.model;

import br.com.fiap.store.Aula04.dto.cliente.CadastroClienteDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

//entitiy indica que ela é uma tabela no banco
@Getter@Setter
@NoArgsConstructor
@Entity
@Table(name = "aula04_tb_cliente")
@EntityListeners(AuditingEntityListener.class) // framework vai criar valor de forma automatica
public class Cliente {
    @Id
    @GeneratedValue
    @Column(name="cd_codigo")
    private Long codigo;
    @Transient //indica que algo n vai ser uma coluna no bd
    private  String token;
    @Column(name="nm_cliente", nullable = false, length = 100, unique = true)
    private String nome;
    @Column(name="nr_cpf", unique = true, length = 11)
    private String cpf;
    @Column(name="nascimento")
    private LocalDate nascimento;
    @Column(name="categoria_cliente", nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    private CategoriaCliente categoriaCliente;
    @Column(name="pontos", precision = 10)
    private Integer pontos;
    @CreatedDate
    @Column(name = "dt_cadastro")
    private LocalDateTime dataCadastro;

    //relacionamento 1:N (bidirecional)
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;


    public Cliente(CadastroClienteDto dto) {
        nome = dto.nome();
        cpf = dto.cpf();
        nascimento = dto.nascimento();
        categoriaCliente = dto.categoriaCliente();
    }
}
