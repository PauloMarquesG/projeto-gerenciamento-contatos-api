package com.projeto.gerenciamentocontatoapi.model;

import jakarta.validation.constraints.NotBlank;

public class Endereco {
    @NotBlank(message = "Rua é obrigatória")
    private String rua;
    @NotBlank(message = "Número é obrigatório")
    private String numero;
    @NotBlank(message = "CEP é obrigatório")
    private String cep;

    public @NotBlank(message = "Rua é obrigatória") String getRua() {
        return rua;
    }

    public void setRua(@NotBlank(message = "Rua é obrigatória") String rua) {
        this.rua = rua;
    }

    public @NotBlank(message = "Número é obrigatório") String getNumero() {
        return numero;
    }

    public void setNumero(@NotBlank(message = "Número é obrigatório") String numero) {
        this.numero = numero;
    }

    public @NotBlank(message = "CEP é obrigatório") String getCep() {
        return cep;
    }

    public void setCep(@NotBlank(message = "CEP é obrigatório") String cep) {
        this.cep = cep;
    }
}

