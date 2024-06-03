package bank.api.Application.Dto.Cliente;

import jakarta.validation.constraints.NotNull;

public record AtualizaClienteDto(
        @NotNull
        Long id,
        String nomeCompleto,
        Integer idade,
        String telefone
        ) {
}
