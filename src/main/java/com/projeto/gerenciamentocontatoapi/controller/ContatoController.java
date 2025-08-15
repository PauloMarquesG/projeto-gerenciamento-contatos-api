package com.projeto.gerenciamentocontatoapi.controller;

import com.projeto.gerenciamentocontatoapi.model.Contato;
import com.projeto.gerenciamentocontatoapi.model.ContatoSimples;
import com.projeto.gerenciamentocontatoapi.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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

    @PostMapping
    @Operation(
            summary = "Criar contatos",
            description = "Criar Contato",
            tags = {"Contatos"}
    )
    public ResponseEntity<Contato> criar(@Valid @RequestBody Contato contato){
        return ResponseEntity.ok(this.contatoService.criarContato(contato));
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Atualizar contatos",
            description = "Atualizar Contato",
            tags = {"Contatos"}
    )
    public ResponseEntity<Contato> atualizar(@PathVariable Long id,@Valid @RequestBody Contato contato) {
        return ResponseEntity.ok(this.contatoService.atualizarContato(id, contato));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Excluir contatos",
            description = "Excluir Contato",
            tags = {"Contatos"}
    )
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        this.contatoService.excluirContato(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    @Operation(
            summary = "Atualizar parcialmente contatos",
            description = "Atualizar o contato parcialmente",
            tags = {"Contatos"}
    )
    public ResponseEntity<Contato> atualizarParcial(@PathVariable Long id, @RequestBody ContatoSimples contatoSimples) {
        return ResponseEntity.ok(this.contatoService.atualizarContatoParcial(id, contatoSimples));
    }
}
