/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aulaum.main.dao;

import com.aulaum.main.model.FuncionarioBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class FuncionarioDAO {
    
    public List<FuncionarioBean> listarFuncionarios (){
        List<FuncionarioBean> lista = new ArrayList();
        try {
           Connection conn = Conexao.conectar();
           PreparedStatement stmt = null;
           ResultSet rs = null;
           
           stmt = conn.prepareStatement("SELECT * FROM funcionario");
           rs = stmt.executeQuery();
           
           while(rs.next()) {
               FuncionarioBean funcionario = new FuncionarioBean();
               funcionario.setId(rs.getInt("id"));
               funcionario.setNome(rs.getString("nome"));
               funcionario.setCargo(rs.getString("cargo"));
               funcionario.setDepartamento(rs.getString("departamento"));
               funcionario.setEmail(rs.getString("email"));
               funcionario.setDataContratacao(rs.getDate("data_contratacao"));
               
               lista.add(funcionario);
           }
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
