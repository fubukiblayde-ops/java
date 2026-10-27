import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class atividade4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> listaEspera = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n--- Lista de espera ---");
            System.out.println("1 - Adicionar cliente");
            System.out.println("2 - Remover próximo cliente");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nome = scanner.nextLine();
                    listaEspera.add(nome);
                    exibirLista(listaEspera);
                    break;

                case 2:
                    if (listaEspera.isEmpty()) {
                        System.out.println("Não há clientes na lista de espera.");
                    } else {
                        String atendido = listaEspera.remove(0);
                        System.out.println("Cliente removido: " + atendido);
                        exibirLista(listaEspera);
                    }
                    break;

                case 0:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirLista(List<String> listaEspera) {
        System.out.println("Clientes aguardando: " + listaEspera.size());
        if (listaEspera.isEmpty()) {
            System.out.println("Lista vazia.");
        } else {
            for (int i = 0; i < listaEspera.size(); i++) {
                System.out.println((i + 1) + ". " + listaEspera.get(i));
            }
        }
    }
}
