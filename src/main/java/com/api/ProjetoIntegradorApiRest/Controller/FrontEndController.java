package com.api.ProjetoIntegradorApiRest.Controller;

import com.api.ProjetoIntegradorApiRest.Data.InscricaoEntity;
import com.api.ProjetoIntegradorApiRest.Service.InscricaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FrontEndController {

    @Autowired
    InscricaoService inscricaoService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listarInscricao", inscricaoService.listarTodasInscricoes());
        return "index";
    }
    
    @GetMapping("/deletarInscricao/{id}")
    public String deletarInscricao(@PathVariable(value = "id") Integer id) {
        inscricaoService.deletarInscricao(id);
        return "redirect:/";
    }

    @GetMapping("/criarInscricaoForm")
    public String criarInscricaoForm(Model model) {
        InscricaoEntity inscricao = new InscricaoEntity();
        model.addAttribute("inscricao", inscricao);
        return "inserir";
    }

    @PostMapping("/salvarInscricao")
    public String salvarInscricao(@Valid @ModelAttribute("inscricao") InscricaoEntity inscricao, BindingResult result) {
        if (result.hasErrors()) {
            return "inserir";
        }
        if (inscricao.getId() == null) {
            inscricaoService.criarInscricao(inscricao);
        } else {
            inscricaoService.atualizarInscricao(inscricao.getId(), inscricao);
        }
        return "redirect:/";
    }

    @GetMapping("/atualizarInscricaoForm/{id}")
    public String atualizarInscricaoForm(@PathVariable(value = "id") Integer id, Model model) {
        InscricaoEntity inscricao = inscricaoService.getInscricaoId(id);
        model.addAttribute("inscricao", inscricao);
        return "atualizar";
    }
    
    @GetMapping("/galeria")
    public String mostrarGaleria() {
        return "galeria";
    }
    
    @GetMapping("/listaInscricoes")
    public String mostrarLista(Model model) {
        model.addAttribute("listarInscricao", inscricaoService.listarTodasInscricoes());
        return "listaInscricoes";
    }
}
