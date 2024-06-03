package bank.api.Application.Interfaces;

import bank.api.Application.Dto.Movimentacao.MovimentacaoDto;
import bank.api.Domain.entities.Movimentacao;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface IMovimentacaoService {
    void RealizarMovimentacao(@Valid MovimentacaoDto movimentacaoDto);
    List<MovimentacaoDto> ListarMovimentacoes();
    List<MovimentacaoDto> ListarMovimentacoesCliente(Long id);
}
