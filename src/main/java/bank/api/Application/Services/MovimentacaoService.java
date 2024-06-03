package bank.api.Application.Services;

import bank.api.Application.Dto.Conta.ContaDto;
import bank.api.Application.Dto.Movimentacao.MovimentacaoDto;
import bank.api.Application.Interfaces.IContaService;
import bank.api.Application.Interfaces.IMovimentacaoService;
import bank.api.Domain.entities.Movimentacao;
import bank.api.Domain.repository.IMovimentacaoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoService implements IMovimentacaoService {

    @Autowired
    private IMovimentacaoRepository repository;

    @Autowired
    private IContaService service;

    public void RealizarMovimentacao(@Valid MovimentacaoDto movimentacaoDto) {
        ContaDto contaOrigem = service.ContaId(movimentacaoDto.idContaOrigem());

        if (contaOrigem != null && contaOrigem.saldo().compareTo(movimentacaoDto.valor()) < 0) {
            throw new IllegalArgumentException("Saldo insuficiente na conta de origem.");
        }

        ContaDto contaDestino = service.ContaId(movimentacaoDto.idContaDestino());

        contaOrigem = new ContaDto(contaOrigem.idConta(), contaOrigem.idCliente(), contaOrigem.saldo().subtract(movimentacaoDto.valor()));
        contaDestino = new ContaDto(contaDestino.idConta(), contaDestino.idCliente(), contaDestino.saldo().add(movimentacaoDto.valor()));

        service.AtualizarContaCliente(contaOrigem);
        service.AtualizarContaCliente(contaDestino);

        Movimentacao movimentacao = new Movimentacao(movimentacaoDto);
        repository.save(movimentacao);
    }

    @Override
    public List<MovimentacaoDto> ListarMovimentacoes() {
        return repository.findAll().stream().map(MovimentacaoDto::new).toList();
    }

    @Override
    public List<MovimentacaoDto> ListarMovimentacoesCliente(Long id) {
        Optional<Movimentacao> movimentacaoOptional = repository.findById(id);
        if (movimentacaoOptional.isPresent()) {
            Movimentacao movimentacao = movimentacaoOptional.get();
            return Collections.singletonList(new MovimentacaoDto(movimentacao));
        } else {
            return Collections.emptyList();
        }
    }
}