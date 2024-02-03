package util;

import biblioteca.LivroStatus;

public class StringUtil {

    public static String testaCampo(String campo, String conteudo) {
        return conteudo == null || conteudo.isEmpty() ? "" : "\n"+campo+": " + conteudo;
    }

    public static String testaCampo(String campo, Long conteudo) {
        return conteudo == null ? "" : "\n"+campo+": " + conteudo;
    }

    public static String testaCampo(String campo, int conteudo) {
        return conteudo == 0 ? "" : "\n"+campo+": " + conteudo;
    }

    public static String testaCampo(String campo, LivroStatus conteudo) {
        return conteudo == null ? "" : "\n"+campo+": " + conteudo;
    }

}
