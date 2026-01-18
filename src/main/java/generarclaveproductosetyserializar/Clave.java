package generarclaveproductosetyserializar;

public class Clave {
    private String codigo;
    private Solicitud solicitante;

    public Clave (String codigo, Solicitud solicitante) {
        this.codigo = codigo;
        this.solicitante = solicitante;
    }

    public String getCodigo() {
        return codigo;
    }

    public Solicitud getSolicitante() {
        return solicitante;
    }

    public String toString() {
        return "Clave: " + codigo + " Solicitante: " + solicitante;
    }
}