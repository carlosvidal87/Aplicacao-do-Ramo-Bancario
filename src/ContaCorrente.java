public class ContaCorrente extends ContaBancaria {
    
    public ContaCorrente(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public void debitaTaxa() {
        if (saldo < 400.0) {
            saldo -= 5.0;
        } else {
            saldo -= 3.0;
        }
    }

    @Override
    public void creditaJuros() {
        // Não há juros de rendimento para Conta Corrente
    }

    @Override
    public String toString() {
        return "Conta Corrente - " + super.toString();
    }
}
