package questao1;

public interface FabricaRecursosNuvem {
    MaquinaVirtual criarMaquinaVirtual();

    ArmazenamentoObjetos criarArmazenamentoObjetos(int quantidadeGb);
    FilaMensagens criarFilaMensagens();
    double getCustoHoraMaquina();
    double getCustoGbMes();
    double getCustoFilaMes();
    String getNomeProvedor();
}
