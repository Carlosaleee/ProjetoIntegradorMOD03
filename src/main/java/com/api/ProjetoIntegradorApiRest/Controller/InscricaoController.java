package com.api.ProjetoIntegradorApiRest.Controller;

import com.api.ProjetoIntegradorApiRest.Data.InscricaoEntity;
import com.api.ProjetoIntegradorApiRest.Service.InscricaoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inscricao")
public class InscricaoController {

    @Autowired
    InscricaoService InscricaoService;

    @GetMapping("/listar")
    public ResponseEntity<List> getAllInscricao() {
        List<InscricaoEntity> inscricao = InscricaoService.listarTodasInscricoes();
        return new ResponseEntity<>(inscricao, HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<InscricaoEntity> getInscricaoById(@PathVariable Integer id) {
        InscricaoEntity inscricao = InscricaoService.getInscricaoId(id);
        return new ResponseEntity<>(inscricao, HttpStatus.OK);
    }

    @PostMapping("/adicionar")
    public ResponseEntity<InscricaoEntity> addInscricao(@RequestBody InscricaoEntity inscricao) {
        var novaInscricao = InscricaoService.criarInscricao(inscricao);
        return new ResponseEntity<>(novaInscricao, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<InscricaoEntity> atualizarInscricao(@PathVariable Integer id, @RequestBody InscricaoEntity inscricao) {
        var inscricaoAtualizado = InscricaoService.atualizarInscricao(id, inscricao);
        return new ResponseEntity<>(inscricaoAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarInscricao(@PathVariable Integer id) {
        InscricaoService.deletarInscricao(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
