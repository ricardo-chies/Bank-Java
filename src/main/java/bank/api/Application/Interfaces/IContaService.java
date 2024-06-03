package bank.api.Application.Interfaces;

import bank.api.Application.Dto.Conta.ContaDto;
import bank.api.Application.Dto.Movimentacao.MovimentacaoDto;
import jakarta.validation.Valid;

import java.util.List;

public interface IContaService {
    void CadastrarConta(@Valid ContaDto contaDto);
    List<ContaDto> ListarContas();
    ContaDto ContaId(Long id);
    List<MovimentacaoDto> ObterExtratoPorConta(Long idConta);
    void AtualizarContaCliente(ContaDto contaDto);
    void InativarConta(Long id);
    void ExcluirContaCliente(Long id);
}
