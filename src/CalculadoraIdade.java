import java.util.Calendar;
import java.util.Scanner;

public class CalculadoraIdade {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Perguntando ao usuario
        int anoNascimento = obterAnoNascimento(entrada);

        // Fazer função
        int idade = calcularIdade(anoNascimento);
        System.out.println("Idade: " + idade);
    }

    private static int obterAnoNascimento(Scanner entrada) {
        System.out.print("Informe o ano do seu nascimento: ");
        return entrada.nextInt();
    }

    public static int anoSistema() {
        Calendar calendario = Calendar.getInstance();
        return calendario.get(Calendar.YEAR);
    }

    public static int calcularIdade(int anoNascimento) {
        return anoSistema() - anoNascimento;
    }
}
