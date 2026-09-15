import java.util.Locale;
import java.util.Scanner;

public class Desafio4 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in).useLocale(Locale.US);

        String cliente;

        int opcao;

        int quantidadePedidos = 0;

        double valorCompra;
        double valorTotal = 0;
        double maiorCompra = 0;
        double menorCompra = 0;

        do {

            System.out.println("===== SISTEMA DE PEDIDOS =====");
            System.out.println("1 - Cadastrar Pedido");
            System.out.println("2 - Exibir Relatório");
            System.out.println("3 - Encerrar Sistema");
            System.out.print("Escolha: ");

            opcao = entrada.nextInt();
            entrada.nextLine();

            if (opcao == 1) {

                System.out.print("Nome do cliente: ");
                cliente = entrada.nextLine();

                do {

                    System.out.print("Valor da compra: R$ ");
                    valorCompra = entrada.nextDouble();

                    if (valorCompra <= 0) {
                        System.out.println(
                            "O valor deve ser maior que zero."
                        );
                    }

                } while (valorCompra <= 0);

                quantidadePedidos++;

                valorTotal = valorTotal + valorCompra;

                if (quantidadePedidos == 1 || valorCompra > maiorCompra) {
                    maiorCompra = valorCompra;
                }

                if (quantidadePedidos == 1 || valorCompra < menorCompra) {
                    menorCompra = valorCompra;
                }

                entrada.nextLine();

                System.out.println("Pedido cadastrado!");

            } else if (opcao == 2) {

                if (quantidadePedidos > 0) {

                    double ticketMedio = valorTotal / quantidadePedidos;

                    System.out.println("\n===== RELATÓRIO FINAL =====");

                    System.out.println(
                        "Quantidade de pedidos: " + quantidadePedidos
                    );

                    System.out.printf(
                        "Valor total vendido: R$" + valorTotal );

                    System.out.printf(
                        "Ticket médio: R$" + ticketMedio);

                    System.out.printf(
                        "Maior compra: R$" + maiorCompra);

                    System.out.printf(
                        "Menor compra: R$" + menorCompra);

                } else {

                    System.out.println("Nenhum pedido cadastrado.");
                }

            } else if (opcao == 3) {

                System.out.println("Sistema encerrado.");

            } else {

                System.out.println("Opção inválida.");
            }

        } while (opcao != 3);

        entrada.close();
    }
}