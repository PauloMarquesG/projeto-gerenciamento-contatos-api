package com.projeto.gerenciamentocontatoapi.controller;

import com.projeto.gerenciamentocontatoapi.model.Contato;
import com.projeto.gerenciamentocontatoapi.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Tag(name = "Contatos", description = "Gerenciamento de contatos")
@RequestMapping({"/contato"})
public class ContatoController {
    private ContatoService contatoService;

    public ContatoController(ContatoService contatoService){
        this.contatoService = contatoService;}

    @GetMapping
    @Operation(
            summary = "listar todos contatos",
            description = "retorna uma lista completa de contatos cadastrados",
            tags = {"Contatos"}
    )
    public ResponseEntity<List<Contato>> listar(){
        return ResponseEntity.ok(this.contatoService.listarTodosContatos());
    }
}
