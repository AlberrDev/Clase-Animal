package animal;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author alb3r
 */
//La clase es abstracta ya que tiene metodos abstractos
public abstract class Animal {

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

    public Animal(Animal otroAnimal) {
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

    //Tratamos la fecha internamente como local date pero externamente se trata como string
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

    //Redefinimos el equals, hashcode, toString
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 89 * hash + Objects.hashCode(this.codigo);
        hash = 89 * hash + this.sexo;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (this.sexo != other.sexo) {
            return false;
        }
        if (Double.doubleToLongBits(this.peso) != Double.doubleToLongBits(other.peso)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return Objects.equals(this.fechaNacimiento, other.fechaNacimiento);
    }

    @Override
    public String toString() {
        return "Animal{" + "codigo=" + codigo + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + ", peso=" + peso + '}';
    }

    //Definiendo Metodo abstracto
    public abstract String hacerSonido();

    public abstract String alegrarse();

    public abstract String enfadarse();

    public abstract String queSoy();

}
