package view;

public class MenuPrincipal {
    private final Entradas entradas;
    private final MenuAdmin menuAdmin;
    private final MenuCliente menuCliente;

    public MenuPrincipal(Entradas entradas, MenuAdmin menuAdmin, MenuCliente menuCliente) {
        this.entradas = entradas;
        this.menuAdmin = menuAdmin;
        this.menuCliente = menuCliente;
    }

    public void iniciar() {
        int opcao;
        do {
            System.out.println("\n=== CINEMANAGER ===");
            System.out.println("1. Área Cliente");
            System.out.println("2. Área Administração");
            System.out.println("0. Sair");
            opcao = entradas.lerInt("Opção: ");
            System.out.println();
            switch (opcao) {
                case 1 -> menuCliente.exibirMenu();
                case 2 -> menuAdmin.exibirMenu();
                case 0 -> System.out.println("Encerrando . . .");
                default -> {
                    if (opcao != 0) {
                        System.out.println("Opção inválida.");
                    }
                }
            }
        } while (opcao != 0);
    }
}
