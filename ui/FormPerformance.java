import java.io.Console;

public class FormPerformance extends Form{
    private String id;
    private String idep;
	private String idpersonagem;
    private String idator;

    private CDUcadastrarPerformance cducp;

    public void setcdu(CDUcadastrarPerformance cdUcadastrarPerformance){
        this.cducp = cdUcadastrarPerformance;
    }

    public void exibe(boolean isUpdate){
        Console c = System.console();
        boolean termina = false;
        String continuar;     

        System.out.println("CADASTRANDO PERFORMANCE\n");

        while(!termina){
            
            id = c.readLine("ID:");
            idep = c.readLine("ID EPISODIO:");
            idpersonagem = c.readLine("ID PERSONAGEM:");
            idator = c.readLine("ID ATOR:");

            continuar = c.readLine("Deseja continuar?(s/n): ");
            termina = continuar.toLowerCase().equals("n");
                
            cducp.salvarPerformance();
            
        }
    } 

    public String getid() { return id;};
    public String getidep() { return idep;};
    public String getidpersonagem() { return idpersonagem;};
    public String getidator() { return idator;};

} // class