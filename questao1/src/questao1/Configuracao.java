package questao1;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public final class Configuracao {
    private static Configuracao instancia;

    private final String regiaoPadrao;
    private final double orcamentoMensalMaximo;

    private Configuracao() throws IOException {
        Properties propriedades = new Properties();
        try (InputStream entrada = Files.newInputStream(Paths.get("config.properties"))) {
            propriedades.load(entrada);
        }
        this.regiaoPadrao = propriedades.getProperty("regiao.padrao");
        this.orcamentoMensalMaximo = Double.parseDouble(propriedades.getProperty("orcamento.mensal.maximo"));
        if (this.regiaoPadrao == null || this.regiaoPadrao.trim().isEmpty()
                || this.orcamentoMensalMaximo < 0) {
            throw new IllegalArgumentException("Configuracao de regiao ou orcamento invalida.");
        }
    }

    public static synchronized Configuracao obterInstancia() throws IOException {
        if (instancia == null) {
            instancia = new Configuracao();
        }
        return instancia;
    }

    public String getRegiaoPadrao() {
        return this.regiaoPadrao;
    }

    public double getOrcamentoMensalMaximo() {
        return this.orcamentoMensalMaximo;
    }
}
