/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animal;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author alb3r
 */
public class Animal {

    private LocalDate fechaNacimiento;
    protected String codigo;
    private char sexo;
    private double peso;
    private DateTimeFormatter GUION = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private DateTimeFormatter BARRAS = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    //Creamos los constructores
    public Animal(String codigo, String fechaNacimiento, char sexo, double peso) throws IllegalArgumentException {
        if (!esCodigoValido(codigo) || !esSexoValido(sexo) || (peso <= 0)) {
            throw new IllegalArgumentException();
        } else {
            this.fechaNacimiento = generarFecha(fechaNacimiento);
            this.codigo = codigo;
            this.sexo = sexo;
            this.peso = peso;
        }

    }

    public Animal(Animal otroAnimal) throws IllegalArgumentException {
        this.fechaNacimiento = otroAnimal.fechaNacimiento;
        this.codigo = otroAnimal.codigo;
        this.sexo = otroAnimal.sexo;
        this.peso = otroAnimal.peso;
    }

    private LocalDate generarFecha(String fechaNacimiento) { //Funcion creada para devolver un dato correcto y en LocalDate
        LocalDate esFechaCorrecta = null;
        int dia = 0;
        int mes = 0;
        int anyo = 0;
        String[] fechaSeparada = fechaNacimiento.split("[-/]");
        if (!fechaNacimiento.matches("[0-9]{2}[/][0-9]{2}[/][0-9]{4}")
                && !fechaNacimiento.matches("[0-9]{2}[-][0-9]{2}[-][0-9]{4}")) { //Compruebo que el formato de la fecha sea correcta
            throw new IllegalArgumentException();
        }
        try {
            dia = Integer.parseInt(fechaSeparada[0]);
            mes = Integer.parseInt(fechaSeparada[1]);
            anyo = Integer.parseInt(fechaSeparada[2]);
            return LocalDate.of(anyo, mes, dia); //Comprueba que la fecha es correcta ya que al crearlo si no es correcta salta excepcion

        } catch (DateTimeException ex) {
            throw new IllegalArgumentException();
        }

    }

    private boolean esCodigoValido(String codigo) {
        return (codigo.matches("[0-9a-z]{5}"));
    }

    private boolean esSexoValido(char sexo) {
        return (sexo == 'M' || sexo == 'H');

    }

    //Hacemos los getter
      public String getFechaNacimiento() {
        String fechaString = "";

        if (this.fechaNacimiento == null) {
            fechaString = null;
        } else {
            fechaString = getFechaNacimiento('-');
        }

        return fechaString;
    }

    public String getFechaNacimiento(char separador) {
        String fechaString = "";
        LocalDate fechaLocalDate;
        if (separador != '-' || separador != '/') {
            throw new IllegalArgumentException();
        } else if (separador == '-') {
            fechaString = fechaNacimiento.format(GUION);
        } else if (separador == '/') {
            fechaString = fechaNacimiento.format(BARRAS);
        }

        return fechaString;
    }

    public String getCodigo() {
        return codigo;
    }

    public char getSexo() {
        return sexo;
    }

    public double getPeso() {
        return peso;
    }

    //Hacemos los setter
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = generarFecha(fechaNacimiento);
    }

    public void setCodigo(String codigo) {
        if (!esCodigoValido(codigo)) {
            throw new IllegalArgumentException();
        } else {
            this.codigo = codigo;
        }

    }

    public void setSexo(char sexo) {
        if (!esSexoValido(sexo)) {
            throw new IllegalArgumentException();
        } else {
            this.sexo = sexo;

        }
    }

    public void setPeso(double peso) {
        if (peso < 0) {
            throw new IllegalArgumentException();
        } else {
            this.peso = peso;
        }

    }

}
