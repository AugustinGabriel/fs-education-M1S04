package biblioteca;

import util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scn = new Scanner(System.in);
        List<Livro> acervo = new ArrayList<>();

        System.out.println("*************");
        System.out.println("* BEM VINDO *");
        System.out.println("*************\n");

        do {
            System.out.println("+------------------------+");
            System.out.println("| 1 - Consultar acervo   |");
            System.out.println("| 2 - Detalhes do livro  |");
            System.out.println("| 3 - Cadastrar livro    |");
            System.out.println("| 4 - Editar livro       |");
            System.out.println("| 5 - Remover livro      |");
            System.out.println("+------------------------+");
            System.out.println("| 0 - Sair               |");
            System.out.println("+------------------------+");
            System.out.print  ("Selecione uma opção: "     );
            int opcao = nextInt(scn);

            // TODO Exibir todos os dados de um livro
            switch (opcao) {
                case 1: // Consultar
                    exibirAcervo(acervo);
                    break;
                case 2: // Detalhes do livro encontrado pelo id
                    buscarLivro(scn, acervo);
                    break;
                case 3: // Cadastrar
                    cadastrarLivro(scn, acervo);
                    break;
                case 4: // Editar
                    editarLivro(scn, acervo);
                    break;
                case 5: // Remover
                    removerLivro(scn, acervo);
                    break;
                case 0: // Sair
                    return;
            }

            // Aguarda 2 segundas
            Thread.sleep(2000);
//            System.out.println("Pressione [ENTER] para continuar");
//            scn.nextLine();

            limparTela();
        } while (true);

    }

    private static void buscarLivro(Scanner entrada, List<Livro> acervo) {
        Livro livro = pedirLivro(entrada, acervo);
        System.out.print(StringUtil.testaCampo("ID", livro.getId()));
        System.out.print(StringUtil.testaCampo("Título", livro.titulo));
        System.out.print(StringUtil.testaCampo("Subtítulo", livro.subtitulo));
        System.out.print(StringUtil.testaCampo("Descrição", livro.descricao));
        System.out.print(StringUtil.testaCampo("Autor", livro.autor));
        System.out.print(StringUtil.testaCampo("Gênero", livro.genero));
        System.out.print(StringUtil.testaCampo("Edição", livro.edicao));
        System.out.print(StringUtil.testaCampo("Idioma", livro.idioma));
        System.out.print(StringUtil.testaCampo("Volume", livro.volume));
    }

    private static Livro pedirLivro(Scanner entrada, List<Livro> acervo) {
        do {
            exibirAcervo(acervo);
            System.out.print("Digite o ID do livro escolhido: ");
            int idEscolhido = nextInt(entrada);
            for (Livro livro : acervo) {
                if (idEscolhido == livro.getId()) {
                    return livro;
                }
            }
            System.out.println("Livro não encontrado. Tente novamente!");
        } while (true);
    }

    private static void removerLivro(Scanner entrada, List<Livro> acervo) {
        Livro livro = pedirLivro(entrada, acervo);
        acervo.remove(livro);
        System.out.println("O livro \"" + livro.titulo + "\" foi removido com sucesso!");
    }

    private static void editarLivro(Scanner entrada, List<Livro> acervo) {
        Livro livro = pedirLivro(entrada, acervo);
        inserirDadosLivro(entrada, livro);
        System.out.println("Livro \""+ livro.titulo + "\" editado com sucesso absoluto!");
    }

    private static void exibirAcervo(List<Livro> acervo) {
        for (Livro livro : acervo) {
            System.out.println(livro.getId() + " - " + livro.titulo);
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

        System.out.println("Estado de conservação: " + livro.getPcConservacao());
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Novo (100%)");
            System.out.println("2 - Excelente (80%)");
            System.out.println("3 - Bom (60%)");
            System.out.println("4 - Ruim (40%)");
            System.out.println("5 - Péssimo (20%)");
            System.out.print("Digite: ");
            int opcConservacao = entrada.nextInt();

            if (opcConservacao < 0 || opcConservacao > 5) {
                System.out.println("Opção inválida. Tente novamente!");
                continue;
            }

            int percent = 100 - (20 * (opcConservacao - 1));
            livro.setPcConservacao(percent);
            break;
        } while (true);

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
