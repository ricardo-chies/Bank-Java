package bank.api.Controller;

import bank.api.Application.Dto.Movimentacao.MovimentacaoDto;
import bank.api.Application.Dto.ResponseDto;
import bank.api.Application.Interfaces.IMovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movimentacoes")
public class MovimentacaoController {

    @Autowired
    private IMovimentacaoService service;

    @CrossOrigin
    @PostMapping
    @Transactional
    public ResponseDto RealizarMovimentacao(@RequestBody MovimentacaoDto movimentacaoDto) {
        try {
            service.RealizarMovimentacao(movimentacaoDto);
            return new ResponseDto(true, "Movimentacao realizada com sucesso");
        } catch (Exception e) {
            return new ResponseDto(false, "Erro ao realizar movimentacao: " + e.getMessage());
        }
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<?> ListarMovimentacoes() {
        try {
            List<MovimentacaoDto> movimentacoes = service.ListarMovimentacoes();
            return ResponseEntity.ok(movimentacoes);
        } catch (Exception e) {
            ResponseDto errorResponse = new ResponseDto(false, "Erro ao listar movimentacoes: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<?> ListarMovimentacoesCliente(@PathVariable Long id) {
        try {
            List<MovimentacaoDto> movimentacoes = service.ListarMovimentacoesCliente(id);
            return ResponseEntity.ok(movimentacoes);
        } catch (Exception e) {
            ResponseDto errorResponse = new ResponseDto(false, "Erro ao listar movimentacoes: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
