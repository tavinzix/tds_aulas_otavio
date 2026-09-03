package br.edu.ifsul.cstsi.tds_otavio.pedidoItem;
import br.edu.ifsul.cstsi.tds_otavio.produto.Produto;
import br.edu.ifsul.cstsi.tds_otavio.pedido.Pedido;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class PedidoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal quantidade;
    private BigDecimal precoUnitario;
    private Boolean status;

    //Associações
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id", referencedColumnName = "id",nullable = false)
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "produto_id", referencedColumnName = "id", nullable = false)
    private Produto produto;
}
