package generarclaveproductosetyserializar;

public class Solicitud {
    private String nombre;
    private String apellidos;

    public Solicitud (String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String generarNombreUsuario() {
        String nombreMinuscula = nombre.toLowerCase();
        String apellidosMinuscula = apellidos.toLowerCase();
        return nombreMinuscula + " " + apellidosMinuscula;
    }

    public String toString() {
        return nombre + " " + apellidos;
    }
}