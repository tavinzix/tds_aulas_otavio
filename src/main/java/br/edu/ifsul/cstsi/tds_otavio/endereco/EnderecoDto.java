package br.edu.ifsul.cstsi.tds_otavio.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * DTO for {@link Endereco}
 */
public record EnderecoDto(
        Long id,

        @NotBlank(message = "O CEP não pode ser nulo ou vazio")
        @Size(min = 8, max = 9, message = "O CEP deve ter 8 ou 9 caracteres")
        String cep,

        @NotBlank(message = "O estado não pode ser nulo ou vazio")
        @Size(min = 2, max = 2, message = "O estado deve ter 2 caracteres")
        String estado,

        @NotBlank(message = "A cidade não pode ser nula ou vazia")
        @Size(min = 2, max = 100, message = "A cidade deve ter entre 2 e 100 caracteres")
        String cidade,

        @NotBlank(message = "O bairro não pode ser nulo ou vazio")
        String bairro,

        @NotBlank(message = "A rua não pode ser nula ou vazia")
        String rua,

        @NotBlank(message = "O número não pode ser nulo ou vazio")
        String numero,

        String complemento,

        @NotNull(message = "O status é obrigatório")
        Boolean status,

        @NotNull(message = "O ID do usuário é obrigatório")
        Long usuario
) implements Serializable {

  public EnderecoDto(Endereco endereco){
    this(endereco.getId(), endereco.getCep(), endereco.getEstado(), endereco.getCidade(), endereco.getBairro(),
            endereco.getRua(), endereco.getNumero(), endereco.getComplemento(), endereco.getStatus(), endereco.getUsuario().getId());
  }
}