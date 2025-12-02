package model.observer;

import java.util.ArrayList;
import java.util.List;

public class Contador {

    private int valor = 0;
    private List<Observador> observadores = new ArrayList<>();

    public int getValor() {
        return valor;
    }

    public void setValor(int novoValor) {
        this.valor = novoValor;
        notificar();
    }

    public void adicionarObservador(Observador obs) {
        observadores.add(obs);
    }

    private void notificar() {
        for (Observador obs : observadores) {
            obs.atualizar(valor);
        }
    }
}

