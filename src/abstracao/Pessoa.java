package abstracao;

import java.time.LocalDate;

public class Pessoa {

    // caracteristicas
    public String nome;
    public LocalDate dataNascimento;
    public float altura;
    public char sexo;
    public String etnia;
    public String corCabelo;
    public float peso;
    public String nacionalidade;
    public String corOlho;
    public String endereco;

    // comportamentos
    public void acordar() {
        System.out.println("Acordando! :|");
    }

    public void espreguicar() {
        System.out.println("Acordando MAAAAISSSS :)");
    }

    public void andar() {
        System.out.println("Andando");
        System.out.println(" o ");
        System.out.println("/|\\");
        System.out.println("/ \\");
    }

    public void trabalhar() {
        System.out.println("Trabalhando :(");
    }

    public void programar() {
        System.out.println("Programando :D");
    }

    public int calcularIdade() {
        //Implementar corretamente
        System.out.println("Calculando idade :'(");
        return 20;
    }

}
