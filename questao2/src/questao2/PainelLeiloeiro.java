package questao2;

public class PainelLeiloeiro implements ObservadorLance {
    @Override
    public void atualizar(Lote lote, Lance lance, AutorLance autor) {
        System.out.println("[Painel] " + lote.getNome()+ " | Maior lance: R$ " + String.format("%.2f", lote.getMaiorLance())+ " | Lances recebidos: " + lote.getQuantidadeLances());
    }
}
