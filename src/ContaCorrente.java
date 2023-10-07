public class ContaCorrente extends ContaBancaria {
    public ContaCorrente(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public void debitaTaxa() {
        if (retornaSaldo() < 400.0) {
            debita(5.0);
        } else {
            debita(3.0);
        }
    }

    @Override
    public void creditaJuros() {
        // Conta corrente não tem juros
    }

    @Override
    public String toString() {
        return "Conta Corrente (Nº " + numConta + "): Saldo = R$" + retornaSaldo();
    }
}