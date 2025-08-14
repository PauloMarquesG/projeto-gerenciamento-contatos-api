package com.projeto.gerenciamentocontatoapi.repository.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contato")
public class ContatoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;

    @OneToMany(
            mappedBy = "contato",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    private List<EnderecoEntity> enderecos  = new ArrayList<>();

    public void addEndereco(EnderecoEntity endereco) {
        enderecos.add(endereco);
        endereco.setContato(this);
    }

    public void removeEndereco(EnderecoEntity endereco) {
        enderecos.remove(endereco);
        endereco.setContato(null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<EnderecoEntity> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoEntity> enderecos) {
        this.enderecos = enderecos;
    }
}
