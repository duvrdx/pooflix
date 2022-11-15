import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

import javax.swing.JOptionPane;

public class ConexaoDAO {
    public Connection conectaBD(){
        Connection conn = null;

        Dotenv dotenv = Dotenv.load();
        System.out.println(dotenv.get("TEST_KEY"));
        

        try {
            String url = "jdbc:mysql://localhost:3306/database?user=&password=";
            conn = DriverManager.getConnection(url);
            // System.out.println("Deu Certo");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, null, 0);
        }

        return conn;
    }
}
