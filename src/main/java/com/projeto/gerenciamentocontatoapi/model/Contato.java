package com.projeto.gerenciamentocontatoapi.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;
import java.util.List;

public class Contato {
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    @NotBlank(message = "Email é obrigatório")
    private String email;
    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;
    @NotNull(message = "Data de nascimento é obrigatório")
    @Past(message = "Data de nascimento deve ser no passado")
    private LocalDate dataNascimento;
    private List<Endereco> enderecos;

    public @NotBlank(message = "Nome é obrigatório") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Nome é obrigatório") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "Email é obrigatório") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email é obrigatório") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Telefone é obrigatório") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotBlank(message = "Telefone é obrigatório") String telefone) {
        this.telefone = telefone;
    }

    public @NotNull(message = "Data de nascimento é obrigatório") @Past(message = "Data de nascimento deve ser no passado") LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(@NotNull(message = "Data de nascimento é obrigatório") @Past(message = "Data de nascimento deve ser no passado") LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
