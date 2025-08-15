package com.projeto.gerenciamentocontatoapi.mapper;

import com.projeto.gerenciamentocontatoapi.model.Contato;
import com.projeto.gerenciamentocontatoapi.repository.entities.ContatoEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ContatoMapper {
    Contato toDTO(ContatoEntity contatoEntity);
    List<Contato> toDTOList(List<ContatoEntity> contatoEntity);
    ContatoEntity toEntity(Contato contato);
}