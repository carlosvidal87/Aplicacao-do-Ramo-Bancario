import java.util.*;


public class ContasApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Contas contas = new Contas();

        while (true) {
            System.out.println("Menu:");
            System.out.println("(1): Nova Conta Corrente");
            System.out.println("(2): Nova Conta Rentável");
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
                    double saldoCorrente = scanner.nextDouble();
                    contas.adicionar(new ContaCorrente(saldoCorrente));
                    break;
                case 2:
                    System.out.print("Digite o saldo inicial: ");
                    double saldoRentavel = scanner.nextDouble();
                    contas.adicionar(new ContaRentavel(saldoRentavel));
                    break;
                case 3:
                    System.out.print("Digite o saldo inicial: ");
                    double saldoEspecial = scanner.nextDouble();
                    contas.adicionar(new ContaEspecial(saldoEspecial));
                    break;
                case 4:
                    System.out.print("Digite o número da conta: ");
                    int numDeposito = scanner.nextInt();
                    ContaBancaria contaDeposito = contas.buscar(numDeposito);
                    if (contaDeposito != null) {
                        System.out.print("Digite o valor a ser depositado: ");
                        double valorDeposito = scanner.nextDouble();
                        contaDeposito.depositar(valorDeposito);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 5:
                    System.out.print("Digite o número da conta: ");
                    int numDebito = scanner.nextInt();
                    ContaBancaria contaDebito = contas.buscar(numDebito);
                    if (contaDebito != null) {
                        System.out.print("Digite o valor a ser debitado: ");
                        double valorDebito = scanner.nextDouble();
                        contaDebito.debita(valorDebito);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 6:
                    contas.creditoJuros();
                    break;
                case 7:
                    for (ContaBancaria conta : contas.getContas()) {
                        conta.debitaTaxa();
                    }
                    break;
                case 8:
                    System.out.print("Digite o número da conta: ");
                    int numConta = scanner.nextInt();
                    ContaBancaria contaBusca = contas.buscar(numConta);
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
                    int numEmprestimo = scanner.nextInt();
                    ContaBancaria contaEmprestimo = contas.buscar(numEmprestimo);
                    if (contaEmprestimo != null) {
                        double valorEmprestimo = contaEmprestimo.valorEmprestimo();
                        System.out.println("O valor para financiamento da conta é R$" + valorEmprestimo);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}
