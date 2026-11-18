package questao2;

public class CertificadoAutenticidade extends ServicoAdicional {
    public static final double VALOR = 300.00;

    public CertificadoAutenticidade(ComponenteFatura faturaDecorada) {
        super(faturaDecorada);
    }

    @Override
    protected String getDescricaoServico() {
        return "Certificado de autenticidade";
    }

    @Override
    protected double calcularCusto(double valorVenda) {
        return VALOR;
    }
}
