package bank.api.Domain.entities;

import bank.api.Application.Dto.Cliente.AtualizaClienteDto;
import bank.api.Application.Dto.Conta.ContaDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Table(name = "contas_bancaria")
@Entity(name = "Conta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_conta")
public class Conta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConta;
    private Long idCliente;
    private BigDecimal saldo;
    private Boolean indAtivo;

    public Conta(ContaDto contaDto){
        this.idCliente = contaDto.idCliente();
        this.saldo = contaDto.saldo();
        this.indAtivo = true;
    }

    public void AtualizarInformacoes(ContaDto contaDto){
        this.saldo = contaDto.saldo() != null ? contaDto.saldo() : this.saldo;
    }

    public void inativar(){
        this.indAtivo = false;
    }
}