import java.io.Console;

public class FormAtor extends Form{
    private String id;
	private String nome;
    private String nacionalidade;
    private CDUcadastrarAtor cduca;

    public void setcdu(CDUcadastrarAtor cdUcadastrarAtor){
        this.cduca = cdUcadastrarAtor;
    }

    public void exibe(boolean isUpdate){
        Console c = System.console();
        boolean termina = false;
        String continuar;     

        if(!isUpdate) System.out.println("CADASTRANDO ATOR\n");
        else System.out.println("ATUALIZANDO ATOR");

        while(!termina){
            
            id = c.readLine("ID:");
            nome = c.readLine("NOME: ");
            nacionalidade = c.readLine("NACIONALIDADE: ");

            continuar = c.readLine("Deseja continuar cadastrando atores?(s/n): ");
            termina = continuar.toLowerCase().equals("n");
                
            cduca.salvarAtor();
            
        }
    } 

    public String getid() { return id;};
    public String getnome() { return nome;}
    public String getnacionalidade() { return nacionalidade;}
} // class