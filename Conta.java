package projeto.cap.oito.fiap;

public class Conta {
    private int id;
    private String numero;
    private double saldo;
    private TipoConta tipo;
    private Cliente cliente;

    // Construtor
    public Conta(int id, String numero, double saldo, TipoConta tipo, Cliente cliente) {
        this.id = id;
        this.numero = numero;
        this.saldo = saldo;
        this.tipo = tipo;
        this.cliente = cliente;
    }

    // Métodos get e set
    // ...

    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("O valor de saque deve ser positivo.");
        } else if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("O valor de depósito deve ser positivo.");
        } else {
            this.saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        }
    }

    public void imprimirDetalhes() {
        System.out.println("Conta Número: " + this.numero);
        System.out.println("Tipo da Conta: " + this.tipo);
        System.out.println("Saldo Atual: R$" + this.saldo);
        System.out.println("Cliente: " + this.cliente.toString());
    }

    public void transferir(Conta contaDestino, double valor) {
        if (valor <= 0) {
            System.out.println("O valor de transferência deve ser positivo.");
        } else if (this.saldo >= valor) {
            this.saldo -= valor;
            contaDestino.saldo += valor;
            System.out.println("Transferência de R$" + valor + " para a conta " + contaDestino.getNumero() + " realizada com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para transferência.");
        }
    }

    public String getNumero() {
        return numero;
    }

    //private String getNumero() {
        // TODO Auto-generated method stub
     //   throw new UnsupportedOperationException("Unimplemented method 'getNumero'");
    //}
}
