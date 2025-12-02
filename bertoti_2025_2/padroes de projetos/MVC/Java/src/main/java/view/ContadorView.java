package view;

import model.composite.ViewComponent;
import model.observer.Observador;

public class ContadorView implements Observador {

    private ViewComponent estruturaVisual;

    public ContadorView(ViewComponent estruturaVisual) {
        this.estruturaVisual = estruturaVisual;
    }

    @Override
    public void atualizar(int novoValor) {
        estruturaVisual.exibirMensagem(novoValor);
        
        if (novoValor == 5) {
            System.out.println("💡 Continue assim! Você chegou ao 5!");
        } else if (novoValor == 10) {
            System.out.println("🔥 Uau! Chegou ao 10! Excelente!");
        }
    }
}

