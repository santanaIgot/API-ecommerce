package br.com.fiap.store.Aula04.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter@Setter
@NoArgsConstructor

@Entity
@Table(name = "aula4_pedido")
public class Pedido {
    @Id
    @GeneratedValue
    @Column(name = "cd_pedido")
    private Long codigo;
    @Column(name = "vl_pedido", scale = 2, precision = 9)
    private BigDecimal valor;
    @Column(name = "dt_pedido")
    private LocalDateTime data;

    //quando deleta ou cria vai criar nota fiscal tambem, é isso que o cascade faz
    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    private NotaFiscal notaFiscal;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "cd_cliente", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProdutoPedido> itens;

    @ManyToOne
    @JoinColumn(name = "cd_produto", nullable = false)
    private Produto produto;


}
