package bank.api.Application.Services;

import bank.api.Application.Dto.Cliente.AtualizaClienteDto;
import bank.api.Application.Dto.Cliente.ClienteDto;
import bank.api.Application.Interfaces.IClienteService;
import bank.api.Domain.entities.Cliente;
import bank.api.Domain.repository.IClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository repository;

    public void CadastrarCliente(@Valid ClienteDto clienteDto) {
        Cliente cliente = new Cliente(clienteDto);
        repository.save(cliente);
    }

    @Override
    public List<ClienteDto> ListarClientes() {
        return repository.findAll().stream().map(ClienteDto::new).toList();
    }

    @Override
    public void AtualizarCadastroCliente(AtualizaClienteDto clienteDto) {
        var cliente = repository.getReferenceById(clienteDto.id());
        cliente.AtualizarInformacoes(clienteDto);
    }

    @Override
    public void InativarCliente(Long id) {
        var cliente = repository.getReferenceById(id);
        cliente.inativar();
    }

    @Override
    public void ExcluirCadastroCliente(Long id) {
        repository.deleteById(id);
    }
}