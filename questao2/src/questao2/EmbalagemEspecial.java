package questao2;

public class EmbalagemEspecial extends ServicoAdicional {
    public static final double VALOR = 180.00;

    public EmbalagemEspecial(ComponenteFatura faturaDecorada) {
        super(faturaDecorada);
    }

    @Override
    protected String getDescricaoServico() {
        return "Embalagem especial";
    }

    @Override
    protected double calcularCusto(double valorVenda) {
        return VALOR;
    }
}
