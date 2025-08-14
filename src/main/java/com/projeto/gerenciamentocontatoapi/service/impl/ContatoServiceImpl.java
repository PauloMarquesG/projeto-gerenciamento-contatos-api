package com.projeto.gerenciamentocontatoapi.service.impl;

import com.projeto.gerenciamentocontatoapi.mapper.ContatoMapper;
import com.projeto.gerenciamentocontatoapi.mapper.EnderecoMapper;
import com.projeto.gerenciamentocontatoapi.model.Contato;
import com.projeto.gerenciamentocontatoapi.model.Endereco;
import com.projeto.gerenciamentocontatoapi.repository.ContatoRepository;
import com.projeto.gerenciamentocontatoapi.repository.entities.ContatoEntity;
import com.projeto.gerenciamentocontatoapi.repository.entities.EnderecoEntity;
import com.projeto.gerenciamentocontatoapi.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContatoServiceImpl implements ContatoService {
    private final ContatoRepository contatoRepository;
    private final ContatoMapper contatoMapper;
    private final EnderecoMapper enderecoMapper;

    @Autowired
    public ContatoServiceImpl(ContatoRepository contatoRepository, ContatoMapper contatoMapper, EnderecoMapper enderecoMapper) {
        this.contatoRepository = contatoRepository;
        this.contatoMapper = contatoMapper;
        this.enderecoMapper = enderecoMapper;
    }

    @Override
    public List<Contato> listarTodosContatos() {
        List<ContatoEntity> contatoEntity = contatoRepository.findAll();
        List<Contato> response = contatoMapper.toDTOList(contatoEntity);
        return response;
    }

    @Override
    public Contato criarContato(Contato contato) {
        ContatoEntity contatoEntity = contatoMapper.toEntity(contato);
        if (contatoEntity.getEnderecos() != null) {
            contatoEntity.getEnderecos().forEach(endereco -> endereco.setContato(contatoEntity));
        }
        ContatoEntity response = contatoRepository.save(contatoEntity);
        return contatoMapper.toDTO(response);
    }

    @Override
    public Contato atualizarContato(Long id, Contato contatoRequest) {
        ContatoEntity contatoEntity = contatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado"));

        contatoEntity.setNome(contatoRequest.getNome());
        contatoEntity.setEmail(contatoRequest.getEmail());
        contatoEntity.setTelefone(contatoRequest.getTelefone());
        contatoEntity.setDataNascimento(contatoRequest.getDataNascimento());

        for (EnderecoEntity endereco : new ArrayList<>(contatoEntity.getEnderecos())) {
            contatoEntity.removeEndereco(endereco);
        }
        for (Endereco endereco : contatoRequest.getEnderecos()) {
            EnderecoEntity enderecoEntity = enderecoMapper.toEntity(endereco);
            contatoEntity.addEndereco(enderecoEntity);
        }

        ContatoEntity atualizado = contatoRepository.save(contatoEntity);
        return contatoMapper.toDTO(atualizado);
    }

    @Override
    public void excluirContato(Long id) {
        if (!contatoRepository.existsById(id)) {
            throw new RuntimeException("Contato não encontrado");
        }
        contatoRepository.deleteById(id);
    }
}
