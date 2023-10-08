import java.util.Scanner;

public class ContasApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Contas contas = new Contas();

        while (true) {
            System.out.println("Menu:");
            System.out.println("(1): Nova Conta Corrente");
            System.out.println("(2): Nova Conta Rentavel");
            System.out.println("(3): Nova Conta Especial");
            System.out.println("(4): Depositar");
            System.out.println("(5): Debitar");
            System.out.println("(6): Creditar Juros");
            System.out.println("(7): Debita Taxas");
            System.out.println("(8): Buscar Conta");
            System.out.println("(9): Listar todas as contas");
            System.out.println("(10): Valor para financiamento");
            System.out.println("(0): Sair");
            System.out.print("Opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o saldo inicial: ");
                    double saldoCC = scanner.nextDouble();
                    contas.adicionar(new ContaCorrente(saldoCC));
                    break;

                case 2:
                    System.out.print("Digite o saldo inicial: ");
                    double saldoCR = scanner.nextDouble();
                    contas.adicionar(new ContaRentavel(saldoCR));
                    break;

                case 3:
                    System.out.print("Digite o saldo inicial: ");
                    double saldoCE = scanner.nextDouble();
                    contas.adicionar(new ContaEspecial(saldoCE));
                    break;

                case 4:
                    System.out.print("Digite o número da conta: ");
                    int numContaDeposito = scanner.nextInt();
                    ContaBancaria contaDeposito = contas.buscar(numContaDeposito);
                    if (contaDeposito != null) {
                        System.out.print("Digite o valor do depósito: ");
                        double valorDeposito = scanner.nextDouble();
                        contaDeposito.depositar(valorDeposito);
                        System.out.println("Depósito realizado com sucesso.");
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 5:
                    System.out.print("Digite o número da conta: ");
                    int numContaDebito = scanner.nextInt();
                    ContaBancaria contaDebito = contas.buscar(numContaDebito);
                    if (contaDebito != null) {
                        System.out.print("Digite o valor do débito: ");
                        double valorDebito = scanner.nextDouble();
                        contaDebito.debitar(valorDebito);
                        System.out.println("Débito realizado com sucesso.");
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 6:
                    contas.creditoJuros();
                    System.out.println("Juros creditados em todas as contas.");
                    break;

                case 7:
                    contas.debitarTaxas();
                    System.out.println("Taxas debitadas em todas as contas.");
                    break;

                case 8:
                    System.out.print("Digite o número da conta: ");
                    int numContaBusca = scanner.nextInt();
                    ContaBancaria contaBusca = contas.buscar(numContaBusca);
                    if (contaBusca != null) {
                        System.out.println(contaBusca.toString());
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 9:
                    System.out.println(contas.toString());
                    break;

                case 10:
                    System.out.print("Digite o número da conta: ");
                    int numContaFinanciamento = scanner.nextInt();
                    ContaBancaria contaFinanciamento = contas.buscar(numContaFinanciamento);
                    if (contaFinanciamento != null) {
                        double valorEmprestimo = contaFinanciamento.valorEmprestimo();
                        System.out.println("Valor de empréstimo disponível: R$" + valorEmprestimo);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
