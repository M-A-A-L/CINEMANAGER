import domain.padroes.facade.VendaFacade;
import controller.AdminController;
import controller.ClienteController;
import repository.FilmeRepo;
import repository.IngressoRepo;
import repository.SalaRepo;
import repository.SessaoRepo;
import service.FilmeService;
import service.SalaService;
import service.SessaoService;
import view.Entradas;
import view.MenuAdmin;
import view.MenuCliente;
import view.MenuPrincipal;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        FilmeRepo filmeRepo = new FilmeRepo();
        SalaRepo salaRepo = new SalaRepo();
        SessaoRepo sessaoRepo = new SessaoRepo();
        IngressoRepo ingressoRepo = new IngressoRepo();

        FilmeService filmeService = new FilmeService(filmeRepo);
        SalaService salaService = new SalaService(salaRepo);
        SessaoService sessaoService = new SessaoService(sessaoRepo, filmeService, salaService);
        VendaFacade vendaFacade = new VendaFacade(ingressoRepo, sessaoService);

        AdminController adminController = new AdminController(filmeService, salaService, sessaoService);
        ClienteController clienteController = new ClienteController(sessaoService, vendaFacade);

        carregarDadosDemo(filmeService, salaService, sessaoService);

        Entradas entradas = new Entradas();
        MenuAdmin menuAdmin = new MenuAdmin(entradas, adminController);
        MenuCliente menuCliente = new MenuCliente(entradas, clienteController);
        new MenuPrincipal(entradas, menuAdmin, menuCliente).iniciar();
    }
    private static void carregarDadosDemo(FilmeService filmes, SalaService salas, SessaoService sessoes) {
        filmes.salvarFilme("Interestelar", 2014, "Ficção", 169);
        filmes.salvarFilme("Parasita", 2019, "Suspense", 132);
        salas.cadastrarSala(1, 4, 6);
        salas.cadastrarSala(2, 3, 5);
        sessoes.criarSessao(1, 1, LocalDateTime.of(2026, 11, 20, 19, 30), 30.0);
        sessoes.criarSessao(2, 2, LocalDateTime.of(2026, 11, 20, 21, 00), 28.0);
    }
}