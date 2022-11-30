import java.io.Console;

public class FormAtualizarPorID extends Form{
    private String id;
    private String tipo;
    private CDUatualizarPorID cduaid;

    public void setcdu(CDUatualizarPorID cdUatualizarPorID){
        this.cduaid = cdUatualizarPorID;
    }

    public void exibe(boolean isUpdate){
        Console c = System.console();
        boolean termina = false;
        String continuar;     

        System.out.println("DELETANDO POR ID\n");

        while(!termina){
            tipo = c.readLine("TIPO:\n(A)tor | (E)pisodio | (S)erie | (P)ersonagem | (Perf)ormance");            
            id = c.readLine("ID:");
            
            cduaid.atualizarPorID();

            continuar = c.readLine("Deseja continuar atualizando?(s/n): ");
            termina = continuar.toLowerCase().equals("n"); 
            
        }
    } 

    public String getid() { return id;};
    public String gettipo() { return tipo;}
} // class