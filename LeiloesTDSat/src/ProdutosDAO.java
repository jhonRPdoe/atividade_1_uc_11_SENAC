/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        conn = new conectaDAO().connectDB();
        boolean retorno;
        try {
            String sql = null;
            this.formataData(dataLancamento);
            sql = "INSERT INTO filmes (nome, datalancamento, categoria) VALUES ('" + nomeFilme + "', '" + this.formataData(dataLancamento) + "', '" + categoriaFilme + "')";
            PreparedStatement statement = this.conn.prepareStatement(sql);
            statement.executeUpdate(sql);
            System.out.println("Comando realizado com sucesso(INSERT)");

            retorno = true;
        }
        catch (SQLException ex){
            System.out.println( "Falha no comando executado(INSERT) : " + ex.getMessage());
            retorno = false;
        }
        this.desconectar();
        return retorno;
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

