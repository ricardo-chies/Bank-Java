package bank.api.Domain.repository;

import bank.api.Domain.entities.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
}
