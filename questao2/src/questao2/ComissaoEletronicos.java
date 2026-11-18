package questao2;

public class ComissaoEletronicos implements RegraComissao {
    public static final double PERCENTUAL = 0.12;
    public static final double VALOR_MINIMO = 50.00;

    @Override
    public double calcularComissao(double valorVenda) {
        return Math.max(valorVenda * PERCENTUAL, VALOR_MINIMO);
    }

    @Override
    public String getNomeRegra() {
        return "Eletronicos (12%, minimo R$ 50,00)";
    }
}
