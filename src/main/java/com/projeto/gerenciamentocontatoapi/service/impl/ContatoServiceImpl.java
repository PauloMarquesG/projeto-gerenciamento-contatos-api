package com.projeto.gerenciamentocontatoapi.service.impl;

import com.projeto.gerenciamentocontatoapi.mapper.ContatoMapper;
import com.projeto.gerenciamentocontatoapi.mapper.EnderecoMapper;
import com.projeto.gerenciamentocontatoapi.model.Contato;
import com.projeto.gerenciamentocontatoapi.model.ContatoSimples;
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
    public Contato atualizarContato(Long id, Contato contato) {
        ContatoEntity contatoEntity = contatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado"));

        contatoEntity.setNome(contato.getNome());
        contatoEntity.setEmail(contato.getEmail());
        contatoEntity.setTelefone(contato.getTelefone());
        contatoEntity.setDataNascimento(contato.getDataNascimento());

        for (EnderecoEntity endereco : new ArrayList<>(contatoEntity.getEnderecos())) {
            contatoEntity.removeEndereco(endereco);
        }
        for (Endereco endereco : contato.getEnderecos()) {
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

    @Override
    public Contato atualizarContatoParcial(Long id, ContatoSimples contatoSimples) {
        ContatoEntity contatoEntity = contatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado"));

        if (contatoSimples.getNome() != null) {
            contatoEntity.setNome(contatoSimples.getNome());
        }
        if (contatoSimples.getEmail() != null) {
            contatoEntity.setEmail(contatoSimples.getEmail());
        }
        if (contatoSimples.getTelefone() != null) {
            contatoEntity.setTelefone(contatoSimples.getTelefone());
        }
        if (contatoSimples.getDataNascimento() != null) {
            contatoEntity.setDataNascimento(contatoSimples.getDataNascimento());
        }

        ContatoEntity response = contatoRepository.save(contatoEntity);
        return contatoMapper.toDTO(response);
    }
}
