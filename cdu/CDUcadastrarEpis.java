public class CDUcadastrarEpis extends CDU {
    private Episodio episodio = null;
    private FormEpisodio formEpisodio;

    public void exec() {
        formEpisodio.exibe();
    }

    public CDUcadastrarEpis(FormEpisodio formEpisodio){
        this.formEpisodio = formEpisodio;
        this.formEpisodio.setcdu(this);
    }

    public String getNomeSerie(int idserie) {
        // Serie serie = bd.getSerie(idserie); EM OBRAS.
        // return serie.gettitulo();
        return "Black Mirror";
    }

    public void salvarEpisodio() {
        String id = formEpisodio.getid();
        String idserie = formEpisodio.getidserie();
        String temporada = formEpisodio.gettemporada();
        String titulo = formEpisodio.gettitulo();
        String resumo = formEpisodio.getresumo();

        episodio = new Episodio(id,titulo,temporada,resumo);   

        //bd.salvarEpisodio(episodio);
        System.out.println("Salvando no banco de dados.." + episodio);
    }
}