import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class atividade8 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Quantidade de pedidos: ");
        int quantidade = entrada.nextInt();

        Map<Integer, Integer> frequencias = new HashMap<>();
        int itemMaisPedido = 0;
        int maiorFrequencia = 0;

        for (int i = 0; i < quantidade; i++) {
            int codigo = entrada.nextInt();
            int frequencia = frequencias.getOrDefault(codigo, 0) + 1;
            frequencias.put(codigo, frequencia);

            if (frequencia > maiorFrequencia) {
                itemMaisPedido = codigo;
                maiorFrequencia = frequencia;
            }
        }

        if (quantidade > 0) {
            System.out.println("Item mais pedido: " + itemMaisPedido);
            System.out.println("Quantidade de pedidos: " + maiorFrequencia);
        } else {
            System.out.println("Nenhum pedido informado.");
        }

        entrada.close();
    }
}
