package questao2;

public final class AcertoVendedor {
    private AcertoVendedor() {
    }

    public static void imprimir(Lote lote) {
        System.out.println("°°°°° Acerto do vendedor °°°°°");
        System.out.println("Lote: " + lote.getNome());
        System.out.println("Valor de venda: R$ " + String.format("%.2f", lote.getMaiorLance()));
        System.out.println("Comissao (" + lote.getNomeRegraComissao() + "): R$ " + String.format("%.2f", lote.getValorComissao()));
        System.out.println("Liquido a repassar: R$ "+ String.format("%.2f", lote.getValorLiquidoVendedor()));
    }
}
