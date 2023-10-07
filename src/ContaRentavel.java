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
        if (retornaSaldo() < 400.0) {
            debita(4.0);
        } else {
            debita(2.0);
        }
    }

    @Override
    public void creditaJuros() {
        depositar(retornaSaldo() * taxaJuros);
    }

    @Override
    public String toString() {
        return "Conta Rentável (Nº " + numConta + "): Saldo = R$" + retornaSaldo();
    }
}