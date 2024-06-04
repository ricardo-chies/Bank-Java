package bank.api.Controller;

import bank.api.Application.Dto.Cliente.AtualizaClienteDto;
import bank.api.Application.Dto.Cliente.ClienteDto;
import bank.api.Application.Dto.Cliente.LoginDto;
import bank.api.Application.Dto.Cliente.ResponseCadastroClienteDto;
import bank.api.Application.Dto.ResponseDto;
import bank.api.Application.Interfaces.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private IClienteService service;

    @CrossOrigin
    @PostMapping
    @Transactional
    public ResponseCadastroClienteDto CadastrarCliente(@RequestBody ClienteDto clienteDto) {
        try {
            Long clienteId = service.CadastrarCliente(clienteDto);
            return new ResponseCadastroClienteDto(true, clienteId);
        } catch (Exception e) {
            return new ResponseCadastroClienteDto(false, null);
        }
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<?> ListarClientes() {
        try {
            List<ClienteDto> clientes = service.ListarClientes();
            return ResponseEntity.ok(clientes);
        } catch (Exception e) {
            ResponseDto errorResponse = new ResponseDto(false, "Erro ao listar clientes: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<?> loginCliente(@RequestBody LoginDto login) {
        try {
            ClienteDto cliente = service.LoginCliente(login.cpf(), login.senha());
            return ResponseEntity.ok(cliente);
        } catch (Exception e) {
            ResponseDto errorResponse = new ResponseDto(false, "Erro ao realizar login " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @CrossOrigin
    @PutMapping()
    @Transactional
    public ResponseDto AtualizarCadastroCliente(@RequestBody AtualizaClienteDto clienteDto){
        try {
            service.AtualizarCadastroCliente(clienteDto);
            return new ResponseDto(true, "Cadastro do cliente atualizado com sucesso");
        } catch (Exception e) {
            return new ResponseDto(false, "Erro ao atualizar cadastro do cliente: " + e.getMessage());
        }
    }

    @CrossOrigin
    @PutMapping("/{id}")
    @Transactional
    public ResponseDto InativarCliente(@PathVariable Long id){
        try {
            service.InativarCliente(id);
            return new ResponseDto(true, "Cliente inativado com sucesso");
        } catch (Exception e) {
            return new ResponseDto(false, "Erro ao inativar cliente: " + e.getMessage());
        }
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseDto ExcluirCadastroCliente(@PathVariable Long id){
        try {
            service.ExcluirCadastroCliente(id);
            return new ResponseDto(true, "Cliente excluído com sucesso");
        } catch (Exception e) {
            return new ResponseDto(false, "Erro ao excluir cliente: " + e.getMessage());
        }
    }
}
