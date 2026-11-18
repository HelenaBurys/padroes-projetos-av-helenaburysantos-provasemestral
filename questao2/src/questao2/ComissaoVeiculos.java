package questao2;

public class ComissaoVeiculos implements RegraComissao {
    public static final double PERCENTUAL = 0.08;
    public static final double LIMITE_MAXIMO = 5000.00;

    @Override
    public double calcularComissao(double valorVenda) {
        return Math.min(valorVenda * PERCENTUAL, LIMITE_MAXIMO);
    }

    @Override
    public String getNomeRegra() {
        return "Veiculos (8%, maximo R$ 5.000,00)";
    }
}
