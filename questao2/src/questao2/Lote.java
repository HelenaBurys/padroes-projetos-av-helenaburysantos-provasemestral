package questao2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lote {
    private final String nome;
    private final String categoria;
    private final double precoInicial;
    private final double precoReserva;
    private final List<Lance> lances = new ArrayList<>();
    private final List<ObservadorLance> observadores = new ArrayList<>();
    private RegraComissao regraComissao;
    private double maiorLance;
    private boolean encerrado;
    private boolean vendido;
    private double valorComissao;

    public Lote(String nome, String categoria, double precoInicial,
                double precoReserva, RegraComissao regraComissao) {
        if (nome == null || nome.trim().isEmpty()|| categoria == null || categoria.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome e categoria do lote sao obrigatorios.");
        }
        if (precoInicial < 0 || precoReserva < 0 || regraComissao == null) {
            throw new IllegalArgumentException("Preco ou regra de comissao invalido.");
        }
        this.nome = nome;
        this.categoria = categoria;
        this.precoInicial = precoInicial;
        this.precoReserva = precoReserva;
        this.maiorLance = precoInicial;
        this.regraComissao = regraComissao;
    }

    public void adicionarObservador(ObservadorLance observador) {
        if (observador == null) {
            throw new IllegalArgumentException("O interessado e obrigatorio.");
        }
        if (!this.observadores.contains(observador)) {
            this.observadores.add(observador);
        }
    }

    public void removerObservador(ObservadorLance observador) {
        this.observadores.remove(observador);
    }

    public boolean registrarLance(AutorLance autor, double valor) {
        if (this.encerrado) {
            System.out.println("Lance recusado: o lote " + this.nome + " ja foi encerrado.");
            return false;
        }
        if (autor == null || autor.getNome() == null|| autor.getNome().trim().isEmpty() || valor < 0) {
            throw new IllegalArgumentException("Participante e valor de lance devem ser validos.");
        }

        BigDecimal minimo = BigDecimal.valueOf(this.maiorLance).multiply(BigDecimal.valueOf(1.05));
        if (BigDecimal.valueOf(valor).compareTo(minimo) < 0) {
            System.out.println("Lance recusado para " + this.nome + ": deve ser pelo menos 5% "+ "maior que R$ " + String.format("%.2f", this.maiorLance) + ".");
            return false;
        }

        this.maiorLance = valor;
        Lance lance = new Lance(autor.getNome(), valor);
        this.lances.add(lance);
        for (ObservadorLance observador : new ArrayList<>(this.observadores)) {
            observador.atualizar(this, lance, autor);
        }
        return true;
    }

    public boolean encerrar() {
        if (this.encerrado) {
            throw new IllegalStateException("O lote ja foi encerrado.");
        }
        this.encerrado = true;
        this.vendido = !this.lances.isEmpty() && this.maiorLance >= this.precoReserva;
        if (this.vendido) {
            this.valorComissao = this.regraComissao.calcularComissao(this.maiorLance);
            System.out.println("Lote vendido: " + this.nome + " por R$ "+ String.format("%.2f", this.maiorLance)+ " | Regra de comissao: " + this.regraComissao.getNomeRegra());
        } else {
            System.out.println("Lote nao vendido: " + this.nome+ " | maior lance R$ " + String.format("%.2f", this.maiorLance) + " abaixo da reserva ou sem lances.");
        }
        return this.vendido;
    }

    public void alterarRegraComissao(RegraComissao novaRegra) {
        if (this.encerrado) {
            throw new IllegalStateException("Nao e possivel trocar a comissao de lote encerrado.");
        }
        if (novaRegra == null) {
            throw new IllegalArgumentException("A regra de comissao e obrigatoria.");
        }
        this.regraComissao = novaRegra;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public double getPrecoInicial() {
        return this.precoInicial;
    }

    public double getPrecoReserva() {
        return this.precoReserva;
    }

    public double getMaiorLance() {
        return this.maiorLance;
    }

    public int getQuantidadeLances() {
        return this.lances.size();
    }

    public List<Lance> getLances() {
        return Collections.unmodifiableList(new ArrayList<>(this.lances));
    }

    public boolean isEncerrado() {
        return this.encerrado;
    }

    public boolean isVendido() {
        return this.vendido;
    }

    public double getValorComissao() {
        return this.valorComissao;
    }

    public double getValorLiquidoVendedor() {
        return this.vendido ? this.maiorLance - this.valorComissao : 0;
    }

    public String getNomeRegraComissao() {
        return this.regraComissao.getNomeRegra();
    }
}
