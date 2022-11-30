import java.io.Console;
import java.sql.SQLException;

public class FormSerie extends Form {
    private String id;
    private String titulo;
    private String idademin;
    private CDUcadastrarSerie cducs;

    public void setcdu(CDUcadastrarSerie cducs){
        this.cducs = cducs;
    }

    public void exibe(boolean isUpdate){
        Console c = System.console();
        boolean termina = false;
        String continuar;        

        if(!isUpdate) System.out.println("CADASTRANDO SÉRIE\n");
        else System.out.println("ATUALIZANDO SÉRIE");

        while(!termina){
            id = c.readLine("ID: ");
            titulo = c.readLine("Titulo: ");
            idademin = c.readLine("Idade mínima: ");

            continuar = c.readLine("Deseja continuar?(s/n): ");
            termina = continuar.toLowerCase().equals("n");

            
            try {
                cducs.salvarSerie();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String getid(){
        return id;
    }

    public String gettitulo(){
        return titulo;
    }

    public String getidademin(){
        return idademin;
    }
}