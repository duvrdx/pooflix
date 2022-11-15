import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class CDUcadastrarAtor extends CDU {
    private Ator ator = null;
    private FormAtor formAtor;

    public void exec() {
        formAtor.exibe();
    }

    public CDUcadastrarAtor(FormAtor formAtor){
        this.formAtor = formAtor;
        this.formAtor.setcdu(this);
    }

    public void salvarAtor() {
        // Conexão com o banco de dados
        Connection conn = new ConexaoDAO().conectaBD();
        PreparedStatement pstm = null; 
        String commandSQL = "insert into Ator (idAtor, nome, nacionalidade) values (?, ?, ?)";

        try {
            pstm = conn.prepareStatement(commandSQL);
            pstm.setInt(1, Integer.parseInt(formAtor.getid()));
            pstm.setString(2, formAtor.getnome());
            pstm.setString(3, formAtor.getnacionalidade());
            pstm.execute();
            pstm.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        System.out.println("Salvando no banco de dados...");
    }
}