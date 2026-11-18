package questao2;

public class Main {
    public static void main(String[] args) {
        Participante ana = new Participante("Ana");
        Participante bruno = new Participante("Bruno");
        Participante carla = new Participante("Carla");
        PainelLeiloeiro painel = new PainelLeiloeiro();
        AuditorLances auditor = new AuditorLances();

        Lote quadro = new Lote(
                "Paisagem Azul", "Arte", 1000.00, 1200.00, new ComissaoArte());
        Lote carro = new Lote(
                "Carro Classico", "Veiculos", 60000.00, 64000.00,
                new ComissaoVeiculos());
        Lote imovel = new Lote(
                "Apartamento Central", "Imoveis", 100000.00, 110250.00,
                new ComissaoImoveis());
        Lote eletronico = new Lote(
                "Notebook", "Eletronicos", 300.00, 350.00,
                new ComissaoArte());
        Lote semVenda = new Lote(
                "Escultura sem lances", "Arte", 500.00, 1000.00,
                new ComissaoArte());

        ana.acompanhar(quadro);
        bruno.acompanhar(quadro);
        carla.acompanhar(quadro);
        quadro.adicionarObservador(painel);
        quadro.adicionarObservador(auditor);

        ana.acompanhar(carro);
        bruno.acompanhar(carro);
        carla.acompanhar(carro);
        carro.adicionarObservador(painel);
        carro.adicionarObservador(auditor);

        ana.acompanhar(imovel);
        bruno.acompanhar(imovel);
        carla.acompanhar(imovel);
        imovel.adicionarObservador(painel);
        imovel.adicionarObservador(auditor);

        ana.acompanhar(eletronico);
        bruno.acompanhar(eletronico);
        carla.acompanhar(eletronico);
        eletronico.adicionarObservador(painel);
        eletronico.adicionarObservador(auditor);

        semVenda.adicionarObservador(painel);
        semVenda.adicionarObservador(auditor);

        System.out.println("°°°°° Lances no lote de arte °°°°°");
        ana.darLance(quadro, 1040.00);
        ana.darLance(quadro, 1050.00);
        bruno.deixarDeAcompanhar(quadro);
        System.out.println("Bruno deixou de acompanhar Paisagem Azul.");
        carla.darLance(quadro, 1200.00);

        System.out.println("°°°°° Lances no lote de veiculos °°°°°");
        bruno.darLance(carro, 63000.00);
        carla.darLance(carro, 66000.00);
        carla.darLance(carro, 67000.00);

        System.out.println("°°°°° Lances no lote de imoveis °°°°°");
        ana.darLance(imovel, 105000.00);
        bruno.darLance(imovel, 110250.00);

        System.out.println("°°°°° Lances no lote de eletronicos °°°°°");
        bruno.darLance(eletronico, 315.00);
        eletronico.alterarRegraComissao(new ComissaoEletronicos());
        carla.darLance(eletronico, 350.00);

        System.out.println("°°°°° Encerramento °°°°°");
        quadro.encerrar();
        carro.encerrar();
        imovel.encerrar();
        eletronico.encerrar();
        semVenda.encerrar();

        AcertoVendedor.imprimir(quadro);
        AcertoVendedor.imprimir(carro);
        AcertoVendedor.imprimir(imovel);
        AcertoVendedor.imprimir(eletronico);

        ComponenteFatura fatura = new FaturaVenda(quadro);
        fatura = new SeguroTransporte(fatura);
        fatura = new CertificadoAutenticidade(fatura);
        fatura = new EmbalagemEspecial(fatura);
        fatura = new EmbalagemEspecial(fatura);
        fatura = new EntregaExpressa(fatura);
        FaturaComprador.imprimir(fatura);

        auditor.imprimirRegistros();
    }
}
