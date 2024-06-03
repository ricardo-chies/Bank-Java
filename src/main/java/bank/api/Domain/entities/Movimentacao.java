package bank.api.Domain.entities;

import bank.api.Application.Dto.Movimentacao.MovimentacaoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "movimentacoes_financeira")
@Entity(name = "Movimentacao")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_movimentacao")
public class Movimentacao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMovimentacao;
    private Long idContaOrigem;
    private Long idContaDestino;
    private BigDecimal valor;
    private LocalDateTime dataMovimentacao;
    private String descricao;

    public Movimentacao(MovimentacaoDto movimentacaoDto){
        this.idContaOrigem = movimentacaoDto.idContaOrigem();
        this.idContaDestino = movimentacaoDto.idContaDestino();
        this.valor = movimentacaoDto.valor();
        this.dataMovimentacao = LocalDateTime.now();
        this.descricao = movimentacaoDto.descricao();
    }
}