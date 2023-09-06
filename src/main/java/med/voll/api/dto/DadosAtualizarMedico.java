package med.voll.api.dto;


import jakarta.validation.constraints.NotNull;

public record DadosAtualizarMedico(
        @NotNull(message = "Campo ID não pode ser nulo") // Campo não pode nulo
        Long id,
        String telefone,
        String nome,
        DadosEndereco endereco ) {

}
