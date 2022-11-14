public class CDUcadastrarAtor extends CDU {
    private Ator ator = null;
    private FormAtor formAtor;

    public void exec() {
        formAtor.exibe();
    }

    public CDUcadastrarAtor(FormAtor formAtor){
        this.formAtor = formAtor;
        this.formAtor.setcdu(this);
    }

    public void salvarAtor() {
        String id = formAtor.getid();
        String nome = formAtor.getnome();

        ator = new Ator(Integer.parseInt(id),nome);
        ator.setNacio(formAtor.getnacionalidade());   

        //bd.salvarEpisodio(episodio);
        System.out.println("Salvando no banco de dados.." + ator);
    }
}