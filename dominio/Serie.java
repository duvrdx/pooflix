import java.util.HashMap;
import java.util.LinkedList;

public class Serie {
    private String id;
    private String titulo;
    private int classetaria;
    private HashMap<String, Episodio> episodios;
    private LinkedList<Categoria> categorias;

    public Serie(String id, String titulo, Integer clsetaria) {
        this.id = id;
        this.titulo = titulo;
        classetaria = clsetaria;
        episodios = new HashMap<String, Episodio>();
        categorias = new LinkedList<Categoria>();
    }

    public void adepisodio(Episodio e){
        episodios.put(e.getid(),e);
    }

    public void setcategoria(Categoria cat){
        categorias.add(cat);
    }

    public String[] getcategorias(){
        String[] array = new String[categorias.size()];

        for(int i=0; i < categorias.size(); i++)
            array[i] = String.valueOf(categorias.get(i));

        return array;
    }

    public String getid(){
        return id;
    }

    public String gettitulo(){
        return titulo;
    }

    public String toString(){ 
        String s = "";
        s = "id: " + id + ";\n";
        s = s + "Titulo: " + titulo + ";\n";
        s = s + "Class etária: " + classetaria + ";\n";
        return s;
    }
}