package br.com.fiap.store.Aula04.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter@Setter
@NoArgsConstructor

@Entity
@Table(name = "aula4_produto")
@EntityListeners(AuditingEntityListener.class)
public class Produto {
    @Id
    @GeneratedValue

    @Column(name = "cd_produto")
    private Long codigo;
    @Column(name = "nm_produto", nullable = false, length = 50)
    private String nome;
    @Column(name = "vl_produto", nullable = false, length = 50)
    private BigDecimal valor;
    @Column(name = "nr_estoque", precision = 9)
    private Long estoque;
    @Column(name = "st_frete_gratis")
    private Boolean freteGratis;
    @Column(name = "dt_fabricacao")
    private LocalDate dataFabricacao;
    @Column(name = "dt_cadastro")
    private LocalDateTime dataCadstro;
    @Enumerated(EnumType.STRING)
    @Column(name = "ds_estado", nullable = false, length = 20)
    private EstadoProduto estado;

    @OneToMany(mappedBy = "produto")
    private List<ProdutoPedido> itens;

    //metodo para setar a fk na tabela produto pedido
    public void addItens(ProdutoPedido item){
        //Setar a FK no item
        item.setPedido(this);

        //ADicionar o item na lista
        itens.add(item);
    }
}
