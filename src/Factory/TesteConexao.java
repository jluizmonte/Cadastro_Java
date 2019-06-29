package factory; 
import java.sql.Connection; 
import java.sql.SQLException; 
public class TesteConexao {     
    public static void main(String[] args) throws SQLException {
         Connection conn = new ConnectionFactory().getConect();
         System.out.println("Conexão aberta!");
         conn.close();
     }
}