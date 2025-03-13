import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static List<Restaurante> listaRestaurantes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Criar Restaurante");
            System.out.println("2. Ver Restaurantes");
            System.out.println("3. Remover Restaurante");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (opcao) {
                case 1:
                    criarRestaurante();
                    break;
                case 2:
                    verRestaurantes();
                    break;
                case 3:
                    removerRestaurante();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);

        scanner.close();
    }

private static void criarRestaurante() {
    try {
        System.out.println("Insira o nome do restaurante:");
        String nome = scanner.nextLine();

        System.out.println("Insira a nota do restaurante:");
        double nota = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.println("Insira o horário de funcionamento do restaurante:");
        String horario = scanner.nextLine();

        System.out.println("Insira os itens do cardápio (separados por vírgula):");
        String[] itensCardapio = scanner.nextLine().split(",");
        List<String> cardapio = new ArrayList<>();
        for (String item : itensCardapio) {
            cardapio.add(item.trim());
        }

        System.out.println("Insira o custo médio por pessoa:");
        double custoMedio = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Restaurante restaurante = new Restaurante(nome, nota, horario, cardapio, custoMedio);
        listaRestaurantes.add(restaurante);
        System.out.println("Restaurante criado com sucesso!");
    } catch (Exception e) {
        System.out.println("Ocorreu um erro ao criar o restaurante: " + e.getMessage());
    }
}

private static void verRestaurantes() {
    if (listaRestaurantes.isEmpty()) {
        System.out.println("Não há restaurantes cadastrados.");
        return;
    }
    
    for (int i = 0; i < listaRestaurantes.size(); i++) {
        Restaurante restaurante = listaRestaurantes.get(i);
        System.out.println((i + 1) + ". Nome: " + restaurante.getNome() +
                           ", Nota: " + restaurante.getNota() +
                           ", Horário: " + restaurante.getHorarioFuncionamento() +
                           ", Cardápio: " + restaurante.getCardapio() +
                           ", Custo Médio: " + restaurante.getCustoMedio());
    }
}

private static void removerRestaurante() {
    try {
        verRestaurantes();
        
        if (listaRestaurantes.isEmpty()) {
            return;
        }

        System.out.println("Insira o número do restaurante que deseja remover:");
        int indice = scanner.nextInt() - 1;
        
        if (indice >= 0 && indice < listaRestaurantes.size()) {
            listaRestaurantes.remove(indice);
            System.out.println("Restaurante removido com sucesso!");
        } else {
            System.out.println("Número inválido!");
        }
    } catch (Exception e) {
        System.out.println("Ocorreu um erro ao remover o restaurante: " + e.getMessage());
    }
}
}
