/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btech.gerenciamento.controller;

import com.btech.gerenciamento.model.FuncionarioBean;
import com.btech.gerenciamento.service.FuncionarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Usuario
 */
@Controller
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService service;
    
    @GetMapping("/funcionarios")
    public String getFuncionarios(Model model) {
        List<FuncionarioBean> lista = service.lerTodos();
        model.addAttribute("lista", lista);
        return "funcionarios";
    }
    
    @GetMapping("/perfil")
    public String perfil(@RequestParam int id, Model model) {
        FuncionarioBean funcionario = service.lerPorId(id);
        model.addAttribute("funcionario", funcionario);
        return "perfil";
    }
    
    @GetMapping("/adicionar-novo")
    public String adicionarNovo(Model model) {
        FuncionarioBean funcionario = new FuncionarioBean();
        model.addAttribute("funcionario", funcionario);
        return "adicionar-novo";
    }
    
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute FuncionarioBean funcionario) {
        service.editarFuncionario(funcionario);
        return "redirect:/funcionarios";
    }
    
    
    @PostMapping("/adicionar")
    public String adicionar(@ModelAttribute FuncionarioBean funcionario) {
        service.adicionar(funcionario);
        return "redirect:/funcionarios";
    }
}
