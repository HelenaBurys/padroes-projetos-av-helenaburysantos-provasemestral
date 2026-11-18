package questao2;

public class Participante implements ObservadorLance, AutorLance {
    private final String nome;

    public Participante(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do participante e obrigatorio.");
        }
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    public void acompanhar(Lote lote) {
        lote.adicionarObservador(this);
    }

    public void deixarDeAcompanhar(Lote lote) {
        lote.removerObservador(this);
    }

    public void darLance(Lote lote, double valor) {
        lote.registrarLance(this, valor);
    }

    @Override
    public void atualizar(Lote lote, Lance lance, AutorLance autor) {
        if (this != autor) {
            System.out.println("[Participante " + this.nome + "] Novo lance no lote "+ lote.getNome() + ": R$ " + String.format("%.2f", lance.getValor()));
        }
    }
}
