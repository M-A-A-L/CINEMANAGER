package view;

import controller.ClienteController;
import domain.model.FormasPagamento;
import domain.model.TiposIngresso;

public class MenuCliente {
    private final Entradas entradas;
    private final ClienteController controller;

    public MenuCliente(Entradas entradas, ClienteController controller) {
        this.entradas = entradas;
        this.controller = controller;
    }
    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=== Menu Cliente ===");
            System.out.println("1. Filmes em cartaz");
            System.out.println("2. Ver sessões de um filme");
            System.out.println("3. Ver assentos de uma sessão");
            System.out.println("4. Comprar ingresso");
            System.out.println("5. Cancelar compra de ingresso");
            System.out.println("0. Voltar");
            opcao = entradas.lerInt("Opção: ");
            System.out.println();
            switch (opcao) {
                case 1 -> System.out.println(controller.listarFilmesEmCartaz());
                case 2 -> {
                    int idSessao = entradas.lerInt("Id do filme: ");
                    System.out.println();
                    System.out.println(controller.listarSessoesDoFilme(idSessao));
                }
                case 3 -> {
                    int idSessao = entradas.lerInt("Id da sessão: ");
                    System.out.println();
                    System.out.println(controller.mostrarAssentos(idSessao));
                }
                case 4 -> {
                    int idSessao = entradas.lerInt("Id da sessão: ");
                    System.out.println();
                    String idAssento = entradas.lerTexto("Digite o código do assento desejado (ex: 'A01'): ");
                    controller.reservarAssento(idSessao, idAssento);
                    TiposIngresso tipo = entradas.lerEnum("Tipo de ingresso: ", TiposIngresso.values());
                    System.out.println();
                    FormasPagamento formaPagamento = entradas.lerEnum("Forma de pagamento: ", FormasPagamento.values());
                    System.out.println();
                    System.out.println(controller.finalizarCompra(tipo, idSessao, idAssento, formaPagamento));
                }
                case 5 -> {
                    String idIngresso = entradas.lerTexto("Código do ingresso: ");
                    System.out.println();
                    System.out.println(controller.cancelarIngresso(idIngresso));
                }
                default -> {
                    if (opcao != 0) {
                        System.out.println("Opção inválida.");
                    }
                }
            }
            if (opcao != 0) {
                entradas.pausar();
            }
        } while (opcao != 0);
    }
}