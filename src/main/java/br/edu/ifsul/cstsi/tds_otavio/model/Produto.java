package br.edu.ifsul.cstsi.tds_otavio.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long nomeProduto;
    private BigDecimal estoque;
    private BigDecimal precoUnitario;
    private Boolean status;

    //Associações
    @OneToMany(mappedBy = "produto", fetch = FetchType.EAGER)
    private Collection<PedidoItem> pedidoItens;
}
