package questao1;

import java.util.concurrent.atomic.AtomicInteger;

public class FabricaAws implements FabricaRecursosNuvem {
    private static final double CUSTO_HORA_MAQUINA = 0.10;
    private static final double CUSTO_GB_MES = 0.023;
    private static final double CUSTO_FILA_MES = 0.40;

    private final AtomicInteger sequenciaMaquinas = new AtomicInteger();
    private final AtomicInteger sequenciaArmazenamentos = new AtomicInteger();
    private final AtomicInteger sequenciaFilas = new AtomicInteger();

    @Override
    public MaquinaVirtual criarMaquinaVirtual() {
        int numero = this.sequenciaMaquinas.incrementAndGet();
        return new MaquinaAws("i-" + numero, CUSTO_HORA_MAQUINA * 730);
    }

    @Override
    public ArmazenamentoObjetos criarArmazenamentoObjetos(int quantidadeGb) {
        int numero = this.sequenciaArmazenamentos.incrementAndGet();
        return new ArmazenamentoAws(
                "s3://" + numero, quantidadeGb * CUSTO_GB_MES);
    }

    @Override
    public FilaMensagens criarFilaMensagens() {
        int numero = this.sequenciaFilas.incrementAndGet();
        return new FilaAws("sqs-" + numero, CUSTO_FILA_MES);
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
        return "AWS";
    }
}

final class MaquinaAws implements MaquinaVirtual {
    private final String identificador;
    private final double custoMensal;

    MaquinaAws(String identificador, double custoMensal) {
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

final class ArmazenamentoAws implements ArmazenamentoObjetos {
    private final String identificador;
    private final double custoMensal;

    ArmazenamentoAws(String identificador, double custoMensal) {
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

final class FilaAws implements FilaMensagens {
    private final String identificador;
    private final double custoMensal;

    FilaAws(String identificador, double custoMensal) {
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
