package view;

import java.time.format.DateTimeParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Entradas {
    private final Scanner scanner = new Scanner(System.in);

    public String lerTexto(String mensagem) {
        System.out.println(mensagem);
        return scanner.nextLine().trim();
    }
    public int lerInt(String mensagem) {
        while (true) {
            try {
                return Integer.parseInt(lerTexto(mensagem));
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. (Digite um número inteiro)");
            }
        }
    }
    public double lerDouble(String mensagem) {
        while (true) {
            try {
                return Double.parseDouble(lerTexto(mensagem).replace(",","."));
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. (Digite um número)");
            }
        }
    }

    public <E extends Enum<E>> E lerEnum(String titulo, E[] opcoes) {
        System.out.println(titulo);
        for (int i = 0; i < opcoes.length; i++) {
            System.out.println(" " + (i + 1) + " - " + opcoes[i]);
        }
        while (true) {
            int escolha = lerInt("Opção: ");
            if (escolha >= 1 && escolha <= opcoes.length) {
                return opcoes[escolha - 1];
            }
            System.out.println("Opção inválida.");
        }
    }
    public void pausar() {
        lerTexto("\nPressione ENTER para continuar...");
    }
    public LocalDateTime lerDataHora(String mensagem) {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        while (true) {
            try {
                return LocalDateTime.parse(lerTexto(mensagem), formatador);
            } catch (DateTimeParseException e) {
                System.out.println("Data ou horário  inválido. Exemplo válido: 20/11/2026 19:30");
            }
        }
    }
}