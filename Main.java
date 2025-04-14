import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaPedidos pedidos = new ListaPedidos();
        int opcao;

        do {
            System.out.println("\n=== 🍽️ CARDÁPIO DIGITAL DO RESTAURANTE ===");
            System.out.println("1 - Adicionar pedido");
            System.out.println("2 - Adicionar vários pedidos");
            System.out.println("3 - Remover pedido");
            System.out.println("4 - Remover vários pedidos");
            System.out.println("5 - Remover todas as ocorrências de um pedido");
            System.out.println("6 - Buscar pedido");
            System.out.println("7 - Ordenar pedidos (A-Z)");
            System.out.println("8 - Ordenar pedidos (Z-A)");
            System.out.println("9 - Editar pedido");
            System.out.println("10 - Exibir todos os pedidos");
            System.out.println("11 - Limpar pedidos da mesa");
            System.out.println("12 - Ver total de pedidos");
            System.out.println("0 - Finalizar atendimento");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt(); sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do pedido: ");
                    pedidos.inserirElemento(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Digite os pedidos separados por vírgula: ");
                    String[] lista = sc.nextLine().split(",");
                    pedidos.inserirSequencia(lista);
                    break;
                case 3:
                    System.out.print("Digite o pedido para remover: ");
                    pedidos.removerElemento(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Pedidos a remover (vírgula): ");
                    String[] remov = sc.nextLine().split(",");
                    pedidos.removerSequencia(remov);
                    break;
                case 5:
                    System.out.print("Pedido a remover completamente: ");
                    pedidos.removerTodasOcorrencias(sc.nextLine());
                    break;
                case 6:
                    System.out.print("Digite o pedido para buscar: ");
                    System.out.println(pedidos.buscarElemento(sc.nextLine()) ? "Pedido encontrado!" : "Não encontrado.");
                    break;
                case 7:
                    pedidos.ordenarCrescente();
                    System.out.println("Pedidos ordenados A-Z.");
                    break;
                case 8:
                    pedidos.ordenarDecrescente();
                    System.out.println("Pedidos ordenados Z-A.");
                    break;
                case 9:
                    System.out.print("Pedido antigo: ");
                    String antigo = sc.nextLine();
                    System.out.print("Novo pedido: ");
                    String novo = sc.nextLine();
                    pedidos.editarElemento(antigo, novo);
                    break;
                case 10:
                    pedidos.exibir();
                    break;
                case 11:
                    pedidos.limpar();
                    System.out.println("Todos os pedidos da mesa foram apagados.");
                    break;
                case 12:
                    System.out.println("Total de pedidos: " + pedidos.quantidadeElementos());
                    break;
                case 0:
                    System.out.println("Encerrando atendimento... Obrigado!");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}
