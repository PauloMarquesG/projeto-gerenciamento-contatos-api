package com.projeto.gerenciamentocontatoapi.service.impl;

import com.projeto.gerenciamentocontatoapi.mapper.ContatoMapper;
import com.projeto.gerenciamentocontatoapi.mapper.EnderecoMapper;
import com.projeto.gerenciamentocontatoapi.model.Contato;
import com.projeto.gerenciamentocontatoapi.repository.ContatoRepository;
import com.projeto.gerenciamentocontatoapi.repository.entities.ContatoEntity;
import com.projeto.gerenciamentocontatoapi.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContatoServiceImpl implements ContatoService {
    private final ContatoRepository contatoRepository;
    private final ContatoMapper contatoMapper;

    @Autowired
    public ContatoServiceImpl(ContatoRepository contatoRepository, ContatoMapper contatoMapper, EnderecoMapper enderecoMapper) {
        this.contatoRepository = contatoRepository;
        this.contatoMapper = contatoMapper;
    }

    @Override
    public List<Contato> listarTodosContatos() {
        List<ContatoEntity> contatoEntity = contatoRepository.findAll();
        List<Contato> response = contatoMapper.toDTOList(contatoEntity);
        return response;
    }
}
