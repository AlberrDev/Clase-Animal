package granja;

import animal.Animal;
import animal.Perro;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author alb3r
 */
public class granjaMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos = 0;
        String codigo = "";
        String raza = "";
        char sexo = ' ';
        double peso = 0;
        String fechaNacimiento = "";
        boolean esCodigoCorrecto = false;
        Perro Perro1 = null;
        String[] fechaArray;

        casos = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < casos; i++) {

            codigo = sc.nextLine();
            fechaNacimiento = sc.nextLine();
            sexo = sc.next().charAt(0);
            peso = sc.nextDouble();
            sc.nextLine();
            raza = sc.nextLine();
            try {
                Perro1 = new Perro(codigo, fechaNacimiento, sexo, peso, raza);
                System.out.println(Perro1.queSoy());
                System.out.println(Perro1.pasear());
                System.out.println(Perro1.hacerSonido());
                System.out.println(Perro1.alegrarse());
                System.out.println(Perro1.enfadarse());

            } catch (IllegalArgumentException e) {
                System.out.println("ERROR. Procesando siguiente perro");
            }

        }
        System.out.println("Cambiando datos del ultimo perro");
        System.out.println("----------------------------------");

        while (!esCodigoCorrecto) {

            codigo = sc.nextLine();
            try {
                Perro1.setCodigo(codigo);
                esCodigoCorrecto = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Dato erroneo. No se hace el cambio");
                esCodigoCorrecto = false;
            }
        }
        esCodigoCorrecto = false;
        while (!esCodigoCorrecto) {

            fechaNacimiento = sc.nextLine();
            try {
                Perro1.setFechaNacimiento(fechaNacimiento);
                esCodigoCorrecto = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Dato erroneo. No se hace el cambio");
                esCodigoCorrecto = false;
            }
        }
        esCodigoCorrecto = false;
        while (!esCodigoCorrecto) {

            sexo = sc.next().charAt(0);
            try {
                Perro1.setSexo(sexo);
                esCodigoCorrecto = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Dato erroneo. No se hace el cambio");
                esCodigoCorrecto = false;
            }
        }
        esCodigoCorrecto = false;
        while (!esCodigoCorrecto) {

            peso = sc.nextDouble();
            try {
                Perro1.setPeso(peso);
                esCodigoCorrecto = true;

            } catch (IllegalArgumentException e) {
                System.out.println("Dato erroneo. No se hace el cambio");
                esCodigoCorrecto = false;
            }
        }
        fechaArray = fechaNacimiento.split("[/-]");
        System.out.println("Procesado: " + codigo + " " + sexo + " de " + peso + " kilos, nacido el " + fechaArray[0] + " del "
                + fechaArray[1] + " de " + fechaArray[2]);

    }

}
