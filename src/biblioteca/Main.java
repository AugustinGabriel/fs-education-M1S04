package biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        List<Livro> acervo = new ArrayList<>();

        System.out.println("*************");
        System.out.println("* BEM VINDO *");
        System.out.println("*************\n");

        do {
            System.out.println("+----------------------+");
            System.out.println("| 1 - Consultar acervo |");
            System.out.println("| 2 - Cadastrar livro  |");
            System.out.println("| 3 - Editar livro     |");
            System.out.println("| 4 - Remover livro    |");
            System.out.println("+----------------------+");
            System.out.println("| 0 - Sair             |");
            System.out.println("+----------------------+");
            System.out.print  ("Selecione uma opção: "   );
            int opcao = nextInt(scn);

            switch (opcao) {
                case 1: // Consultar
                    exibirAcervo(acervo);
                    break;
                case 2: // Cadastrar
                    cadastrarLivro(scn, acervo);
                    break;
                case 3: // Editar
                    exibirAcervo(acervo);
                    System.out.print("Informe o número do livro para a sua edição: ");
                    int indice = nextInt(scn);
                    Livro livro = acervo.get(indice);
                    inserirDadosLivro(scn, livro);
                    System.out.println("Livro "+ livro.titulo + " editado!");
                    break;
                case 4: // Remover
                    break;
                case 0: // Sair
                    return;
            }

            System.out.println("Pressione [ENTER] para continuar");
            scn.nextLine();

            limparTela();
        } while (true);

    }

    private static void exibirAcervo(List<Livro> acervo) {
        for (int i = 0; i < acervo.size(); i++) {
            System.out.println(i + " - " + acervo.get(i).titulo);
        }
    }

    private static void cadastrarLivro(Scanner entrada, List<Livro> acervo) {
        Livro livro = new Livro();

        // TODO: Testar com "inserirDadosLivro(entrada, new Livro());"
        inserirDadosLivro(entrada, livro);

        livro.disponibilizar();

        acervo.add(livro);
        System.out.println("Livro "+ livro.titulo + " cadastrado!");
    }

    private static Livro inserirDadosLivro(Scanner entrada, Livro livro) {
        System.out.println("Informe todas as informações abaixo");

        // TODO: caso vazio não alterar

        System.out.println("Título: " + livro.titulo);
        System.out.print("Digite: ");
        livro.titulo = entrada.nextLine();

        System.out.println("Subtítulo: " + livro.subtitulo);
        System.out.print("Digite: ");
        livro.subtitulo = entrada.nextLine();

        System.out.println("Descrição: " + livro.descricao);
        System.out.print("Digite: ");
        livro.descricao = entrada.nextLine();

        System.out.println("Autor: " + livro.autor);
        System.out.print("Digite: ");
        livro.autor = entrada.nextLine();

        System.out.println("Gênero: " + livro.genero);
        System.out.print("Digite: ");
        livro.genero = entrada.nextLine();

        System.out.println("Edição: " + livro.edicao);
        System.out.print("Digite: ");
        livro.edicao = entrada.nextLine();

        System.out.println("Ano da publicação: " + livro.anoPublicacao);
        System.out.print("Digite: ");
        livro.anoPublicacao = nextInt(entrada);

        System.out.println("Número de páginas: " + livro.numeroPaginas);
        System.out.print("Digite: ");
        livro.numeroPaginas = nextInt(entrada);

        System.out.println("Editora: " + livro.editora);
        System.out.print("Digite: ");
        livro.editora = entrada.nextLine();

        System.out.println("ISBN: " + livro.isbn);
        System.out.print("Digite: ");
        livro.isbn = entrada.nextLine();

        return livro;
    }

    private static void limparTela() {
        for (int i = 0; i < 40; i++) {
            System.out.println("\n");
        }
    }

    private static int nextInt(Scanner scn) {
        int i = scn.nextInt();

        // Consumindo "ENTER" para futuros "nextLine()"
        scn.nextLine();

        return i;
    }

}
