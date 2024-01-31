import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaCompra {

    private static List<String> inicializacaoLista() {
        List<String> listaCompras = new ArrayList<>();

        listaCompras.add("Feijão");
        listaCompras.add("Arroz");
        listaCompras.add("Batata");
        listaCompras.add("Macarrão");
        listaCompras.add("Requeijão");
        listaCompras.add("Leite");
        listaCompras.add("Limão");
        listaCompras.add("Laranja");
        listaCompras.add("Goiaba");
        listaCompras.add("Manjericão");

        return listaCompras;
    }

    private static void verLista(List<String> listaCompras) {
        for (int i = 0; i < listaCompras.size(); i++) {
            String item = listaCompras.get(i);
            System.out.println(i + " - " + item);
        }
    }

    private static void adicionarItemLista(Scanner entrada, List<String> listaCompras) {
        System.out.print("Informe o item: ");
        String item = entrada.next();
        listaCompras.add(item);
    }

    private static void excluirItemLista(Scanner entrada, List<String> listaCompras) {
        System.out.print("Informe o indice: ");
        int indice = entrada.nextInt();

        if (listaCompras.size() <= indice) {
            System.out.println("Item NÃO existe!");
        } else {
            listaCompras.remove(indice);
        }
    }

    private static void menu(Scanner entrada, List<String> listaCompras) {
        System.out.println("+---------------+");
        System.out.println("|      MENU     |");
        System.out.println("+---------------+");
        System.out.println("| 1 - Listar    |");
        System.out.println("| 2 - Adicionar |");
        System.out.println("| 3 - Remover   |");
        System.out.println("+---------------+");
        System.out.println("| 0 - Sair      |");
        System.out.println("+---------------+");
        System.out.print  ("Digite o número da opção desejada: ");
        int opcao = entrada.nextInt();

        switch (opcao) {
            case 1:
                verLista(listaCompras);
                break;
            case 2:
                adicionarItemLista(entrada, listaCompras);
                verLista(listaCompras);
                break;
            case 3:
                excluirItemLista(entrada, listaCompras);
                verLista(listaCompras);
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Opção inválida!");
                break;
        }

        System.out.println("\n\n");

        menu(entrada, listaCompras);
        System.out.println(opcao);
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        List<String> listaCompras = inicializacaoLista();

        System.out.println("Bem vindo à lista de compras");

        menu(entrada, listaCompras);

    }

}
