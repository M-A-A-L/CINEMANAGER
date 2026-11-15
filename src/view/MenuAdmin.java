package view;

import controller.AdminController;
import controller.ClienteController;

import java.time.LocalDateTime;

public class MenuAdmin {
    private final Entradas entradas;
    private final AdminController controller;

    public MenuAdmin(Entradas entradas, AdminController controller) {
        this.entradas = entradas;
        this.controller = controller;
    }
    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=== Menu Administrador ===");
            System.out.println("1. Cadastrar filme");
            System.out.println("2. Listar filme");
            System.out.println("3. Buscar filme");
            System.out.println("4. Remover filme");
            System.out.println(" ");
            System.out.println("5. Cadastrar sala");
            System.out.println("6. Listar sala");
            System.out.println("7. Buscar sala");
            System.out.println("8. Remover sala");
            System.out.println(" ");
            System.out.println("9. Criar sessão");
            System.out.println("10. Listar sessões");
            System.out.println("11. Buscar sessão");
            System.out.println("12. Deletar sessão");
            System.out.println("0. Voltar");
            opcao = entradas.lerInt("Opção: ");
            System.out.println();
            switch (opcao) {
                case 1 -> cadastrarFilme();
                case 2 -> System.out.println(controller.listarFilmes());
                case 3 -> System.out.println(controller.buscarFilme(entradas.lerInt("Id do filme: ")));
                case 4 -> System.out.println(controller.removerFilme(entradas.lerInt("Id do filme: ")));
                case 5 -> cadastrarSala();
                case 6 -> System.out.println(controller.listarSalas());
                case 7 -> System.out.println(controller.buscarSala(entradas.lerInt("Id da sala: ")));
                case 8 -> System.out.println(controller.removerSala(entradas.lerInt("Id da sala: ")));
                case 9 -> criarSessao();
                case 10 -> System.out.println(controller.listarSessoes());
                case 11 -> System.out.println(controller.buscarSessao(entradas.lerInt("Id da sessão: ")));
                case 12 -> System.out.println(controller.deletarSessao(entradas.lerInt("Id da sessão: ")));
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

    public void cadastrarFilme() {
        String nome = entradas.lerTexto("Nome do filme: ");
        int ano = entradas.lerInt("Ano do filme: ");
        String genero = entradas.lerTexto("Gênero do filme: ");
        int duracaoMin = entradas.lerInt("Duração do filme (em min): ");
        System.out.println(controller.cadastrarFilme(nome, ano, genero, duracaoMin));
    }
    public void cadastrarSala() {
        int numero = entradas.lerInt("Número da sala: ");
        int fileiras = entradas.lerInt("Fileiras: ");
        int colunas = entradas.lerInt("Colunas: ");
        System.out.println(controller.cadastrarSala(numero, fileiras, colunas));
    }
    public void criarSessao() {
        int idFilme = entradas.lerInt("Id do filme: ");
        int idSala = entradas.lerInt("Id da sala: ");
        LocalDateTime dataHora = entradas.lerDataHora("Data e horário da sessão (ex: 20/11/2026 19:30): ");
        double precoBase = entradas.lerDouble("Preço base do ingresso (R$): ");
        System.out.println(controller.criarSessao(idFilme, idSala, dataHora, precoBase));


    }
}
