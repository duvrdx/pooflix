import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class CDUcadastrarSerie  extends CDU {
    private Serie serie;
    private FormSerie formSerie;

    public CDUcadastrarSerie(FormSerie formSerie){
        this.formSerie = formSerie;
        this.formSerie.setcdu(this);
    }

    public void exec() {
        formSerie.exibe(false);
    }

    public void salvarSerie() throws SQLException {
        // Conexão com o banco de dados
        Connection conn = new ConexaoDAO().conectaBD();
        PreparedStatement pstm = null; 
        PreparedStatement pstmVerify = null; 
        String commandSQL = "insert into Serie (id, titulo, classificacao_etaria) values (?, ?, ?)";
        String selectquerySerie = "select * from Serie where titulo = ?";

        pstmVerify = conn.prepareStatement(selectquerySerie);
        pstmVerify.setString(1, formSerie.gettitulo());
        ResultSet rs = pstmVerify.executeQuery();

        rs.first();
    
        if (rs.getString("titulo") == formSerie.gettitulo()) System.out.println("Serie já cadastrada");

        try {
            pstm = conn.prepareStatement(commandSQL);
            pstm.setString(1, formSerie.getid());
            pstm.setString(2, formSerie.gettitulo());
            pstm.setInt(3, Integer.parseInt(formSerie.getidademin()));
            pstm.execute();
            pstm.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        System.out.println("Salvando no banco de dados...");
    }
}