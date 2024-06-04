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
import java.util.Optional;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository repository;

    public Long CadastrarCliente(@Valid ClienteDto clienteDto) {
        Cliente cliente = new Cliente(clienteDto);
        Cliente clienteSalvo = repository.save(cliente);
        return clienteSalvo.getId();
    }

    @Override
    public List<ClienteDto> ListarClientes() {
        return repository.findAll().stream().map(ClienteDto::new).toList();
    }

    @Override
    public ClienteDto LoginCliente(String cpf, String senha) {
        Optional<Cliente> cliente = repository.LoginCliente(cpf, senha);
        return cliente.map(ClienteDto::new).orElse(null);
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