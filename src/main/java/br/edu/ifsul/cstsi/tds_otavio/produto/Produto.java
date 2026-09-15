package br.edu.ifsul.cstsi.tds_otavio.produto;
import br.edu.ifsul.cstsi.tds_otavio.pedidoItem.PedidoItem;
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
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeProduto;
    private BigDecimal estoque;
    private BigDecimal precoUnitario;
    private Boolean status;

    //Associações
    @OneToMany(mappedBy = "produto", fetch = FetchType.EAGER)
    private Collection<PedidoItem> pedidoItens;
}
