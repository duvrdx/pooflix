import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class CDUcadastrarEpis extends CDU {
    private Episodio episodio = null;
    private FormEpisodio formEpisodio;

    public void exec() {
        formEpisodio.exibe();
    }

    public CDUcadastrarEpis(FormEpisodio telaEpisodio){
        this.formEpisodio = telaEpisodio;
        this.formEpisodio.setcdu(this);
    }

    public String getNomeSerie(int idserie) {
        // Serie serie = bd.getSerie(idserie); EM OBRAS.
        // return serie.gettitulo();
        return "Black Mirror";
    }

    public void salvarEpisodio() {
        // Conexão com o banco de dados
        Connection conn = new ConexaoDAO().conectaBD();
        PreparedStatement pstm = null; 
        String commandSQL = "insert into Personagem (idEpisodio, idSerie, titulo, temporada, resumo) values (?, ?, ?, ?, ?)";

        try {
            pstm = conn.prepareStatement(commandSQL);
            pstm.setString(1, formEpisodio.getid());
            pstm.setString(2, formEpisodio.getidserie());
            pstm.setString(3, formEpisodio.gettitulo());
            pstm.setInt(4, Integer.parseInt(formEpisodio.gettemporada()));
            pstm.setString(5, formEpisodio.getresumo());

            pstm.execute();
            pstm.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        System.out.println("Salvando no banco de dados...");
    }
}