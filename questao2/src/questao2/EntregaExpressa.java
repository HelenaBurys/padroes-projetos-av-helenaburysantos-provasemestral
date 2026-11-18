package questao2;

public class EntregaExpressa extends ServicoAdicional {
    public static final double VALOR = 450.00;

    public EntregaExpressa(ComponenteFatura faturaDecorada) {
        super(faturaDecorada);
    }

    @Override
    protected String getDescricaoServico() {
        return "Entrega expressa";
    }

    @Override
    protected double calcularCusto(double valorVenda) {
        return VALOR;
    }
}
