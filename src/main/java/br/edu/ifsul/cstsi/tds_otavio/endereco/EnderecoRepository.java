package br.edu.ifsul.cstsi.tds_otavio.endereco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(exported = false)
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    @Query(value = "SELECT e.* FROM endereco e WHERE e.cep LIKE CONCAT(?1, '%') ORDER BY e.cep", nativeQuery = true)
    Optional<List<Endereco>> findByCepQuerySpeakSQL(String cep);

    List<Endereco> findEnderecoByCep(String cep);
}
