/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package granja;


import animal.Animal;
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
        int cantidadAnimales = 0;
        String codigo = "";
        String fechaNacimiento = "";
        char sexo = ' ';
        double peso = 0;
        Animal Animal = null;
        String personaAntigua = "";
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
                if (personaAntigua != "") {
                    if (Animal.toString().equals(personaAntigua)) {
                        System.out.println(Animal.toString() + " y " + personaAntigua + " son el mismo");
                    } else {
                        System.out.println(Animal.toString() + " y " + personaAntigua + " son distintos");
                    }
                }

                personaAntigua = Animal.toString();

            } catch (IllegalArgumentException e) {
                System.out.println("ERROR. Procesando siguiente animal");
            }

        }
    }

}
