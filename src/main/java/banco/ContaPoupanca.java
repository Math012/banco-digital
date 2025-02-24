package banco;

public class ContaPoupanca extends Conta{
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    protected void imprimirInfosComuns() {
        System.out.println("=== Extrato banco Conta Poupança ===");
        super.imprimirInfosComuns();
    }
}
