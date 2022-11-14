public class Performance {
    private int id;
    private Episodio episodio;
    private Personagem personagem;
    private Ator ator;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Episodio getEpisodio() {
        return this.episodio;
    }

    public void setEpisodio(Episodio episodio) {
        this.episodio = episodio;
    }

    public Personagem getPersonagem() {
        return this.personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public Ator getAtor() {
        return this.ator;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }

    public Performance(int id){
        this.id = id;
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