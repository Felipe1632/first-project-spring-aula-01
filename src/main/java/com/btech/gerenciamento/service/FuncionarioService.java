/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btech.gerenciamento.service;

import com.btech.gerenciamento.model.FuncionarioBean;
import com.btech.gerenciamento.repository.FuncionarioDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class FuncionarioService {
    
    @Autowired
    private FuncionarioDAO repository;
    
    public List<FuncionarioBean> lerTodos() {
        return repository.lerTodos();
    }
    
    public FuncionarioBean lerPorId(int id) {
        return repository.lerPorId(id);
    }
    
    public void editarFuncionario(FuncionarioBean funcionario) {
        repository.editar(funcionario);
    }
    
    public void adicionar(FuncionarioBean funcionario) {
        repository.adicionar(funcionario);
    }
    
}
