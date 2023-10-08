public abstract class ContaBancaria implements EmprestimoFinanciavel {
    private static int proxNumConta = 1;
    protected int numConta;
    protected double saldo;

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

    public void debitar(double valor) {
        saldo -= valor;
    }

    public double retornaSaldo() {
        return saldo;
    }

    public abstract void debitaTaxa();

    public abstract void creditaJuros();

    @Override
    public double valorEmprestimo() {
        return saldo * 2;
    }

    @Override
    public String toString() {
        return "Conta: " + numConta + ", Saldo: R$" + saldo;
    }
}
