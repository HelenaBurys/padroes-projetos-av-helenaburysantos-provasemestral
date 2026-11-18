package questao2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AuditorLances implements ObservadorLance {
    private static final DateTimeFormatter FORMATO =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final List<String> registros = new ArrayList<>();

    @Override
    public synchronized void atualizar(Lote lote, Lance lance, AutorLance autor) {
        this.registros.add(LocalDateTime.now().format(FORMATO) + " | Lote: " + lote.getNome()+ " | Participante: " + autor.getNome()+ " | Lance aceito: R$ " + String.format("%.2f", lance.getValor()));
        System.out.println("[Auditoria] Lance registrado para " + lote.getNome());
    }

    public synchronized List<String> getRegistros() {
        return Collections.unmodifiableList(new ArrayList<>(this.registros));
    }

    public void imprimirRegistros() {
        System.out.println("°°°°° Registros do auditor °°°°°");
        for (String registro : getRegistros()) {
            System.out.println(registro);
        }
    }
}
