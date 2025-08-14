package com.projeto.gerenciamentocontatoapi.mapper;

import com.projeto.gerenciamentocontatoapi.model.Endereco;
import com.projeto.gerenciamentocontatoapi.repository.entities.EnderecoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {
    EnderecoEntity toEntity(Endereco endereco);
}
