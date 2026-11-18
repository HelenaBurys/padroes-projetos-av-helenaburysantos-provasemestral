package questao1;

import java.io.IOException;

public class ProvisionadorAmbiente {
    private static final int HORAS_MENSAIS_ESTIMADAS = 730;

    private final FabricaRecursosNuvem fabrica;

    public ProvisionadorAmbiente(FabricaRecursosNuvem fabrica) {
        if (fabrica == null) {
            throw new IllegalArgumentException("A fabrica de recursos e obrigatoria.");
        }
        this.fabrica = fabrica;
    }

    public void provisionar(SolicitacaoAmbiente solicitacao) throws IOException {
        HistoricoAuditoria auditoria = HistoricoAuditoria.obterInstancia();
        Configuracao configuracao = Configuracao.obterInstancia();
        double custoEstimado = calcularCusto(solicitacao);

        if (custoEstimado > configuracao.getOrcamentoMensalMaximo()) {
            String motivo = "RECUSADO - custo estimado R$ " + String.format("%.2f", custoEstimado)+ " excede o orcamento de R$ "+ String.format("%.2f", configuracao.getOrcamentoMensalMaximo());
            auditoria.registrar(solicitacao.getNomeAmbiente(),
                    this.fabrica.getNomeProvedor(), motivo);
            System.out.println(motivo + ": " + solicitacao.getNomeAmbiente());
            return;
        }

        AmbienteProvisionado ambiente = new AmbienteProvisionado(
                solicitacao.getNomeAmbiente(), this.fabrica.getNomeProvedor(),
                configuracao.getRegiaoPadrao(), custoEstimado);

        for (int i = 0; i < solicitacao.getQuantidadeMaquinas(); i++) {
            ambiente.adicionarRecurso(this.fabrica.criarMaquinaVirtual());
        }
        ambiente.adicionarRecurso(
                this.fabrica.criarArmazenamentoObjetos(solicitacao.getQuantidadeGb()));
        ambiente.adicionarRecurso(this.fabrica.criarFilaMensagens());

        ambiente.imprimirResumo();
        auditoria.registrar(solicitacao.getNomeAmbiente(),
                this.fabrica.getNomeProvedor(), "ACEITO");
    }

    private double calcularCusto(SolicitacaoAmbiente solicitacao) {
        return solicitacao.getQuantidadeMaquinas() * this.fabrica.getCustoHoraMaquina() * HORAS_MENSAIS_ESTIMADAS+ solicitacao.getQuantidadeGb() * this.fabrica.getCustoGbMes()+ this.fabrica.getCustoFilaMes();
    }
}
