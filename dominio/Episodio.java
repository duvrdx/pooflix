import java.util.LinkedList;

public class Episodio {
    private String id;
    private String temporada;
    private String titulo;
    private Serie serie;
    public String resumo;
    private LinkedList<Performance> perfomances;

    public Episodio(String id, String titulo, String temporada, String resumo){
        this.id = id;
        this.titulo = titulo;
        this.temporada = temporada;
        this.resumo = resumo;
    }

    public void adperformance(Performance p){
        perfomances.add(p);
    }

    public Serie getserie(){
        return serie;
    }

    public void setserie(Serie s){
        if(serie == null){
            serie = s;
        }
    }

    public void settitulo(String titulo){
        this.titulo = titulo;
    }

    public String getid(){
        return id;
    }

    public String gettemporada(){ 
        return temporada;
    }

    public String gettitulo(){
        return titulo;
    } 

    public String getresumo(){ 
        return resumo;
    }

    public String toString(){ 
        String s = "";
        s = "id: " + id + ";\n";
        s = s + "Titulo: " + titulo + ";\n";
        s = s + String.valueOf(temporada);
        return s;
    }
}