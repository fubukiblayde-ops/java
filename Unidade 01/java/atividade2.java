public class atividade2 {
    public static void main(String[] args) {
        int produto1 = 1001;
        int produto2 = 1002;
        int produto3 = 1003;
        int produto4 = 1004;
        System.out.println("Informe o código do produto que deseja consultar:");
        int codigo = Integer.parseInt(System.console().readLine());
        // Se e impar ou par
        if (codigo % 2 == 0) {
            System.out.println("O produto " + codigo + " é par.");
        } else {
            System.out.println("O produto " + codigo + " é ímpar.");
        }
    }
}
