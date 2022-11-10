public class Performance {
    private Episodio episodio;
    private Personagem personagem;
    private Ator ator;

    public Performance(Episodio epi,Personagem person,Ator ator){
        episodio = epi;
        personagem = person;
        this.ator = ator;
    }

    public Episodio getidep(){
        return episodio;
    }

    public Personagem getidperson(){
        return personagem;
    }

    public Ator getator(){
        return ator;
    }
}