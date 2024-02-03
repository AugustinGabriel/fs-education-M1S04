package biblioteca;

public class Livro {

    public static Long ultimoId = 0L;

    private Long id;
    public String titulo;
    public String subtitulo;
    public String descricao;
    public String autor; // TODO Criar classe Autor
    public String genero;
    public String edicao;
    public String idioma = "pt-BR";
    public int volume = 0;
    public int anoPublicacao;
    public int numeroPaginas;
    private int pcConservacao = 100;
    public String editora;
    public String localicacao;
    public LivroStatus statusAtual = LivroStatus.BLOQUEADO_EMPRESTIMO;
    public int numeroExemplar = 1;
    public String isbn;

    public Livro() {
        id = proximoId();
    }

    private static Long proximoId() {
        /*
         "++"  antes do atributo/variável primeiro incrementa e depois retorna/atribui
         "++" depois do atributo/variável primeiro retorna/atribui e depois incrementa
         */
        return ++ultimoId;
    }

    public void danificar() {
        if (pcConservacao > 0) {
            pcConservacao -= 25;
        }
        if (pcConservacao <= 0) {
            statusAtual = LivroStatus.DESCARTAVEL;
        } else if (pcConservacao <= 20) {
            statusAtual = LivroStatus.REPARAR;
        }
    }

    public void restaurar() {
        if (statusAtual.equals(LivroStatus.DESCARTAVEL)) {
            System.out.println("Livro irreparável!");
        } else {
            pcConservacao = 90;
        }
    }

    public void emprestar() {
        if (podeEmprestar()) {
            statusAtual = LivroStatus.EMPRESTADO;
        } else {
            System.out.println("O Livro está " + statusAtual +  ". Não pode ser emprestado!");
        }
    }

    public void devolver() {
        if (statusAtual.equals(LivroStatus.EMPRESTADO)) {
            statusAtual = LivroStatus.DISPONIVEL;
            System.out.println("O Livro devolvido");
        } else {
            System.out.println("O Livro está " + statusAtual +  ". Não pode ser devolvido!");
        }
        pcConservacao -= 2;
    }

    private boolean podeEmprestar() {
        return statusAtual.equals(LivroStatus.DISPONIVEL) ||
               statusAtual.equals(LivroStatus.RESERVADO);
    }

    public void enderecar(String endereco) {
        localicacao = endereco;
    }

    public void disponibilizar() {
        statusAtual = LivroStatus.DISPONIVEL;
    }

    public Long getId() {
        return id;
    }

    public int getPcConservacao() {
        return pcConservacao;
    }

    public void setPcConservacao(int pcConservacao) {
        this.pcConservacao = pcConservacao;
        if (pcConservacao <= 0) {
            statusAtual = LivroStatus.DESCARTAVEL;
        } else if (pcConservacao <= 20) {
            this.statusAtual = LivroStatus.REPARAR;
        }
    }

}
