package bank.api.Domain.entities;

import bank.api.Application.Dto.Cliente.AtualizaClienteDto;
import bank.api.Application.Dto.Cliente.ClienteDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "clientes")
@Entity(name = "Cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String nome;
    private Integer idade;
    private String telefone;
    private String email;
    private String senha;
    private Boolean indAtivo;

    public Cliente(ClienteDto clienteDto){
        this.cpf = clienteDto.cpf();
        this.nome = clienteDto.nomeCompleto();
        this.idade = clienteDto.idade();
        this.telefone = clienteDto.telefone();
        this.email = clienteDto.email();
        this.senha = clienteDto.senha();
        this.indAtivo = true;
    }

    public void AtualizarInformacoes(AtualizaClienteDto clienteDto){
        this.nome = clienteDto.nomeCompleto() != null ? clienteDto.nomeCompleto() : this.nome;
        this.idade = clienteDto.idade() != null ? clienteDto.idade() : this.idade;
        this.telefone = clienteDto.telefone() != null ? clienteDto.telefone() : this.telefone;
    }

    public void inativar(){
        this.indAtivo = false;
    }
}