import java.io.Console;

public class FormDeletarPorID extends Form{
    private String id;
    private String tipo;
    private CDUdeletarPorID cducd;

    public void setcdu(CDUdeletarPorID cdUdeletarPorID){
        this.cducd = cdUdeletarPorID;
    }

    public void exibe(boolean isUpdate){
        Console c = System.console();
        boolean termina = false;
        String continuar;     

        System.out.println("DELETANDO POR ID\n");

        while(!termina){
            tipo = c.readLine("TIPO:\n(A)tor | (E)pisodio | (S)erie | (P)ersonagem | (Perf)ormance");           
            id = c.readLine("ID:");

            continuar = c.readLine("Deseja continuar?(s/n): ");
            termina = continuar.toLowerCase().equals("n");
                
            cducd.deletarPorID();
            
        }
    } 

    public String getid() { return id;};
    public String gettipo() { return tipo;}
} // class