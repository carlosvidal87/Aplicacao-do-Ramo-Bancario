public abstract class ContaBancaria implements EmprestimoFinanciavel {
    private static int proxNumConta = 1;
    public int numConta;
    private double saldo;

    public ContaBancaria(double saldoInicial) {
        this.numConta = proxNumConta++;
        this.saldo = saldoInicial;
    }

    public static void setNumContaIni(int num) {
        proxNumConta = num;
    }

    public static int retornaProxNumConta() {
        return proxNumConta;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void debita(double valor) {
        saldo -= valor;
    }

    public double retornaSaldo() {
        return saldo;
    }

    public abstract void debitaTaxa();

    public abstract void creditaJuros();

    public abstract String toString();

    public double valorEmprestimo() {
        return 2 * saldo;
    }
}