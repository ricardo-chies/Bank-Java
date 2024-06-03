package bank.api.Application.Interfaces;

import bank.api.Application.Dto.Cliente.AtualizaClienteDto;
import bank.api.Application.Dto.Cliente.ClienteDto;
import jakarta.validation.Valid;

import java.util.List;

public interface IClienteService {
    void CadastrarCliente(@Valid ClienteDto clienteDto);
    List<ClienteDto> ListarClientes();

    void AtualizarCadastroCliente(@Valid AtualizaClienteDto clienteDto);
    void InativarCliente(Long id);
    void ExcluirCadastroCliente(Long id);
}
