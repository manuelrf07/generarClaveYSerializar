package generarclaveproductosetyserializar;

import java.util.ArrayList;
import java.util.Set;

public class Main {
    public static void main() {
        ArrayList<Solicitud> listaSolicitantes = new ArrayList<>();
        listaSolicitantes.add(new Solicitud("Juan", "Pérez García"));
        listaSolicitantes.add(new Solicitud("María", "López Martínez"));
        listaSolicitantes.add(new Solicitud("Carlos", "Rodríguez Fernández"));
        listaSolicitantes.add(new Solicitud("Ana", "Gómez Sánchez"));
        listaSolicitantes.add(new Solicitud("Pedro", "Martín Díaz"));
        listaSolicitantes.add(new Solicitud("Laura", "Ruiz Jiménez"));
        listaSolicitantes.add(new Solicitud("Miguel", "Hernández Castro"));
        listaSolicitantes.add(new Solicitud("Elena", "Moreno Ortiz"));
        listaSolicitantes.add(new Solicitud("Francisco", "Álvarez Romero"));
        listaSolicitantes.add(new Solicitud("Isabel", "Navarro Torres"));

        System.out.println("Solicitantes registrados: " + listaSolicitantes.size());
        System.out.println("Lista de solicitantes: ");
        for (int i = 0; i < listaSolicitantes.size(); i++ ) {
            System.out.println((i +1) + " " + listaSolicitantes.get(i));
        }
        System.out.println();

        System.out.println("Generando claves únicas:");
        Set<Clave> clavesGeneradas = GeneradorClaves.generarClaves(listaSolicitantes);

        System.out.println("Claves generadas: ");
        int contador = 1;
        for (Clave clave : clavesGeneradas ) {
            System.out.println("Clave " + contador);
            System.out.println("Código: " + clave.getCodigo());
            System.out.println("Solicitante: " + clave.getSolicitante());
            System.out.println("Nombre de usuario: " + clave.getSolicitante().generarNombreUsuario());
            contador++;
        }

        boolean todasUnicas = true;
        ArrayList<String> codigos = new ArrayList<>();
        for (Clave clave : clavesGeneradas ) {
            String codigoMinusculas = clave.getCodigo().toLowerCase();
            if (codigos.contains(codigoMinusculas)) {
                System.out.println("Clave duplicada encontrada: " + clave.getCodigo());
                todasUnicas = false;
            }
            codigos.add(codigoMinusculas);
        }
        if (todasUnicas) {
            System.out.println("Todas las claves son únicas.");
        }
        else {
            System.out.println("Se encontraron claves duplicadas.");
        }

    }
}
