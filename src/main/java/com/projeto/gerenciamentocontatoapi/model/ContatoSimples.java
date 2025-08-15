package com.projeto.gerenciamentocontatoapi.model;

import jakarta.validation.constraints.Past;
import java.time.LocalDate;

public class ContatoSimples {
    public String nome;
    public String email;
    public String telefone;
    @Past(message = "Data de nascimento deve ser no passado")
    public LocalDate dataNascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public @Past(message = "Data de nascimento deve ser no passado") LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(@Past(message = "Data de nascimento deve ser no passado") LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
