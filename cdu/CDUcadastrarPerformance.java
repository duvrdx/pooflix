public class CDUcadastrarPerformance extends CDU {
    private Performance performance = null;
    private FormPerformance formPerformance;

    public void exec() {
        formPerformance.exibe();
    }

    public CDUcadastrarPerformance(FormPerformance formPerformance){
        this.formPerformance = formPerformance;
        this.formPerformance.setcdu(this);
    }

    public void salvarPerformance() {
        String id = formPerformance.getid();
        String idep = formPerformance.getidep();
        String idp = formPerformance.getidpersonagem();
        String idator = formPerformance.getidator();

        performance = new Performance(Integer.parseInt(id));  

        //bd.salvarEpisodio(episodio);
        System.out.println("Salvando no banco de dados.." + performance);
    }
}