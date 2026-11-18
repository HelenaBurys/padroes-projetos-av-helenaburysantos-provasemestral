package questao2;

public class ComissaoArte implements RegraComissao {
    public static final double PERCENTUAL = 0.20;

    @Override
    public double calcularComissao(double valorVenda) {
        return valorVenda * PERCENTUAL;
    }

    @Override
    public String getNomeRegra() {
        return "Arte (20%)";
    }
}
