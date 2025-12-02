package model.strategy;

public class IncrementoDuplo implements EstrategiaIncremento {
    @Override
    public int incrementar(int valorAtual) {
        return valorAtual + 2;
    }
}

