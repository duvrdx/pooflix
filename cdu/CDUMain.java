public class CDUMain  extends CDU {
    private FormMain formMain;

    public CDUMain(FormMain formMain){
        this.formMain = formMain;
        this.formMain.setcdu(this);
    }  
    
    public void exec() {
        formMain.exibe();
    }

    public void processaOpcao(String opcao){
        switch(opcao) {
            case "1": execCadSerie(); break;
            case "2": execCadEpisodio(); break;
        }
    }

    public void execCadSerie(){
        FormSerie telaSerie = new FormSerie();
        CDUcadastrarSerie casoUsoSerie = new CDUcadastrarSerie(telaSerie);
        casoUsoSerie.exec();
    }

    public void execCadEpisodio(){
        FormEpisodio telaEpisodio = new FormEpisodio();
        CDUcadastrarEpis casoUsoEpis = new CDUcadastrarEpis(telaEpisodio);
        casoUsoEpis.exec();        
    }
}
