public class ContaEspecial extends ContaBancaria {
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
        debita(2.0);
    }

    @Override
    public void creditaJuros() {
        depositar(retornaSaldo() * taxaJuros);
    }

    @Override
    public String toString() {
        return "Conta Especial (Nº " + numConta + "): Saldo = R$" + retornaSaldo();
    }
}