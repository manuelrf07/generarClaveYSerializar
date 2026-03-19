package generarclaveproductosetyserializar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GeneradorClaves {
    public Set<Clave> generarClaves(ArrayList<Solicitud> solicitudes) {
        Set<Clave> clavesGeneradas = new HashSet<>();
        Random random = new Random();
        String tresDigitos;
        Clave claveCompleta;

        for (Solicitud solicitud : solicitudes) {
            do {
                tresDigitos = String.format("%03d", random.nextInt(1000));
                claveCompleta = new Clave(tresDigitos + solicitud.generarNombreUsuario().toLowerCase());
                } while (clavesGeneradas.contains(claveCompleta));
            clavesGeneradas.add(claveCompleta);
        }
        return clavesGeneradas;
    }

}