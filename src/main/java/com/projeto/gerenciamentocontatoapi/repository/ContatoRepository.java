package com.projeto.gerenciamentocontatoapi.repository;

import com.projeto.gerenciamentocontatoapi.repository.entities.ContatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<ContatoEntity, Long> {}
