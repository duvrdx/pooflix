import java.io.Console;

public class FormPersonagem extends Form{
    private String id;
	private String nome;
    private CDUcadastrarPersonagem cducp;

    public void setcdu(CDUcadastrarPersonagem cdUcadastrarPersonagem){
        this.cducp = cdUcadastrarPersonagem;
    }

    public void exibe(boolean isUpdate){
        Console c = System.console();
        boolean termina = false;
        String continuar;     

        if(!isUpdate) System.out.println("CADASTRANDO PERSONAGEM\n");
        else System.out.println("ATUALIZANDO PERSONAGEM");

        while(!termina){
            
            id = c.readLine("ID:");
            nome = c.readLine("NOME: ");

            continuar = c.readLine("Deseja continuar cadastrando personagens?(s/n): ");
            termina = continuar.toLowerCase().equals("n");
                
            cducp.salvarAtor();
            
        }
    } 

    public String getid() { return id;};
    public String getnome() { return nome;}
} // class