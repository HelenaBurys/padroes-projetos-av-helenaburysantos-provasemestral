package questao2;

import java.util.List;

public interface ComponenteFatura {
    List<ItemFatura> obterItens();

    double getValorVenda();
}
