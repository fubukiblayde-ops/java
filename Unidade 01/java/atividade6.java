public class atividade6 {
    public static void main(String[] args) {
        for (int numero = 2; numero <= 100; numero++) {
            boolean primo = true;

            for (int divisor = 2; divisor <= numero / 2; divisor++) {
                if (numero % divisor == 0) {
                    primo = false;
                    break;
                }
            }

            if (primo) {
                System.out.print(numero + " ");
            }
        }
    }
}
