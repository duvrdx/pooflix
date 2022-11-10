import java.util.LinkedList;

public class Ator {
	private int id;
	private String nome;
	private String nacionalidade;
    private LinkedList<Performance> performances;

	public Ator(int id,String nome){
        this.id = id;
        this.nome = nome;
        performances = new LinkedList<Performance>();
	}

    public void adperformance(Performance p){
        performances.add(p);
    }

	public void setNacio(String nacionalidade){
        this.nacionalidade = nacionalidade;
	}

	public int getid(){
        return id;
	}

	public String getnome(){
        return nome;
	}

	public String getnacionalidade(){
        return nacionalidade;
	}
}