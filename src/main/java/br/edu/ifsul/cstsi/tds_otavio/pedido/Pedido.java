package br.edu.ifsul.cstsi.tds_otavio.pedido;
import br.edu.ifsul.cstsi.tds_otavio.endereco.Endereco;
import br.edu.ifsul.cstsi.tds_otavio.formaPagamento.FormaPagamento;
import br.edu.ifsul.cstsi.tds_otavio.pedidoItem.PedidoItem;
import br.edu.ifsul.cstsi.tds_otavio.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valorTotal;
    private Boolean status;

    //Associações
    @OneToMany(mappedBy = "pedido")
    private Collection<PedidoItem> itens;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id", nullable = false)
    private Endereco endereco;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pagamento_id", referencedColumnName = "id", nullable = false)
    private FormaPagamento pagamento;
}
