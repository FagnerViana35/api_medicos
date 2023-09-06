package med.voll.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosEndereco(

        @NotNull(message = "Campo logradouro não pode ser nulo") // Campo não pode nulo
        @NotBlank(message = "Campo logradouro não pode ser vazio") // Campo não pode vazio
        String logradouro,
        @NotNull(message = "Campo bairro não pode ser nulo") // Campo não pode nulo
        @NotBlank(message = "Campo bairro não pode ser vazio") // Campo não pode vazio
        String bairro,
        @NotNull(message = "Campo cep não pode ser nulo") // Campo não pode nulo
        @NotBlank(message = "Campo cep não pode ser vazio") // Campo não pode vazio
        String cep,
        @NotNull(message = "Campo cidade não pode ser nulo") // Campo não pode nulo
        @NotBlank(message = "Campo cidade não pode ser vazio") // Campo não pode vazio
        String cidade,
        @NotNull(message = "Campo uf não pode ser nulo") // Campo não pode nulo
        @NotBlank(message = "Campo uf não pode ser vazio") // Campo não pode vazio
        String uf,
        @NotNull(message = "Campo numero não pode ser nulo") // Campo não pode nulo
        @NotBlank(message = "Campo numero não pode ser vazio") // Campo não pode vazio
        String numero,
        String complemento
) {
}
