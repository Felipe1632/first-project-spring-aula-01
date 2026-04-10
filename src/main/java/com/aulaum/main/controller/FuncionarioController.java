/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aulaum.main.controller;

import com.aulaum.main.dao.FuncionarioDAO;
import com.aulaum.main.model.FuncionarioBean;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Aluno
 */
@Controller
public class FuncionarioController {
    FuncionarioDAO d = new FuncionarioDAO();
      
    @GetMapping("/funcionarios")
    public String funcionarios(Model model) {
       List<FuncionarioBean> lista = d.listarFuncionarios();
       model.addAttribute("lista", lista);
       return "funcionarios";
    }
    
       //ROTA PAINEL     
    @GetMapping("/painel")
        public String abrirPainel(Model model) {
        int total = d.totalFuncionarios();
        model.addAttribute("total", total);
        return "painel";
        }
        
    @GetMapping("/funcionarios/tecnologia")
        public String listarFuncionariosTecnologia(Model model) {
        List<FuncionarioBean> lista = d.listarTecnologia();
        model.addAttribute("lista", lista);
        return "tecnologia";
    }
}
