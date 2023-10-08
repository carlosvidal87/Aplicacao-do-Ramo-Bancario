import java.util.LinkedList;

public class Contas {
    private LinkedList<ContaBancaria> contas = new LinkedList<>();

    public ContaBancaria buscar(int numConta) {
        for (ContaBancaria conta : contas) {
            if (conta.numConta == numConta) {
                return conta;
            }
        }
        return null;
    }

    public void creditoJuros() {
        for (ContaBancaria conta : contas) {
            conta.creditaJuros();
        }
    }

    public void debitarTaxas() {
        for (ContaBancaria conta : contas) {
            conta.debitaTaxa();
        }
    }

    public void adicionar(ContaBancaria conta) {
        contas.add(conta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ContaBancaria conta : contas) {
            sb.append(conta.toString()).append("\n");
        }
        return sb.toString();
    }
}
