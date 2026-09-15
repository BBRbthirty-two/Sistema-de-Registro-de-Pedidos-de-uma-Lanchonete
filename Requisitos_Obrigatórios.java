import java.util.Locale;
import java.util.Scanner;

public class Requisitos_Obrigatórios {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in).useLocale(Locale.US);

        String cliente , resposta;

        int quantidadePedidos = 0;

        double valorCompra;
        double valorTotal = 0;
        double maior = 0;
        double menor = 0;

        do {

            System.out.print("Nome do cliente: ");
            cliente = entrada.nextLine();

            do {
                System.out.print("Valor da compra: R$ ");
                valorCompra = entrada.nextDouble();

                if (valorCompra <= 0) {
                    System.out.println("O valor deve ser maior que zero.");
                }

            } while (valorCompra <= 0);

            quantidadePedidos++;
            valorTotal = valorTotal + valorCompra;

            if (quantidadePedidos == 1 || valorCompra > maior) {
                maior = valorCompra;
            }

            if (quantidadePedidos == 1 || valorCompra < menor) {
                menor = valorCompra;
            }

            entrada.nextLine();

            System.out.println("\nCadastrar novo pedido?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            System.out.print("Escolha: ");

            resposta = entrada.nextLine();

        } while (resposta.equals(1));

        double ticket = valorTotal / quantidadePedidos;

        System.out.println("Quantidade de pedidos: " + quantidadePedidos);
        System.out.printf("Valor total vendido: R$", valorTotal);
        System.out.printf("Ticket médio: R$", ticket);
        System.out.printf("Maior compra: R$", maior);
        System.out.printf("Menor compra: R$", menor);
        entrada.close();
    }
}
