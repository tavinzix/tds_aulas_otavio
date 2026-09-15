package br.edu.ifsul.cstsi.tds_otavio.formaPagamento;
import br.edu.ifsul.cstsi.tds_otavio.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
