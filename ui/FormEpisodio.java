import java.io.Console;

public class FormEpisodio extends Form{
    private String id;
    private String idserie;
    private String temporada;
    private String titulo;
    private String resumo;
    private CDUcadastrarEpis cduce;

    public void setcdu(CDUcadastrarEpis cduce){
        this.cduce = cduce;
    }

    public void exibe(){
        Console c = System.console();
        boolean termina = false;
        String continuar;     
        boolean leserie = true;
        boolean leepisodio = false;  
        String nomeserie = null;

        System.out.println("CADASTRANDO EPISODIO\n");

        while(!termina){
            if(leserie){
                idserie = c.readLine("Qual série?(id): ");
                nomeserie = cduce.getNomeSerie(Integer.parseInt(idserie));
                leepisodio = nomeserie != null;

                if(nomeserie == null) {
                    System.err.println("!!série não existe !!");
                    leserie = true;
                    leepisodio = false;
                    termina = false; 
                }
            }

            if(leepisodio){
                id = c.readLine("@" + nomeserie + ">ID: ");
                temporada = c.readLine("@" + nomeserie + ">Temporada: ");
                titulo = c.readLine("@" + nomeserie + ">Titulo: ");
                resumo = c.readLine("@" + nomeserie + ">Resumo: ");

                continuar = c.readLine("(S)erie (E)pisodio (T)erminar): ");

                if(continuar.toLowerCase().equals("s")){
                    leserie = true;
                    leepisodio = false;
                    termina = false;                    
                }
                else
                    if(continuar.toLowerCase().equals("e")){
                        // salvar episodio no banco de dados.
                        cduce.salvarEpisodio(); // EM OBRAS.
                        leserie = false;
                        leepisodio = true;
                        termina = false;                    
                    }
                    else
                        termina = true;
            } // if(episodio)
        } // while ..
    } // exibe()

    public String getid() { return id;};
    public String getidserie() { return idserie;}
    public String gettemporada() { return temporada;}
    public String gettitulo() { return titulo;}
    public String getresumo() { return resumo; }    
} // class