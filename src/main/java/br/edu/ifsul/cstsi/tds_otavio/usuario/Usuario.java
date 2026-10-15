package br.edu.ifsul.cstsi.tds_otavio.usuario;
import br.edu.ifsul.cstsi.tds_otavio.endereco.Endereco;
import br.edu.ifsul.cstsi.tds_otavio.perfil.Perfil;
import br.edu.ifsul.cstsi.tds_otavio.formaPagamento.FormaPagamento;
import br.edu.ifsul.cstsi.tds_otavio.pedido.Pedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario implements UserDetails {
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuarios_perfis",
            joinColumns = @JoinColumn(name = "usuarios_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "perfis_id", referencedColumnName = "id"))
    private List<Perfil> perfis;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return perfis;
    }

    @Override
    public @Nullable String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return cpf;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("Senha@123"));
    }
}
