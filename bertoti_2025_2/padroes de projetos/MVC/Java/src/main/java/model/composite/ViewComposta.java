package model.composite;

import java.util.ArrayList;
import java.util.List;

public class ViewComposta implements ViewComponent {

    private List<ViewComponent> views = new ArrayList<>();

    public void adicionar(ViewComponent view) {
        views.add(view);
    }

    @Override
    public void exibirMensagem(int valor) {
        for (ViewComponent v : views) {
            v.exibirMensagem(valor);
        }
    }
}

