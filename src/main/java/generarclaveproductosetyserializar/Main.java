package generarclaveproductosetyserializar;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
     static  File fjArchivo = null;
    public static void main() throws IOException, ClassNotFoundException{
        int contador = 1;
        boolean todasUnicas = true;
        GeneradorClaves generadorClaves = new GeneradorClaves();
        ArrayList<Solicitud> listaSolicitantes;
        Set<Clave> listaNuevasClaves;
        Set<Clave> clavesGeneradas;
        fjArchivo = new File("claves.dat");

        if(!fjArchivo.exists()) {
            listaSolicitantes = crearSolicitudes();
            clavesGeneradas = generadorClaves.generarClaves(listaSolicitantes);
            if(grabaClaves(fjArchivo,clavesGeneradas)){
                listaNuevasClaves = leeClaves(fjArchivo);
                System.out.println(listaNuevasClaves);
            }else
                System.out.println("No se ha podido serializar el objeto");

        }else
            System.out.println("Primero tienes que borrar el archivo");
    }

    private static void mostrarClaves(Set<Clave> clavesGeneradas) {
        int contador = 1;

        System.out.println("Claves generadas: ");
        for (Clave clave : clavesGeneradas ) {
            System.out.println("Número clave " + contador);
            System.out.println("Clave: " + clave.getClave());
            contador++;
        }
    }

    private static void mostrarSolicitantes(ArrayList<Solicitud> listaSolicitantes) {
        System.out.println("Solicitantes registrados: " + listaSolicitantes.size());
        System.out.println("Lista de solicitantes: ");
        for (Solicitud solicitante: listaSolicitantes) {
            System.out.println("Solicitante: " + solicitante);
        }
        System.out.println();
    }

    private static ArrayList<Solicitud> crearSolicitudes() {
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

    return listaSolicitantes;
    }
    public static boolean grabaClaves(File archivo, Set<Clave> clavesGeneradas) throws FileNotFoundException, IOException{
        ObjectOutputStream oos = null;

        try{
            oos = new ObjectOutputStream(new FileOutputStream(archivo));
            oos.writeObject(clavesGeneradas);
        }catch(FileNotFoundException fnfe){
            throw new FileNotFoundException("No se encuentra archivo en método grabaListaUsuarios()");
        }
        catch (IOException ioe) {
            throw new IOException("Error al escribir el objeto en método grabaListaUsuarios()",ioe);
        }
        finally {
            if(oos != null){
                oos.close();
            }
        }
        return true;

    }
    public static Set<Clave> leeClaves(File archivo) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream ois = null;
        Set<Clave> listaClaves;
        try{
            ois = new ObjectInputStream(new FileInputStream(archivo));
            listaClaves = (Set<Clave>) ois.readObject();
        }catch (FileNotFoundException fnfe) {
            throw new FileNotFoundException("No se encuentra archivo en método leeListaUsuarios()");
        }
        catch (IOException ioe) {
            throw new IOException("Error al leer el objeto en método leeListaUsuarios()",ioe);
        } catch (ClassNotFoundException cnfe) {
            throw new ClassNotFoundException("Error al leer el objeto en método leeListaUsuarios()",cnfe);
        }
        return listaClaves;
    }

}
