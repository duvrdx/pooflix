import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class CDUcadastrarPerformance extends CDU {
    private Performance performance = null;
    private FormPerformance formPerformance;

    public void exec() {
        formPerformance.exibe(false);
    }

    public CDUcadastrarPerformance(FormPerformance formPerformance){
        this.formPerformance = formPerformance;
        this.formPerformance.setcdu(this);
    }

    public void salvarPerformance() {
        // Conexão com o banco de dados
        Connection conn = new ConexaoDAO().conectaBD();
        PreparedStatement pstm = null; 
        String commandSQL = "insert into Performance (id, idEpisodio, idPersonagem, idAtor) values (?, ?, ?, ?)";

        try {
            pstm = conn.prepareStatement(commandSQL);
            pstm.setInt(1, Integer.parseInt(formPerformance.getid()));
            pstm.setString(2, formPerformance.getidep());
            pstm.setInt(3, Integer.parseInt(formPerformance.getidpersonagem()));
            pstm.setInt(4, Integer.parseInt(formPerformance.getidator()));
            pstm.execute();
            pstm.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        System.out.println("Salvando no banco de dados...");
    }
}