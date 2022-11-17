import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoDAO {
    public Connection conectaBD(){
        Connection conn = null;

        try {
            String url = String.format("jdbc:mysql://localhost:3306/%s?user=%s&password=%s", Env.database,  Env.user, Env.password);
            conn = DriverManager.getConnection(url);
            // System.out.println("Deu Certo");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, null, 0);
        }

        return conn;
    }
}
