
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Adm
 */
public class conectaDAO {
    
    public Connection connectDB(){
        Connection conn = null;
        
        try {
        
            conn = DriverManager.getConnection("jdbc:mysql:3306//localhost/uc11_atividade1?user=root&password=123456789");
            
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + erro.getMessage());
        }
        return conn;
    }
    
    /**
     * Inicia a conexão com o banco de dados
     * @return boolean retorno
     */
    public Connection conectar() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uc11_atividade1","root","123456789");
            System.out.println("Conexão realizada com sucesso");
        } catch(ClassNotFoundException | SQLException ex) {
            System.out.println("Falha na conexão com o banco " + ex.getMessage());
        }
        
        return conn;
    }
    
    /**
     * Encerra a conexão com o banco de dados
     */
    public void desconectar(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
        
        }
    }
    
}
