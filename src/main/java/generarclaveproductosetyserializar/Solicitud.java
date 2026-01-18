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
        String inicialNombre = nombre.substring(0,1).toLowerCase();
        String apellidosMinuscula = apellidos.toLowerCase();
        return inicialNombre + apellidosMinuscula;
    }

    public String toString() {
        return nombre + " " + apellidos;
    }
}