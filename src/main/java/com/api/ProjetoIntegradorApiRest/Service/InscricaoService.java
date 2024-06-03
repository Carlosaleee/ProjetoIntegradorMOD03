package com.api.ProjetoIntegradorApiRest.Service;

import com.api.ProjetoIntegradorApiRest.Data.InscricaoEntity;
import com.api.ProjetoIntegradorApiRest.Data.InscricaoRepository;
import com.api.ProjetoIntegradorApiRest.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InscricaoService {

    @Autowired
    InscricaoRepository InscricaoRepository;

    public InscricaoEntity criarInscricao(InscricaoEntity inscricao) {
        inscricao.setId(null);
        InscricaoRepository.save(inscricao);
        return inscricao;
    }

    public InscricaoEntity atualizarInscricao(Integer inscricaoId, InscricaoEntity inscricaoRequest) {

        InscricaoEntity inscricao = getInscricaoId(inscricaoId);
        inscricao.setNome(inscricaoRequest.getNome());
        inscricao.setEmail(inscricaoRequest.getEmail());
        inscricao.setTelefone(inscricaoRequest.getTelefone());
        inscricao.setDataNascimento(inscricaoRequest.getDataNascimento());
        inscricao.setSexo(inscricaoRequest.getSexo());
        inscricao.setCidade(inscricaoRequest.getCidade());
        inscricao.setCategoria(inscricaoRequest.getCategoria());

        InscricaoRepository.save(inscricao);
        return inscricao;
    }

    public InscricaoEntity getInscricaoId(Integer inscricaoId) {
        return InscricaoRepository.findById(inscricaoId).orElseThrow(() -> new ResourceNotFoundException("Atleta não encontrado " + inscricaoId));
    }

    public List<InscricaoEntity> listarTodasInscricoes() {
        return InscricaoRepository.findAll();
    }

    public void deletarInscricao(Integer inscricaoId) {
        InscricaoEntity inscricao = getInscricaoId(inscricaoId);
        InscricaoRepository.deleteById(inscricao.getId());
    }
}
