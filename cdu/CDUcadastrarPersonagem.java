import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class CDUcadastrarPersonagem extends CDU {
    private Personagem personagem = null;
    private FormPersonagem formPersonagem;

    public void exec() {
        formPersonagem.exibe();
    }

    public CDUcadastrarPersonagem(FormPersonagem formPersonagem){
        this.formPersonagem = formPersonagem;
        this.formPersonagem.setcdu(this);
    }

    public void salvarAtor() {
        // Conexão com o banco de dados
        Connection conn = new ConexaoDAO().conectaBD();
        PreparedStatement pstm = null; 
        String commandSQL = "insert into Personagem (idPersonagem, nome) values (?, ?)";

        try {
            pstm = conn.prepareStatement(commandSQL);
            pstm.setInt(1, Integer.parseInt(formPersonagem.getid()));
            pstm.setString(2, formPersonagem.getnome());
            pstm.execute();
            pstm.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        System.out.println("Salvando no banco de dados...");
        
    }
}