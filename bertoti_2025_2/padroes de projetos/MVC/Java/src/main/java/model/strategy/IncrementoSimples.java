package model.strategy;

public class IncrementoSimples implements EstrategiaIncremento {
    @Override
    public int incrementar(int valorAtual) {
        return valorAtual + 1;
    }
}

