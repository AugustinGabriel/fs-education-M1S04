package biblioteca;

public class Livro {

    public String titulo;
    public String subtitulo;
    public String descricao;
    public String autor; // TODO Criar classe Autor
    public String genero;
    public String edicao;
    public String idioma;
    public int volume = 0;
    public int anoPublicacao;
    public int numeroPaginas;
    public int pcConservacao = 100;
    public String editora;
    public String localicacao;
    public LivroStatus statusAtual = LivroStatus.BLOQUEADO;
    public int numeroExemplar;
    public String isbn;

    public void danificar() {
        if (pcConservacao > 0) {
            pcConservacao -= 25;
        }
        if (pcConservacao <= 0) {
            statusAtual = LivroStatus.ESTRAGADO;
        }
    }

    public void restaurar() {
        if (statusAtual.equals(LivroStatus.ESTRAGADO)) {
            System.out.println("Livro irreparável!");
        } else {
            pcConservacao = 90;
        }
    }

    public void emprestar() {
        if (podeEmpretar()) {
            statusAtual = LivroStatus.EMPRESTADO;
        } else {
            System.out.println("O Livro está " + statusAtual +  ". Não pode ser emprestado!");
        }
    }

    private boolean podeEmpretar() {
        return statusAtual.equals(LivroStatus.DISPONIVEL) ||
               statusAtual.equals(LivroStatus.RESERVADO);
    }

    public void enderecar(String endereco) {
        localicacao = endereco;
    }

}