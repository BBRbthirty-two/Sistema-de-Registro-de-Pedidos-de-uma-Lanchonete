import java.util.Locale;
import java.util.Scanner;

public class Desafio5 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in).useLocale(Locale.US);

        String cliente , resposta;

        int quantidadePedidos = 0;

        double valorCompra;
        double valorTotal = 0;
        double maiorCompra = 0;
        double menorCompra = 0;

        do {

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

            System.out.println("Cadastrar novo pedido?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            System.out.print("Escolha: ");

            resposta = entrada.nextLine();

        } while (resposta.equals(1));

        double ticketMedio = valorTotal / quantidadePedidos;

        System.out.println("Quantidade de pedidos: " + quantidadePedidos);
        System.out.printf("Valor total vendido: R$" + valorTotal);
        System.out.printf("Ticket médio: R$" + ticketMedio);
        System.out.printf("Maior compra: R$" + maiorCompra);
        System.out.printf("Menor compra: R$" + menorCompra);

        if (valorTotal > 500) {
            System.out.println("\nMeta atingida!");
        }

        entrada.close();
        }
    }