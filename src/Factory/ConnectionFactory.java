// situa em qual package ou “pacote” está a classe 
package factory;
// faz as importações de classes necessárias para o funcionamento do programa 

import java.sql.Connection;
// conexão SQL para Java 
import java.sql.DriverManager;
// driver de conexão SQL para Java 
import java.sql.SQLException;
// classe para tratamento de exceções 

public class ConnectionFactory {

    private Connection conn;
    private String usuario = "root";
    private String senha = "";

    public Connection conectar() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", usuario, senha);
        } catch (SQLException excecao) {
            throw new RuntimeException(excecao);
        }
    }

    public void desconectar() throws SQLException {
        conn.close();
    }

    public Connection getConect() {
        return conn;
    }
}
