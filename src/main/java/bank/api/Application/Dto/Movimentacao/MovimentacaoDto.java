package bank.api.Application.Dto.Movimentacao;

import bank.api.Domain.entities.Conta;
import bank.api.Domain.entities.Movimentacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public record MovimentacaoDto(
        Long idMovimentacao,
        Long idContaOrigem,
        Long idContaDestino,
        BigDecimal valor,
        LocalDateTime dataMovimentacao,
        String descricao
                              ) {

    public MovimentacaoDto(Movimentacao movimentacao) {
        this(movimentacao.getIdMovimentacao(), movimentacao.getIdContaOrigem(), movimentacao.getIdContaDestino(), movimentacao.getValor(), movimentacao.getDataMovimentacao(), movimentacao.getDescricao());
    }
}
