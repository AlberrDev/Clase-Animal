/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package granja;

import animal.Animal;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        int cantidadAnimales = 0;
        String codigo = "";
        String fechaNacimiento = "";
        char sexo = ' ';
        double peso = 0;
        Animal Animal = null;
        String[] fechaArray;
        boolean esCodigoCorrecto = false;
        cantidadAnimales = sc.nextInt();
        System.out.println("Procesando animales de la granja");
        System.out.println("----------------------------------");
        for (int i = 0; i < cantidadAnimales; i++) {

            sc.nextLine();
            codigo = sc.nextLine();
            fechaNacimiento = sc.nextLine();
            sexo = sc.next().charAt(0);
            peso = sc.nextDouble();
            try {
                Animal = new Animal(codigo, fechaNacimiento, sexo, peso);
                fechaArray = fechaNacimiento.split("[/-]");
                System.out.println("Procesado: " + codigo + " " + sexo + " de " + peso + " kilos, nacido el " + fechaArray[0] + " del "
                        + fechaArray[1] + " de " + fechaArray[2]);

            } catch (IllegalArgumentException e) {
                System.out.println("ERROR. Procesando siguiente animal");
            }

        }
        sc.nextLine();
        System.out.println("Cambiando datos del ultimo animal");
        System.out.println("----------------------------------");
        while (!esCodigoCorrecto) {

            codigo = sc.nextLine();
            try {
                Animal.setCodigo(codigo);
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
                Animal.setFechaNacimiento(fechaNacimiento);
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
                Animal.setSexo(sexo);
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
                Animal.setPeso(peso);
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
