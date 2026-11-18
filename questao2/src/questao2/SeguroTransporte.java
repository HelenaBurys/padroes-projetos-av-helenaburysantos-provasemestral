package questao2;

public class SeguroTransporte extends ServicoAdicional {
    public static final double PERCENTUAL = 0.015;

    public SeguroTransporte(ComponenteFatura faturaDecorada) {
        super(faturaDecorada);
    }

    @Override
    protected String getDescricaoServico() {
        return "Seguro de transporte (1,5%)";
    }

    @Override
    protected double calcularCusto(double valorVenda) {
        return valorVenda * PERCENTUAL;
    }
}
