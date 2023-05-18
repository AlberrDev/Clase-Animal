package granja;


import animal.Animal;
import animal.Gato;
import animal.Perro;
import java.util.ArrayList;
import java.util.Iterator;
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
        ArrayList<Animal> miGranja = new ArrayList();
        Iterator iterador;

        String codigoAnimal;
        String fechaNacimientoAnimal;
        char sexoAnimal;
        double pesoAnimal;
        String raza;
        String tipoAnimal;

        int numAnimales;
        Animal animal;
        Perro perro;
        Gato gato;

        System.out.println("Procesando animales de la granja");
        System.out.println("----------------------------------");
        numAnimales = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= numAnimales; i++) {

            tipoAnimal = sc.nextLine();
            codigoAnimal = sc.nextLine();
            fechaNacimientoAnimal = sc.nextLine();
            sexoAnimal = sc.nextLine().charAt(0);
            pesoAnimal = sc.nextDouble();
            sc.nextLine();

            if (tipoAnimal.equals("perro")) {
                raza = sc.nextLine();
                try {
                    perro = new Perro(codigoAnimal, fechaNacimientoAnimal, sexoAnimal, pesoAnimal, raza);
                    miGranja.add(perro);

                } catch (IllegalArgumentException ex) {
                    System.out.println("ERROR procesando perro. Datos incorrectos. Procesando siguiente animal");
                    System.out.println();
                }
            } else if (tipoAnimal.equals("gato")) {
                raza = sc.nextLine();
                try {

                    gato = new Gato(codigoAnimal, fechaNacimientoAnimal, sexoAnimal, pesoAnimal, raza);
                    miGranja.add(gato);
                } catch (IllegalArgumentException ex) {
                    System.out.println("ERROR procesando gato. Datos incorrectos. Procesando siguiente animal");
                    System.out.println();
                }
            }
        }

        iterador = miGranja.iterator();
        while (iterador.hasNext()) {
            animal = (Animal) iterador.next();
            System.out.println(animal.toString());
            System.out.println(animal.queSoy());
            System.out.println("Hago " + animal.hacerSonido());
            System.out.println(animal.alegrarse());
            System.out.println(animal.enfadarse());
            System.out.println();

        }

        miGranja.clear();
    }

}
