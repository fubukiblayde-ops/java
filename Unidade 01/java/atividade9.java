import java.util.ArrayList;
import java.util.List;

public class atividade9 {
    public static void main(String[] args) {
        List<Pessoa> clientes = new ArrayList<>();

        clientes.add(new Pessoa("Ana Silva", 25, "Rua das Flores, 100"));
        clientes.add(new Pessoa("Carlos Souza", 40, "Av. Central, 250"));

        for (Pessoa cliente : clientes) {
            System.out.println(cliente);
        }
    }
}

class Pessoa {
    private String nome;
    private int idade;
    private String endereco;

    public Pessoa(String nome, int idade, String endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", Endereço: " + endereco;
    }
}
