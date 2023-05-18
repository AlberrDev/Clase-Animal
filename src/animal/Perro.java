package animal;

import java.util.Objects;

/**
 *
 * @author alb3r
 */
public class Perro extends Animal {

    //El perro tiene el constructor ya que el perro hereda todo lo que tiene el animal
    private String raza;

    /**
     *
     * @param codigo
     * @param fechaNacimiento
     * @param sexo
     * @param peso
     * @param raza
     * @throws IllegalArgumentException
     */
    public Perro(String codigo, String fechaNacimiento, char sexo, double peso, String raza) throws IllegalArgumentException {

        //Llama al constructor de Animal con "super"
        super(codigo, fechaNacimiento, sexo, peso);

        if (!codigo.matches("p.*") || ("".equals(raza))) {
            throw new IllegalArgumentException();
        }
        this.raza = raza;
    }

    /**
     *
     * @param otroPerro
     * @throws IllegalArgumentException
     */
    public Perro(Perro otroPerro) throws IllegalArgumentException {
        super(otroPerro); //Aqui el perro es tratado como animal
        this.raza = otroPerro.raza;
    }

    @Override
    public void setCodigo(String codigo) throws IllegalArgumentException {
        if (!codigo.matches("p.*")) {
            throw new IllegalArgumentException();
        }
        super.setCodigo(codigo); //En caso de excepcion se propagara
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String hacerSonido() {
        return "Guau";
    }

    @Override
    public String alegrarse() {
        return "Cuando estoy alegre Salto de alegria y muevo la cola";
    }

    @Override
    public String enfadarse() {
        return "Cuando me enfado Grunio y ensenio los dientes";
    }

    @Override
    public String queSoy() {
        return "Soy un perro";
    }

    public String pasear() {
        return "Me encanta que me saquen a pasear";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.raza) + super.hashCode(); //Agregamos tambien el super para que tambien tenga en cuenta los valores del padre
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
        if (!super.equals(obj)) { //Se genera esto para comparar todos los datos heredados del Super utilizando el equals del Super
            return false;
        }
        final Perro other = (Perro) obj;
        return Objects.equals(this.raza, other.raza);
    }

    @Override
    public String toString() {
        return "Perro{" + super.toString() + "raza=" + raza + '}'; //Heredamos del super el metodo toString para que imprima todas sus caracteristicas
    }

}
