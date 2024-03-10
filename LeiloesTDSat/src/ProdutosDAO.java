
/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProdutosDAO {

    PreparedStatement prep;
    ResultSet resultset;
    
    public boolean cadastrarProduto (ProdutosDTO produto){
        Connection conn = this.getConexao().conectar();
        boolean retorno;
        try {
            this.prep = conn.prepareStatement("INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)");
            this.prep.setString(1, produto.getNome());
            this.prep.setDouble(2, produto.getValor());
            this.prep.setString(3, produto.getStatus());
            this.prep.execute();
            System.out.println("Comando realizado com sucesso(INSERT)");

            retorno = true;
        }
        catch (Exception ex){
            System.out.println( "Falha no comando executado(INSERT) : " + ex.getMessage());
            retorno = false;
        }
        this.getConexao().desconectar(conn);
        return retorno;
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        ArrayList<ProdutosDTO> listagem = new ArrayList();
        return listagem;
    }
    
    private ProdutosDTO getModelProduto() {
        return new ProdutosDTO();
    }
    
    private conectaDAO getConexao() {
        conectaDAO conexao = new conectaDAO();
        return conexao;
    }
}

