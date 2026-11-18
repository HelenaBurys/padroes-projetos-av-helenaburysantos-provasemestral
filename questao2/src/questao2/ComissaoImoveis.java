package questao2;

public class ComissaoImoveis implements RegraComissao {
    public static final double PERCENTUAL = 0.03;
    public static final double VALOR_FIXO = 1500.00;

    @Override
    public double calcularComissao(double valorVenda) {
        return valorVenda * PERCENTUAL + VALOR_FIXO;
    }

    @Override
    public String getNomeRegra() {
        return "Imoveis (3% + R$ 1.500,00)";
    }
}
