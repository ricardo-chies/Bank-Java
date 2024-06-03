package bank.api.Application.Dto.Conta;

import bank.api.Domain.entities.Conta;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ContaDto(Long idConta,
                       @NotNull
                       Long idCliente,
                       BigDecimal saldo) {

    public ContaDto(Conta conta) {
        this(conta.getIdConta(), conta.getIdCliente(), conta.getSaldo());
    }
}
