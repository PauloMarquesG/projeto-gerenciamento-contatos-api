package com.projeto.gerenciamentocontatoapi.service;

import com.projeto.gerenciamentocontatoapi.model.Contato;
import com.projeto.gerenciamentocontatoapi.model.ContatoSimples;

import java.util.List;

public interface ContatoService {
    List<Contato> listarTodosContatos();
    Contato criarContato(Contato contato);
    Contato atualizarContato(Long id, Contato contato);
    void excluirContato(Long id);
    Contato atualizarContatoParcial(Long id, ContatoSimples contatoSimples);
}
