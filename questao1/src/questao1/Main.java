package questao1;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    private static final FabricaRecursosNuvem FABRICA_AWS = new FabricaAws();
    private static final FabricaRecursosNuvem FABRICA_AZURE = new FabricaAzure();

    public static void main(String[] args) throws Exception {
        Configuracao.obterInstancia();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        try {
            Future<?> primeiroAws = executor.submit(() -> provisionar(new SolicitacaoAmbiente("Ambiente AWS Principal", "AWS", 2, 100)));
            Future<?> segundoAws = executor.submit(() -> provisionar(new SolicitacaoAmbiente("Ambiente AWS Testes", "AWS", 1, 10)));

            primeiroAws.get();
            segundoAws.get();

            provisionar(new SolicitacaoAmbiente("Ambiente Azure", "Azure", 1, 100));
            provisionar(new SolicitacaoAmbiente("Ambiente AWS Acima Orcamento", "AWS", 4, 100));
        } finally {
            executor.shutdown();
        }

        HistoricoAuditoria.obterInstancia().imprimirHistorico();
    }

    private static void provisionar(SolicitacaoAmbiente solicitacao) {
        try {
            FabricaRecursosNuvem fabrica = selecionarFabrica(solicitacao.getProvedor());
            new ProvisionadorAmbiente(fabrica).provisionar(solicitacao);
        } catch (IOException e) {
            throw new IllegalStateException("Nao foi possivel carregar config.properties.", e);
        }
    }

    private static FabricaRecursosNuvem selecionarFabrica(String provedor) {
        switch (provedor) {
            case "AWS":
                return FABRICA_AWS;
            case "Azure":
                return FABRICA_AZURE;
            default:
                throw new IllegalArgumentException("Provedor nao suportado: " + provedor);
        }
    }
}
