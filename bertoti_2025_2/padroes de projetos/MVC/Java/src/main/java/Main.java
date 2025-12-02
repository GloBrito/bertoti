import controller.ContadorController;
import model.composite.ViewComposta;
import model.composite.ViewSimples;
import model.observer.Contador;
import model.strategy.*;
import view.ContadorView;

public class Main {
    public static void main(String[] args) {

        Contador contador = new Contador();
        ContadorController controller = new ContadorController(contador);

        // Composite
        ViewSimples v1 = new ViewSimples("Tela 1");
        ViewSimples v2 = new ViewSimples("Tela 2");

        ViewComposta painel = new ViewComposta();
        painel.adicionar(v1);
        painel.adicionar(v2);

        // Observer (View recebe notificações)
        ContadorView view = new ContadorView(painel);
        contador.adicionarObservador(view);

        // Strategy (definindo como incrementar)
        controller.setEstrategia(new IncrementoSimples());

        controller.incrementar(); // 1
        controller.incrementar(); // 2
        controller.incrementar(); // 3

        controller.setEstrategia(new IncrementoDuplo());
        controller.incrementar(); // 5
        controller.incrementar(); // 7
    }
}

