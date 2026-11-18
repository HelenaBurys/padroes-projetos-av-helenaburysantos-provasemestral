package questao1;

import java.util.concurrent.atomic.AtomicInteger;

public class FabricaAzure implements FabricaRecursosNuvem {
    private static final double CUSTO_HORA_MAQUINA = 0.12;
    private static final double CUSTO_GB_MES = 0.02;
    private static final double CUSTO_FILA_MES = 0.50;

    private final AtomicInteger sequenciaMaquinas = new AtomicInteger();
    private final AtomicInteger sequenciaArmazenamentos = new AtomicInteger();
    private final AtomicInteger sequenciaFilas = new AtomicInteger();

    @Override
    public MaquinaVirtual criarMaquinaVirtual() {
        int numero = this.sequenciaMaquinas.incrementAndGet();
        return new MaquinaAzure("vm-" + numero, CUSTO_HORA_MAQUINA * 730);
    }

    @Override
    public ArmazenamentoObjetos criarArmazenamentoObjetos(int quantidadeGb) {
        int numero = this.sequenciaArmazenamentos.incrementAndGet();
        return new ArmazenamentoAzure(
                "blob://" + numero, quantidadeGb * CUSTO_GB_MES);
    }

    @Override
    public FilaMensagens criarFilaMensagens() {
        int numero = this.sequenciaFilas.incrementAndGet();
        return new FilaAzure("sb-" + numero, CUSTO_FILA_MES);
    }

    @Override
    public double getCustoHoraMaquina() {
        return CUSTO_HORA_MAQUINA;
    }

    @Override
    public double getCustoGbMes() {
        return CUSTO_GB_MES;
    }

    @Override
    public double getCustoFilaMes() {
        return CUSTO_FILA_MES;
    }

    @Override
    public String getNomeProvedor() {
        return "Azure";
    }
}

final class MaquinaAzure implements MaquinaVirtual {
    private final String identificador;
    private final double custoMensal;

    MaquinaAzure(String identificador, double custoMensal) {
        this.identificador = identificador;
        this.custoMensal = custoMensal;
    }

    @Override
    public String getIdentificador() {
        return this.identificador;
    }

    @Override
    public double getCustoMensal() {
        return this.custoMensal;
    }
}

final class ArmazenamentoAzure implements ArmazenamentoObjetos {
    private final String identificador;
    private final double custoMensal;

    ArmazenamentoAzure(String identificador, double custoMensal) {
        this.identificador = identificador;
        this.custoMensal = custoMensal;
    }

    @Override
    public String getIdentificador() {
        return this.identificador;
    }

    @Override
    public double getCustoMensal() {
        return this.custoMensal;
    }
}

final class FilaAzure implements FilaMensagens {
    private final String identificador;
    private final double custoMensal;

    FilaAzure(String identificador, double custoMensal) {
        this.identificador = identificador;
        this.custoMensal = custoMensal;
    }

    @Override
    public String getIdentificador() {
        return this.identificador;
    }

    @Override
    public double getCustoMensal() {
        return this.custoMensal;
    }
}
