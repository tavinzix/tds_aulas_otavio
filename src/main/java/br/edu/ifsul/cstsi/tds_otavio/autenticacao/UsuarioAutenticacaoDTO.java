package br.edu.ifsul.cstsi.tds_otavio.autenticacao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UsuarioAutenticacaoDTO(
        @NotBlank(message = "O CPF não pode ser nulo ou vazio")
        String cpf,
        @Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[$*&@#])[0-9a-zA-Z$*&@#]{8,}$", message = "A senha deve conter ao menos uma letra maiúscula, uma letra minúscula, um númeral, um caractere especial e um total de 8 caracteres.")
        @NotBlank(message = "A senha não pode ser nula ou vazia")
        String senha) {
}
