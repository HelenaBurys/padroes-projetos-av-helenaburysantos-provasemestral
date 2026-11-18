package questao1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class HistoricoAuditoria {
    private static final HistoricoAuditoria INSTANCIA = new HistoricoAuditoria();
    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    private final List<String> registros = new ArrayList<>();

    private HistoricoAuditoria() {
    }

    public static HistoricoAuditoria obterInstancia() {
        return INSTANCIA;
    }

    public synchronized void registrar(String nomeAmbiente, String provedor, String resultado) {
        String dataHora = LocalDateTime.now().format(FORMATO_DATA);
        this.registros.add(dataHora + " | Ambiente: " + nomeAmbiente + " | Provedor: " + provedor + " | Resultado: " + resultado);
    }

    public synchronized List<String> obterRegistros() {
        return Collections.unmodifiableList(new ArrayList<>(this.registros));
    }

    public void imprimirHistorico() {
        System.out.println("°°°°° Historico de auditoria °°°°°");
        for (String registro : obterRegistros()) {
            System.out.println(registro);
        }
    }
}
