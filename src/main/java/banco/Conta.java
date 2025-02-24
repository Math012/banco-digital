package banco;

import interfaces.IConta;
import interfaces.ICriptoMoeda;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Conta implements IConta, ICriptoMoeda {

    private static final int AGENCIA_PADRAO = 1;
    private static final double KTC = 30.00;
    private static final double YTR = 10.00;
    private static final double TTQ = 300.00;
    private static final double BYW = 5.00;
    private static int SEQUENCIAL = 1;
    List<CriptoMoeda> moedasCompradas = new ArrayList<>();

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected List<CriptoMoeda> criptoMoeda;
    protected Cliente cliente;

    public Conta(){}

    public Conta(Cliente cliente){
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        this.saldo -=  valor;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }



    public static void setSEQUENCIAL(int SEQUENCIAL) {
        Conta.SEQUENCIAL = SEQUENCIAL;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<CriptoMoeda> getCriptoMoeda() {
        return criptoMoeda;
    }

    public void setCriptoMoeda(List<CriptoMoeda> criptoMoeda) {
        this.criptoMoeda = criptoMoeda;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
        System.out.println("Criptomoedas compradas: ");
        setCriptoMoeda(moedasCompradas);
        if (getCriptoMoeda() != null){
            for (CriptoMoeda moeda:getCriptoMoeda()){
                System.out.println("Nome: " + moeda.getNome());
            }
        }
    }

    @Override
    public void comprarCriptoMoeda(String moeda, IConta contaDestino) {

        switch (moeda){
            case "KTC":
                verificarSaldo(getSaldo(), KTC);
                contaDestino.sacar(KTC);
                moedasCompradas.add(new CriptoMoeda("KTC",KTC));
                break;
            case "YTR":
                verificarSaldo(getSaldo(), YTR);
                contaDestino.sacar(YTR);
                moedasCompradas.add(new CriptoMoeda("YTR",YTR));

                break;
            case "TTQ":
                verificarSaldo(getSaldo(), TTQ);
                contaDestino.sacar(TTQ);
                moedasCompradas.add(new CriptoMoeda("TTQ",TTQ));
                break;
            case "BYW":
                verificarSaldo(getSaldo(), BYW);
                contaDestino.sacar(BYW);
                moedasCompradas.add(new CriptoMoeda("BYW",BYW));
                break;
            default:
                System.out.println("Selecione uma moeda valída");
        }
    }

    public void verificarSaldo(double saldo, double valor){
        if (saldo < valor){
            throw new RuntimeException("Valor insuficiente");
        }
    }


}
