/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba2p1_miguelmoran;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author flash
 */
public class Prueba2P1_MiguelMoran {

    static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean seguir = true;
        while (seguir) {
            System.out.println("Seleccion una de las siguientes opciones:");
            System.out.println("1. Agregar Nuevo Libro");
            System.out.println("2. Solicitar Nuevo Libro");
            System.out.println("3. Regresar Libro");
            System.out.println("4. Buscar Libro por Nombre");
            System.out.println("5. Listar Libros Disponibles");
            System.out.println("6. Listar Libros Prestados");
            System.out.println("7. Salir");
            int opcion = sc.nextInt();
            Libro[] biblioteca = new Libro[0];
            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese la cantidad de libros que desea agregar: ");
                    int numlibros = sc.nextInt();
                    biblioteca = AgregarLibros(biblioteca, numlibros);
                    System.out.println("La biblioteca ha quedado de la siguiente manera: ");
                    for (int i = 0; i < biblioteca.length; i++) {
                        String estado;
                        if (biblioteca[i].isEstado()) {
                            estado = "Libre";
                        } else {
                            estado = "Prestado";
                        }
                        System.out.println((i+1) + ") " + biblioteca[i].getNombre() + " Autor:" + biblioteca[i].getAutor() + " ID:" + biblioteca[i].getID() + " Estado:" + estado + " Dueño:" + biblioteca[i].getOwner());
                    }
                }
                case 2 -> {
                    Solicitar(biblioteca);
                }
                case 3 -> {
                    Regresar(biblioteca);
                }
                case 4 -> {
                    BuscarLibroNombre(biblioteca);
                }
                case 5 -> {
                    ListarLibrosDisponibles(biblioteca);
                }
                case 6 -> {
                    ListarLibrosPrestados(biblioteca);
                }
                case 7 -> {
                    seguir = false;
                }
                default -> {
                    System.out.println("Seleccione una opcion valida");
                }
            }
        }
    }

    public static Libro[] AgregarLibros(Libro[] bibliotecavieja, int cantidad) {
        Random rng = new Random();
        Libro[] bibliotecanueva = new Libro[bibliotecavieja.length + cantidad];
        for (int i = 0; i < bibliotecanueva.length; i++) {
            if (i < bibliotecavieja.length) {
                bibliotecanueva[i] = bibliotecavieja[i];
            } else {
                System.out.print("Ingrese el nombre del libro: ");
                sc.nextLine();
                String nombre = sc.nextLine();
                System.out.print("Ingrese el autor del libro: ");
                String autor = sc.nextLine();
                String owner = " ";
                boolean Estado = true;
                String ID = "";
                for (int j = 0; j < 14; j++) {
                    int num = rng.nextInt(10);
                    char digito = (char)num;
                    ID += digito;
                }
                bibliotecanueva[i] = new Libro(nombre, autor, ID, Estado, owner);
            }
            System.out.println("");
        }
        return bibliotecanueva;
    }

    public static void Solicitar(Libro[] biblioteca) {
        for (int i = 0; i < biblioteca.length; i++) {
            String estado;
            if (biblioteca[i].isEstado()) {
                estado = "Libre";
            } else {
                estado = "Prestado";
            }
            System.out.println((i+1) + ") " + biblioteca[i].getNombre() + " Autor:" + biblioteca[i].getAutor() + " ID:" + biblioteca[i].getID() + " Estado:" + estado + " Dueño:" + biblioteca[i].getOwner());
        }
        System.out.println("Seleccione la posicion del libro que desea solicitar: ");
        int posicion = sc.nextInt();
        if (biblioteca[posicion].isEstado()) {
            System.out.println("El libro seleccionado esta libre. Ingrese su nombre: ");
            sc.nextLine();
            String nombre = sc.nextLine();
            biblioteca[posicion].Prestar(nombre);
        } else {
            System.out.println("Lo sentimos el libro solicitado no esta disponible.");
        }
    }

    public static void Regresar(Libro[] biblioteca) {
        for (int i = 0; i < biblioteca.length; i++) {
            String estado;
            if (biblioteca[i].isEstado()) {
                estado = "Libre";
            } else {
                estado = "Prestado";
            }
            System.out.println((i+1) + ") " + biblioteca[i].getNombre() + " Autor:" + biblioteca[i].getAutor() + " ID:" + biblioteca[i].getID() + " Estado:" + estado + " Dueño:" + biblioteca[i].getOwner());
        }
        System.out.println("Seleccione la posicion del libro que desea regresar: ");
        int posicion = sc.nextInt();
        biblioteca[posicion].Regresar();
        System.out.println("Gracias por su cooperacion");
    }

    public static void BuscarLibroNombre(Libro[] biblioteca) {
        System.out.println("Ingrese el nombre del libro deseado: ");
        String libro = sc.nextLine();
        boolean esta = false;
        int posicion = 0;
        for (int i = 0; i < biblioteca.length; i++) {
            if (biblioteca[i].getNombre().contains(libro)) {
                esta = true;
                posicion = i;
            }
        }
        if (esta) {
            System.out.println("El libro que usted busco esta en la posicion " + posicion);
        } else {
            System.out.println("El libro que usted busco no esta disponible en esta biblioteca");
        }
    }

    public static void ListarLibrosDisponibles(Libro[] biblioteca) {
        for (int i = 0; i < biblioteca.length; i++) {
            if (biblioteca[i].isEstado()) {
                System.out.println(i + ") " + biblioteca[i].getNombre() + " Autor:" + biblioteca[i].getAutor() + " ID:" + biblioteca[i].getID());
            }
        }
    }

    public static void ListarLibrosPrestados(Libro[] biblioteca) {
        for (int i = 0; i < biblioteca.length; i++) {
            if (!biblioteca[i].isEstado()) {
                System.out.println(i + ") " + biblioteca[i].getNombre() + " Autor:" + biblioteca[i].getAutor() + " ID:" + biblioteca[i].getID() + " Dueño:" + biblioteca[i].getOwner());
            }
        }
    }
}
