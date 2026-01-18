package generarclaveproductosetyserializar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GeneradorClaves {
    public static Set<Clave> generarClaves(ArrayList<Solicitud> solicitudes) {
        Set<Clave> clavesGeneradas = new HashSet<>();
        Set<String> clavesUnicas = new HashSet<>();
        Random random = new Random();

        while (clavesGeneradas.size() < 20) {
            Solicitud solicitante = solicitudes.get(random.nextInt(solicitudes.size()));

            String tresDigitos = String.format("%03d", random.nextInt(1000));

            String claveCompleta = tresDigitos + solicitante.generarNombreUsuario();

            if (!clavesUnicas.contains(claveCompleta.toLowerCase())) {
                clavesUnicas.add(claveCompleta.toLowerCase());
                clavesGeneradas.add(new Clave(claveCompleta, solicitante));
            }

        }
        return clavesGeneradas;
    }
}