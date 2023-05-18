
package animal;

import java.util.Objects;

/**
 *
 * @author alb3r
 */
public class Gato extends Animal {

    private String raza;

    public Gato(String codigo, String fechaNacimiento, char sexo, double peso, String raza) throws IllegalArgumentException {
        super(codigo, fechaNacimiento, sexo, peso);
        if (codigo.matches("g*") || ("".equals(raza))) {
            throw new IllegalArgumentException();
        }
        this.raza = raza;

    }

    public Gato(Gato otroGato) throws IllegalArgumentException {
        super(otroGato); //Aqui el perro es tratado como animal
        this.raza = otroGato.raza;
    }

    @Override
    public void setCodigo(String codigo) throws IllegalArgumentException {
        if (!codigo.matches("g*")) {
            throw new IllegalArgumentException();
        }
        super.setCodigo(codigo);
    }

    @Override
    public String hacerSonido() {
        return "Miau";
    }

    @Override
    public String alegrarse() {
        return "Cuando estoy alegre Ronroneo y me froto contra tus piernas";
    }

    @Override
    public String enfadarse() {
        return "Cuando me enfado Me bufo y saco las u??as";
    }

    @Override
    public String queSoy() {
        return "Soy un gato";
    }

    public String cazar() {
        return "Me encanta cazar bichejos";
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) throws IllegalArgumentException {
        this.raza = raza;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.raza);
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
        final Gato other = (Gato) obj;
        return Objects.equals(this.raza, other.raza);
    }

    @Override
    public String toString() {
        return "Gato{" + super.toString() + "raza=" + raza + '}';
    }

}
