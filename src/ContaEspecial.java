public class ContaEspecial extends ContaRentavel {
    private static double taxaJuros = 0.07;

    public ContaEspecial(double saldoInicial) {
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
        saldo -= 2.0;
    }

    @Override
    public void creditaJuros() {
        saldo += saldo * taxaJuros;
    }

    @Override
    public String toString() {
        return "Conta Especial - " + super.toString();
    }
}
