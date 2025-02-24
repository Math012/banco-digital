package banco;

public class CriptoMoeda {
    private String nome;
    private double valor;


    public CriptoMoeda(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }
}
