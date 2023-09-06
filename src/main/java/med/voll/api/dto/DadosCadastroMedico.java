package med.voll.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.enums.Especialidade;

public record DadosCadastroMedico(
        @NotNull(message = "Campo nome não pode ser nulo") // Campo não pode nulo
        @NotBlank(message = "Campo nome não pode ser vazio") // Campo não pode vazio
        String nome,
        @NotBlank(message = "Campo email e-mail pode ser vazio") // Campo não pode ser vazio
        @Email(message = "Campo e-mail não pode ser vazio") //Campo tem que ser Email
        String email,

        @NotNull(message = "Campo telefone não pode ser nulo") // Campo não pode nulo
        @NotBlank(message = "Campo telefone pode ser vazio") // Campo não pode ser vazio
        String telefone,
        @Pattern(regexp = "\\d{4,6}", message = "O CRM deve ter entre 4 e 6 dígitos")
        @NotBlank(message = "Campo crm não pode ser vazio")
        String crm,
        @NotNull(message = "Campo especialidade não pode ser nulo") // Campo Obrigatorio
        Especialidade especialidade,
        @NotNull(message = "Campo endereço não pode ser nulo")
        @Valid
        DadosEndereco endereco) {}

