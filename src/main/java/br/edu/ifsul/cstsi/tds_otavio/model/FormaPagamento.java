package br.edu.ifsul.cstsi.tds_otavio.model;
import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity
public class FormaPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCartao;
    private String titularCartao;
    private String numeroCartao;
    private Boolean status;

    //Associações
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    private Usuario usuario;
}
