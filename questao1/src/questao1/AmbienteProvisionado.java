package questao1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmbienteProvisionado {
    private final String nome;
    private final String provedor;
    private final String regiao;
    private final double custoMensalEstimado;
    private final List<String> identificadoresRecursos;

    public AmbienteProvisionado(String nome, String provedor, String regiao, double custoMensalEstimado) {
        this.nome = nome;
        this.provedor = provedor;
        this.regiao = regiao;
        this.custoMensalEstimado = custoMensalEstimado;
        this.identificadoresRecursos = new ArrayList<>();
    }

    public void adicionarRecurso(RecursoNuvem recurso) {
        this.identificadoresRecursos.add(recurso.getIdentificador());
    }

    public String getNome() {
        return this.nome;
    }

    public String getProvedor() {
        return this.provedor;
    }

    public String getRegiao() {
        return this.regiao;
    }

    public double getCustoMensalEstimado() {
        return this.custoMensalEstimado;
    }

    public List<String> getIdentificadoresRecursos() {
        return Collections.unmodifiableList(this.identificadoresRecursos);
    }

    public void imprimirResumo() {
        synchronized (System.out) {
            System.out.println("°°°°° Ambiente provisionado °°°°°");
            System.out.println("Nome: " + this.nome);
            System.out.println("Provedor: " + this.provedor);
            System.out.println("Regiao: " + this.regiao);
            System.out.println("Recursos: " + this.identificadoresRecursos);
            System.out.println("Custo mensal estimado: R$ " + String.format("%.2f", this.custoMensalEstimado));
        }
    }
}
