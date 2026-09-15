package br.edu.ifsul.cstsi.tds_otavio.usuario;
import br.edu.ifsul.cstsi.tds_otavio.endereco.Endereco;
import br.edu.ifsul.cstsi.tds_otavio.formaPagamento.FormaPagamento;
import br.edu.ifsul.cstsi.tds_otavio.pedido.Pedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCompleto;
    private String email;
    @Column(unique = true)
    private String cpf;
    private String senha;

    //Associações
    @OneToMany(mappedBy = "usuario")
    private Collection<Endereco> enderecos;

    @OneToMany(mappedBy = "usuario")
    private Collection<FormaPagamento> formasPagamento;

    @OneToMany(mappedBy = "usuario")
    private Collection<Pedido> pedidos;
}
