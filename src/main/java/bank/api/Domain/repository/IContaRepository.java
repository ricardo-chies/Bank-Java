package bank.api.Domain.repository;

import bank.api.Domain.entities.Conta;
import bank.api.Domain.entities.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContaRepository extends JpaRepository<Conta, Long> {

    @Query("SELECT m FROM Movimentacao m " +
            "WHERE m.idContaOrigem = :idConta OR m.idContaDestino = :idConta " +
            "ORDER BY m.dataMovimentacao DESC")
    List<Movimentacao> ObterExtratoConta(@Param("idConta") Long idConta);
}