package controller;

import model.observer.Contador;
import model.strategy.EstrategiaIncremento;

public class ContadorController {

    private Contador contador;
    private EstrategiaIncremento estrategia;

    public ContadorController(Contador contador) {
        this.contador = contador;
    }

    public void setEstrategia(EstrategiaIncremento estrategia) {
        this.estrategia = estrategia;
    }

    public void incrementar() {
        if (estrategia != null) {
            int novoValor = estrategia.incrementar(contador.getValor());
            contador.setValor(novoValor);
        } else {
            System.out.println("Nenhuma estratégia definida!");
        }
    }
}

