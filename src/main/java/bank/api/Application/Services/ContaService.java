package bank.api.Application.Services;

import bank.api.Application.Dto.Conta.ContaDto;
import bank.api.Application.Dto.Movimentacao.MovimentacaoDto;
import bank.api.Application.Interfaces.IContaService;
import bank.api.Domain.entities.Conta;
import bank.api.Domain.entities.Movimentacao;
import bank.api.Domain.repository.IContaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContaService implements IContaService {

    @Autowired
    private IContaRepository repository;

    public void CadastrarConta(@Valid ContaDto clienteDto) {
        Conta conta = new Conta(clienteDto);
        repository.save(conta);
    }

    @Override
    public List<ContaDto> ListarContas() {
        return repository.findAll().stream().map(ContaDto::new).toList();
    }

    @Override
    public ContaDto ContaId(Long id) {
        Optional<Conta> contaOptional = repository.findById(id);
        if (contaOptional.isPresent()) {
            Conta conta = contaOptional.get();
            return new ContaDto(conta);
        } else {
            return null;
        }
    }

    @Override
    public void AtualizarContaCliente(ContaDto contaDto) {
        var conta = repository.getReferenceById(contaDto.idConta());
        conta.AtualizarInformacoes(contaDto);
    }

    @Override
    public List<MovimentacaoDto> ObterExtratoPorConta(Long idConta) {
        List<Movimentacao> movimentacoes = repository.ObterExtratoConta(idConta);
        return movimentacoes.stream()
                .map(MovimentacaoDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public void InativarConta(Long id) {
        var conta = repository.getReferenceById(id);
        conta.inativar();
    }

    @Override
    public void ExcluirContaCliente(Long id) {
        repository.deleteById(id);
    }
}