package br.edu.ifsul.cstsi.tds_otavio.model;
import jakarta.persistence.*;
import java.util.Collection;

@Entity
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
