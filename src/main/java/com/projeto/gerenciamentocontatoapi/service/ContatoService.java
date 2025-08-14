package com.projeto.gerenciamentocontatoapi.service;

import com.projeto.gerenciamentocontatoapi.model.Contato;
import java.util.List;

public interface ContatoService {
    List<Contato> listarTodosContatos();
    Contato criarContato(Contato contato);
    Contato atualizarContato(Long id, Contato contato);
    void excluirContato(Long id);
}
