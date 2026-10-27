import java.util.Scanner;

public class atividade7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] tabuleiro = new char[3][3];
        char jogador = 'X';
        int jogadas = 0;

        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                tabuleiro[linha][coluna] = ' ';
            }
        }

        while (jogadas < 9) {
            mostrarTabuleiro(tabuleiro);
            System.out.println("Jogador " + jogador + ", informe a linha (1 a 3):");
            int linha = scanner.nextInt() - 1;
            System.out.println("Jogador " + jogador + ", informe a coluna (1 a 3):");
            int coluna = scanner.nextInt() - 1;

            if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2) {
                System.out.println("Posição inválida. Escolha valores entre 1 e 3.");
            } else if (tabuleiro[linha][coluna] != ' ') {
                System.out.println("Essa posição já está ocupada. Tente outra.");
            } else {
                tabuleiro[linha][coluna] = jogador;
                jogadas++;

                if (houveVencedor(tabuleiro, jogador)) {
                    mostrarTabuleiro(tabuleiro);
                    System.out.println("Parabéns! O jogador " + jogador + " venceu!");
                    scanner.close();
                    return;
                }

                jogador = (jogador == 'X') ? 'O' : 'X';
            }
        }

        mostrarTabuleiro(tabuleiro);
        System.out.println("Deu velha! O jogo terminou empatado.");
        scanner.close();
    }

    public static void mostrarTabuleiro(char[][] tabuleiro) {
        System.out.println("\n  1   2   3");
        for (int linha = 0; linha < 3; linha++) {
            System.out.print((linha + 1) + " ");
            for (int coluna = 0; coluna < 3; coluna++) {
                System.out.print(tabuleiro[linha][coluna]);
                if (coluna < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (linha < 2) {
                System.out.println("  ---------");
            }
        }
    }

    public static boolean houveVencedor(char[][] tabuleiro, char jogador) {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador
                    && tabuleiro[i][2] == jogador) {
                return true;
            }
            if (tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador
                    && tabuleiro[2][i] == jogador) {
                return true;
            }
        }

        return (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador
                && tabuleiro[2][2] == jogador)
                || (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador
                        && tabuleiro[2][0] == jogador);
    }
}
