import java.util.*;

public class atividade10 {
    static class Produto {
        int id, quantidade;
        String nome;
        double preco;

        Produto(int id, String nome, int quantidade, double preco) {
            this.id = id;
            this.nome = nome;
            this.quantidade = quantidade;
            this.preco = preco;
        }

        public String toString() {
            return String.format("ID: %d | Nome: %s | Quantidade: %d | Preço: R$ %.2f",
                    id, nome, quantidade, preco);
        }
    }

    static class Estoque {
        List<Produto> produtos = new ArrayList<>();
        int proximoId = 1;

        Produto adicionar(String nome, int quantidade, double preco) {
            Produto p = new Produto(proximoId++, nome, quantidade, preco);
            produtos.add(p);
            return p;
        }

        Produto buscar(int id) {
            for (Produto p : produtos)
                if (p.id == id) return p;
            return null;
        }
    }

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        int opcao;
        do {
            System.out.println("\n1-Adicionar 2-Remover 3-Atualizar 4-Listar 0-Sair");
            opcao = inteiro("Opção: ");
            switch (opcao) {
                case 1 -> adicionar(estoque);
                case 2 -> remover(estoque);
                case 3 -> atualizar(estoque);
                case 4 -> listar(estoque);
                case 0 -> System.out.println("Sistema encerrado.");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    static void adicionar(Estoque e) {
        Produto p = e.adicionar(texto("Nome: "), naoNegativo("Quantidade: "), preco());
        System.out.println("Adicionado: " + p);
    }

    static void remover(Estoque e) {
        if (e.produtos.isEmpty()) { System.out.println("Estoque vazio."); return; }
        int id = inteiro("ID: ");
        System.out.println(e.produtos.removeIf(p -> p.id == id)
                ? "Removido com sucesso." : "Produto não encontrado.");
    }

    static void atualizar(Estoque e) {
        if (e.produtos.isEmpty()) { System.out.println("Estoque vazio."); return; }
        Produto p = e.buscar(inteiro("ID: "));
        if (p == null) { System.out.println("Produto não encontrado."); return; }
        p.nome = texto("Novo nome: ");
        p.quantidade = naoNegativo("Nova quantidade: ");
        p.preco = preco();
        System.out.println("Atualizado com sucesso.");
    }

    static void listar(Estoque e) {
        if (e.produtos.isEmpty()) { System.out.println("Estoque vazio."); return; }
        for (Produto p : e.produtos) System.out.println(p);
    }

    static String texto(String mensagem) {
        String s;
        do {
            System.out.print(mensagem);
            s = sc.nextLine().trim();
            if (s.isEmpty()) System.out.println("Não pode estar vazio.");
        } while (s.isEmpty());
        return s;
    }

    static int inteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try { return sc.nextInt(); }
            catch (InputMismatchException ex) { System.out.println("Digite um número inteiro."); }
            finally { sc.nextLine(); }
        }
    }

    static int naoNegativo(String mensagem) {
        int n;
        do {
            n = inteiro(mensagem);
            if (n < 0) System.out.println("Não pode ser negativo.");
        } while (n < 0);
        return n;
    }

    static double preco() {
        double n;
        do {
            n = numero("Preço: R$ ");
            if (n < 0) System.out.println("Não pode ser negativo.");
        } while (n < 0);
        return n;
    }

    static double numero(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try { return sc.nextDouble(); }
            catch (InputMismatchException ex) { System.out.println("Digite um número válido."); }
            finally { sc.nextLine(); }
        }
    }
}
