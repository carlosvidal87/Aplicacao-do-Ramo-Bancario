import java.util.LinkedList;
import java.util.List;

public class Contas {
    private LinkedList<ContaBancaria> contas;

    public Contas() {
        contas = new LinkedList<>();
    }

    public ContaBancaria buscar(int numConta) {
        for (ContaBancaria conta : contas) {
            if (conta.numConta == numConta) {
                return conta;
            }
        }
        return null;
    }

    public List<ContaBancaria> getContas() {
        return contas;
    }

    public void creditoJuros() {
        for (ContaBancaria conta : contas) {
            conta.creditaJuros();
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