import java.util.Scanner;

/**
 * Clase para ejecutar
 */

public class Main {
    public static void main(String[] args) {

        Tablero tablero = new Tablero();

        Scanner lector = new Scanner(System.in);

        do {
            tablero.pintarTablero();
            System.out.println("Introduce jugada");
            lector.nextLine();

        }while(lector.hasNextLine());
    }
}