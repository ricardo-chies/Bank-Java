package bank.api.Domain.repository;

import bank.api.Domain.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("SELECT c FROM Cliente c WHERE c.cpf = :cpf AND c.senha = :senha")
    Optional<Cliente> LoginCliente(@Param("cpf") String cpf, @Param("senha") String senha);
}