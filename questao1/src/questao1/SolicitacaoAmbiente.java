package questao1;

public class SolicitacaoAmbiente {
    private final String nomeAmbiente;
    private final String provedor;
    private final int quantidadeMaquinas;
    private final int quantidadeGb;

    public SolicitacaoAmbiente(String nomeAmbiente, String provedor,int quantidadeMaquinas, int quantidadeGb) {
        if (nomeAmbiente == null || nomeAmbiente.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do ambiente e obrigatorio.");
        }
        if (provedor == null || provedor.trim().isEmpty()) {
            throw new IllegalArgumentException("O provedor e obrigatorio.");
        }
        if (quantidadeMaquinas < 0 || quantidadeGb < 0) {
            throw new IllegalArgumentException("As quantidades nao podem ser negativas.");
        }
        this.nomeAmbiente = nomeAmbiente;
        this.provedor = provedor;
        this.quantidadeMaquinas = quantidadeMaquinas;
        this.quantidadeGb = quantidadeGb;
    }

    public String getNomeAmbiente() {
        return this.nomeAmbiente;
    }

    public String getProvedor() {
        return this.provedor;
    }

    public int getQuantidadeMaquinas() {
        return this.quantidadeMaquinas;
    }

    public int getQuantidadeGb() {
        return this.quantidadeGb;
    }
}
