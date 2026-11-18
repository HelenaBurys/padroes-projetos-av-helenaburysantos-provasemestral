package questao2;

public final class FaturaComprador {
    private FaturaComprador() {
    }

    public static void imprimir(ComponenteFatura fatura) {
        System.out.println("°°°°° Fatura do comprador °°°°°");
        double total = 0;
        for (ItemFatura item : fatura.obterItens()) {
            System.out.println(item.getDescricao() + ": R$ "+ String.format("%.2f", item.getValor()));
            total += item.getValor();
        }
        System.out.println("Total a pagar: R$ " + String.format("%.2f", total));
    }
}
