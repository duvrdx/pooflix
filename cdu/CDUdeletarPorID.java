import java.lang.annotation.Retention;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class CDUdeletarPorID extends CDU {
    private FormDeletarPorID formDeletarPorID;
    public void exec() {
        formDeletarPorID.exibe(false);
    }

    public CDUdeletarPorID(FormDeletarPorID formDeletarPorID){
        this.formDeletarPorID = formDeletarPorID;
        this.formDeletarPorID.setcdu(this);
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

    public void deletarPorID() {
        // Conexão com o banco de dados
        Connection conn = new ConexaoDAO().conectaBD();
        PreparedStatement pstm = null;

        if(getTipo(formDeletarPorID.gettipo()) != null){
            String tipo = getTipo(formDeletarPorID.gettipo());
            String commandSQL = String.format("delete from %s where id = ?", tipo);

            try {
                pstm = conn.prepareStatement(commandSQL);
                if(tipo == "Serie" || tipo == "Episodio")
                    pstm.setString(1, formDeletarPorID.getid());
                else
                    pstm.setInt(1, Integer.parseInt(formDeletarPorID.getid()));
                
                pstm.execute();
                pstm.close();
                    
                System.out.println("Deletado do banco de dados...");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }else{
            System.out.println("Não foi possivel deletar do banco de dados...");
        }

    }
}