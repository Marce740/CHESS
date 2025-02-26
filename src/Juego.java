import java.util.Scanner;

/**
 * se van a determinar los turnos y las jugadas
 */

public class Juego {

        private int elTurno; //0->Negras 1->Blancas
        private Movimiento mov;//el movimiento en la jugada actual
        Scanner lector = new Scanner(System.in);

        public Movimiento getMov() {
                return mov;
        }

        public void setMov(Movimiento mov) {
                this.mov = mov;
        }


        public int getTurno(){
            return elTurno;
        }

        //primer turno
        public void setTurno(){
                if (elTurno == 0) {
                        elTurno = 1; // Cambiar a Blancas
                } else {
                        elTurno = 0; // Cambiar a Negras
                }
        }

        public Juego() {
                elTurno = 1; //comienzan las blancas

        }

        /**
         * Si la jugada introducida por el usuario es correcta inicializa el atributo movimiento de la jugada actual y devuelve un String a null. En el caso contrario, devuelve el mensaje a mostrar al usuario en caso de haber introducido una jugada incorrecta.
         * @param jugada
         * @param tablero
         * @return
         */


        public String jugada(String jugada, Tablero tablero){
                // Verificar si el formato de la jugada es correcto
                if (jugada.length() != 5 || jugada.charAt(2) != ' ') {
                        return "Formato incorrecto. Usa el formato correcto. ej: a2 a4";
                }

                // Convertir la jugada a posiciones en el tablero
                Posicion inicio = coordenada(jugada.substring(0, 2));
                Posicion fin = coordenada(jugada.substring(3, 5));

                if (inicio == null || fin == null) {
                        return "Posición inválida.";
                }

                // Obtener la pieza en la posición inicial
                Pieza pieza = tablero.devuelvePieza(inicio);
                if (pieza == null) {
                        return "No hay ninguna pieza en la casilla inicial.";
                }

                // Verificar que el jugador mueve su color correspondiente
                if ((elTurno == 1 && pieza.getColor().equals("B")) || (elTurno == 0 && pieza.getColor().equals("W"))) {
                        return "No puedes mover las piezas del oponente.";
                }

                // Crear movimiento y verificar si es válido
                mov = new Movimiento(inicio, fin);
                if (!tablero.moverPieza(mov)) {
                        return "Movimiento inválido.";
                }

                // Si el movimiento es válido, cambiamos de turno y retornamos null (sin error)
                setTurno();
                return null;

        }

        private Posicion coordenada(String entrada) {
                if (entrada.length() != 2) return null; // Verifica que la entrada sea de 2 caracteres (ejemplo: "E2")

                char columna = entrada.charAt(0); // Primera letra (Ej: 'E')
                char fila = entrada.charAt(1); // Segundo número (Ej: '2')

                // Validamos que la columna esté entre 'A' y 'H' y la fila entre '1' y '8'
                if (columna < 'A' || columna > 'H' || fila < '1' || fila > '8') return null;

                // Convertimos la letra de la columna a un número (A=0, B=1, ..., H=7)
                int col = columna - 'A';

                // Convertimos el número de la fila a un índice de array (1 en ajedrez = 7 en el array)
                int fil = 8 - (fila - '0');

                // Devolvemos la nueva posición convertida
                return new Posicion(fil, col);
        }
        public void iniciarJuego() {
                Tablero tablero = new Tablero();
                tablero.pintarTablero();

                while (true) {
                        System.out.println("\nTurno de " + (elTurno == 1 ? "Blancas" : "Negras"));
                        System.out.print("Introduce tu jugada (ejemplo: 'E2 E4') o 'exit' para terminar: ");
                        String input = lector.nextLine().toUpperCase();

                        if (input.equals("EXIT")) {
                                System.out.println("Juego terminado.");
                                break;
                        }

                        String resultado = jugada(input, tablero);
                        if (resultado != null) {
                                System.out.println(resultado);
                                continue;
                        }

                        tablero.pintarTablero();
                }
        }
}
