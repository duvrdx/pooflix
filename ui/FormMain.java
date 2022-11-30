import java.io.Console;

public class FormMain extends Form {
    private CDUMain cdumain = null;

    public void setcdu(CDUMain cdumain){
        this.cdumain = cdumain;
    }

    public void exibe(boolean isUpdate) {
        String opcao;
        Console c = System.console();
        boolean termina = false;

        System.out.println("POOFlix\n");

        while(!termina){
            System.out.println("1. Cadastrar Série\n");
            System.out.println("2. Cadastrar Episódio\n");
            System.out.println("3. Cadastrar Ator\n");
            System.out.println("4. Cadastrar Personagem\n");
            System.out.println("5. Cadastrar Performance\n");
            System.out.println("6. Deletar por ID\n");
            System.out.println("10. Sair\n");


            opcao = c.readLine("Digite a opção desejada: ");

            termina = opcao.equals("10");

            if(!termina)
                cdumain.processaOpcao(opcao);
        }
    }    
}
