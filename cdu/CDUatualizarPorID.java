import java.lang.annotation.Retention;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class CDUatualizarPorID extends CDU {
    private FormAtualizarPorID formAtualizarPorID;
    public void exec() {
        formAtualizarPorID.exibe(false);
    }

    public CDUatualizarPorID(FormAtualizarPorID formAtualizarPorID){
        this.formAtualizarPorID = formAtualizarPorID;
        this.formAtualizarPorID.setcdu(this);
    }

    private String getTipo(String tipo){
        switch(tipo.toLowerCase()){
            case "a":
                return "Ator";
            case "e":
                return "Episodio";
            case "s":
                return "Serie";
            case "p":
                return "Personagem";
            case "perf":
                return "Performance";
            default:
                return null;
        }
    }

    public void atualizarPorID() {

        // Conexão com o banco de dados
        Connection conn = new ConexaoDAO().conectaBD();
        PreparedStatement pstm = null;

        String tipo = getTipo(formAtualizarPorID.gettipo());

        //Deletando dando para atualizar novo item
        if(getTipo(formAtualizarPorID.gettipo()) != null){
            String commandSQL = String.format("delete from %s where id = ?", tipo);

            try {
                pstm = conn.prepareStatement(commandSQL);
                if(tipo == "Serie" || tipo == "Episodio")
                    pstm.setString(1, formAtualizarPorID.getid());
                else
                    pstm.setInt(1, Integer.parseInt(formAtualizarPorID.getid()));
                
                pstm.execute();
                pstm.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }else{
            System.out.println("Não foi possivel deletar do banco de dados...");
        }

        //Atualizando
        CDUMain cduMain = new CDUMain(new FormMain());

        switch(formAtualizarPorID.gettipo().toLowerCase()){
            case "a":
                cduMain.execCadAtor();
                break;
            case "e":
                cduMain.execCadEpisodio();
                break;
            case "s":
                cduMain.execCadSerie();
                break;
            case "p":
                cduMain.execCadPersonagem();
                break;
            case "perf":
                cduMain.execCadPerformance();
                break;
            default:
                System.out.println("Não existe!");
                break;
        }

    }
}