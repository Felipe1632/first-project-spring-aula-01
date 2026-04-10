/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aulaum.main.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Aluno
 */
public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3307/empresa_db";
    private static final String usuario = "root";
    private static final String senha = "";
   
    public static Connection conectar() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, usuario, senha);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
