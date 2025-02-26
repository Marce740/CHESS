/**
 * Hereda de Pieza
 */
public class Peon extends Pieza{

    /**
     * utilizamos "color" para ubicar la pieza, B:black, else: white
     * @param color
     */
    public Peon(String color){
        super(color);
        if(color.equals("B")) //BLACK
            nombre = "\u265F";
        else
            nombre ="\u2659";
    }

    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero) {

        int movcol = mov.saltoHorizontal(); // Diferencia en columnas
        int movfil = mov.saltoVertical();   // Diferencia en filas

        int direccion; // Variable para determinar hacia dónde puede moverse el Peón

        // Definir si el Peón avanza hacia arriba (-1) o hacia abajo (+1)
        if (color.equals("B")) {
            direccion = 1; // Peón negro avanza hacia filas mayores
        } else {
            direccion = -1; // Peón blanco avanza hacia filas menores
        }

        /*
        // Depuración:
        System.out.println("Peón " + color + " intenta moverse de " + mov.getPosInicial() + " a " + mov.getPosFinal());
        System.out.println("movcol: " + movcol + ", movfil: " + movfil + ", direccion: " + direccion);
        System.out.println("Fila esperada: " + (mov.getPosInicial().getFila() + direccion));
        System.out.println("Hay pieza en destino: " + tablero.hayPieza(mov.getPosFinal()));
         */

        // Movimiento normal (una casilla hacia adelante, sin captura)
        if (movcol == 0 && movfil == direccion) {
            return !tablero.hayPieza(mov.getPosFinal()); // Solo si la casilla está vacía
        }

        // Primer movimiento (dos casillas hacia adelante)
        if (movcol == 0 && movfil == 2 * direccion) {

            int filaInicial;

            // Determinar la fila inicial del Peón según su color
            if (color.equals("B")) {
                filaInicial = 1; // Peón negro inicia en fila 1
            } else {
                filaInicial = 6; // Peón blanco inicia en fila 6
            }

            // si la fila de la posicion inicial es la misma que la de filainicial,
            if (mov.getPosInicial().getFila() == filaInicial) {
                int filaIntermedia = mov.getPosInicial().getFila() + direccion; //la fila intermedia se determina de la fila inicial de la posicion inicial + la direccion (1)
                // ¿está libre la casilla intermedia?
                Posicion posIntermedia = new Posicion(filaIntermedia, mov.getPosInicial().getColumna()); //sacamos la columna de la pos inicial



                // Verificamos que ambas casillas (intermedia y final) estén vacías
                if (!tablero.hayPieza(mov.getPosFinal()) && !tablero.hayPieza(posIntermedia)) {
                    return true;
                }
            }

        }

        //  Captura en diagonal (una casilla en diagonal)
        if ((movcol == 1  || movcol == -1) && movfil == direccion) { // Corrección: movfil == direccion
            Pieza piezaDestino = tablero.devuelvePieza(mov.getPosFinal());

            // Verificar que hay una pieza enemiga en la casilla final
            if (piezaDestino != null && !piezaDestino.getColor().equals(this.color)) {
                return true;
            }
        }

        return false;  //cualquier otro movimiento es inválido
    }

}
