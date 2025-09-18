package locacaodvds.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gabri
 */
public class ConnectionFactory {
    
    public static Connection getConnection() throws SQLException {
        
        try {
            // 1. Força o carregamento do driver na memória.
            // Esta é a linha que resolve o erro "No suitable driver found".
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver do MariaDB não encontrado no classpath!", e);
        }
        
        // 2. Tenta se conectar ao banco de dados.
        // Certifique-se de que sua senha do MariaDB/MySQL é realmente vazia ("").
        // Se você definiu uma senha, coloque-a aqui.
        return DriverManager.getConnection(
                "jdbc:mariadb://localhost/locacao_dvds",
                "root",
                ""
        );
    }
}