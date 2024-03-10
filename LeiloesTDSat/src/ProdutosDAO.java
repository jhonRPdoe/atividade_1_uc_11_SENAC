
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
        Connection conn = this.getConexao().conectar();
        ArrayList<ProdutosDTO> listagem = new ArrayList();
        try {
            this.prep = conn.prepareStatement("SELECT * from produtos");
            this.resultset = this.prep.executeQuery();

            while(this.resultset.next()){
                ProdutosDTO produto = this.getModelProduto();
                produto.setId(this.resultset.getInt("id"));
                produto.setNome(this.resultset.getString("nome"));
                produto.setValor(this.resultset.getInt("valor"));
                produto.setStatus(this.resultset.getString("status"));
                listagem.add(produto);
            }
            System.out.println("Comando realizado com sucesso(SELECT)");
            this.getConexao().desconectar(conn);
        } catch (SQLException ex) {
            System.out.println( "Falha no comando executado(SELECT) : " + ex.getMessage());
            this.getConexao().desconectar(conn);
            return null;
        }
        return listagem;
    }
    
    /**
     * Atualiza o registro selecionado pelo usuário
     * @param id
     * @return boolean retorno
     */
    public boolean venderProduto(int id) {
        Connection conn = this.getConexao().conectar();
        boolean retorno;
        try {         
            this.prep = conn.prepareStatement("UPDATE produtos SET status = ? WHERE id = ?");
            this.prep.setString(1, "Vendido");
            this.prep.setInt(2, id);
            this.prep.execute();
            System.out.println("Comando realizado com sucesso(UPDATE)");
            retorno = true;
        }
        catch (Exception ex){
            System.out.println( "Falha no comando executado(UPDATE) : " + ex.getMessage());
            retorno = false;
        }
        this.getConexao().desconectar(conn);
        return retorno;
    }
    
    private ProdutosDTO getModelProduto() {
        return new ProdutosDTO();
    }
    
    private conectaDAO getConexao() {
        conectaDAO conexao = new conectaDAO();
        return conexao;
    }
}

