package model.composite;

public class ViewSimples implements ViewComponent {

    private String nome;

    public ViewSimples(String nome) {
        this.nome = nome;
    }

    @Override
    public void exibirMensagem(int valor) {
        System.out.println(nome + " diz: Contador agora é " + valor);
    }
}

