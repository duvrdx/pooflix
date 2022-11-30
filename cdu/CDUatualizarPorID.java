import java.lang.annotation.Retention;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class CDUatualizarPorID extends CDU {
    private FormAtualizarPorID formAtualizarPorID;
    public void exec() {
        formAtualizarPorID.exibe();
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

    public void deletarPorID() {
        // Conexão com o banco de dados
        Connection conn = new ConexaoDAO().conectaBD();
        PreparedStatement pstm = null;
    }
}