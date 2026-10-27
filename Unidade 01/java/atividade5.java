public class atividade5 {
    public static void main(String[] args) {
        int pedro = 8;
        int felipe = 5;
        int lucas = 3;
        array(pedro, felipe, lucas);
    }

    private static void array(int pedro, int felipe, int lucas) {
        int[] notas = {pedro, felipe, lucas};
        for (int i = 0; i < notas.length; i++) {
            System.out.println("Nota do aluno " + (i + 1) + ": " + notas[i]);
        }
    }
}