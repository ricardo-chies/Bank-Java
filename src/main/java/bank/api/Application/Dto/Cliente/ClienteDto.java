package bank.api.Application.Dto.Cliente;

import bank.api.Domain.entities.Cliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ClienteDto(
        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String cpf,
        @NotBlank
        String nomeCompleto,
        Integer idade,
        @NotBlank
        String telefone,
        @Email
        String email,
        @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+=-])^.+$")
        String senha){

        public ClienteDto(Cliente cliente) {
                this(cliente.getCpf(), cliente.getNome(), cliente.getIdade(), cliente.getTelefone(), cliente.getEmail(), cliente.getSenha());
        }
}