package questao2;

public class Lance {
    private final String nomeParticipante;
    private final double valor;

    public Lance(String nomeParticipante, double valor) {
        this.nomeParticipante = nomeParticipante;
        this.valor = valor;
    }

    public String getNomeParticipante() {
        return this.nomeParticipante;
    }

    public double getValor() {
        return this.valor;
    }
}
