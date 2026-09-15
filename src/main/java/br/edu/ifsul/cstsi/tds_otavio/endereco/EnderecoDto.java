package br.edu.ifsul.cstsi.tds_otavio.endereco;

import java.io.Serializable;

/**
 * DTO for {@link Endereco}
 */
public record EnderecoDto(Long id, String cep, String estado, String cidade, String bairro,
                          String rua, String numero, String complemento, Boolean status) implements Serializable {

  public EnderecoDto(Endereco endereco){
    this(endereco.getId(), endereco.getCep(), endereco.getEstado(), endereco.getCidade(), endereco.getBairro(),
            endereco.getRua(), endereco.getNumero(), endereco.getComplemento(), endereco.getStatus());
  }
}