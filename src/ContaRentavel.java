public class ContaRentavel extends ContaBancaria {
    private static double taxaJuros = 0.05;

    public ContaRentavel(double saldoInicial) {
        super(saldoInicial);
    }

    public static void setTaxaJuros(double novaTaxa) {
        taxaJuros = novaTaxa;
    }

    public static double getTaxaJuros() {
        return taxaJuros;
    }

    @Override
    public void debitaTaxa() {
        if (saldo < 400.0) {
            saldo -= 4.0;
        } else {
            saldo -= 2.0;
        }
    }

    @Override
    public void creditaJuros() {
        saldo += saldo * taxaJuros;
    }

    @Override
    public String toString() {
        return "Conta Rentável - " + super.toString();
    }
}
