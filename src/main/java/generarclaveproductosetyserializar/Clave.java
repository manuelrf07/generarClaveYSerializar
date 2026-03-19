package generarclaveproductosetyserializar;

import java.io.Serializable;

public class Clave implements Serializable {
    private String clave;

    public Clave(String clave) {
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }

    public String toString() {
        return "Clave: " + clave;
    }

    public boolean equals(Object clave) {
        boolean iguales = false;

        if (clave != null && getClass() == clave.getClass()) {

            if (this.clave.equals( ((Clave) clave).getClave()));
                iguales = true;
        }
        return iguales;
    }

    public int hashCode() {
        return clave.hashCode();
    }
}