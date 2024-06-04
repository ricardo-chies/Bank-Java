package bank.api.Controller;

import bank.api.Application.Dto.Conta.ContaDto;
import bank.api.Application.Dto.Movimentacao.MovimentacaoDto;
import bank.api.Application.Dto.ResponseDto;
import bank.api.Application.Interfaces.IContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contas")
public class ContaController {

    @Autowired
    private IContaService service;

    @CrossOrigin
    @PostMapping
    @Transactional
    public ResponseDto CadastrarConta(@RequestBody ContaDto contaDto) {
        try {
            service.CadastrarConta(contaDto);
            return new ResponseDto(true, "Conta cadastrada com sucesso");
        } catch (Exception e) {
            return new ResponseDto(false, "Erro ao cadastrar conta: " + e.getMessage());
        }
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<?> ListarContas() {
        try {
            List<ContaDto> contas = service.ListarContas();
            return ResponseEntity.ok(contas);
        } catch (Exception e) {
            ResponseDto errorResponse = new ResponseDto(false, "Erro ao listar contas: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<?> ContaCliente(@PathVariable Long id) {
        try {
            ContaDto conta = service.ContaId(id);
            return ResponseEntity.ok(conta);
        } catch (Exception e) {
            ResponseDto errorResponse = new ResponseDto(false, "Erro ao buscar conta: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @CrossOrigin
    @GetMapping("/extrato/{id}")
    public ResponseEntity<?> ExtratoCliente(@PathVariable Long id) {
        try {
            List<MovimentacaoDto> movimentacao = service.ObterExtratoPorConta(id);
            return ResponseEntity.ok(movimentacao);
        } catch (Exception e) {
            ResponseDto errorResponse = new ResponseDto(false, "Erro ao buscar extrato: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @CrossOrigin
    @PutMapping("/{id}")
    @Transactional
    public ResponseDto InativarConta(@PathVariable Long id){
        try {
            service.InativarConta(id);
            return new ResponseDto(true, "Conta inativada com sucesso");
        } catch (Exception e) {
            return new ResponseDto(false, "Erro ao inativar conta: " + e.getMessage());
        }
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseDto ExcluirContaCliente(@PathVariable Long id){
        try {
            service.ExcluirContaCliente(id);
            return new ResponseDto(true, "Conta excluída com sucesso");
        } catch (Exception e) {
            return new ResponseDto(false, "Erro ao excluir conta: " + e.getMessage());
        }
    }
}
