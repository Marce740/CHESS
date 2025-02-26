import java.util.Scanner;

/**
 * se determinará las piezas en el tablero
 */

public class Tablero {

    /**
     * matriz (array bidimensional) de objetos de tipo Pieza
     */

    private Pieza[][] tablero;

    /**
     * Configurando tablero con array para peones
     */



    public Tablero() {
        tablero = new Pieza[8][8];

        tablero [0][0] = new Torre("B");    //color: black
        tablero [0][1] = new Caballo("B");
        tablero [0][2] = new Alfil("B");
        tablero [0][3] = new Reina("B");
        tablero [0][4] = new Rey("B");
        tablero [0][5] = new Alfil("B");
        tablero [0][6] = new Caballo("B");
        tablero [0][7] = new Torre("B");

        tablero [7][0] = new Torre("W");        //color: white
        tablero [7][1] = new Caballo("W");
        tablero [7][2] = new Alfil("W");
        tablero [7][3] = new Reina("W");
        tablero [7][4] = new Rey("W");
        tablero [7][5] = new Alfil("W");
        tablero [7][6] = new Caballo("W");
        tablero [7][7] = new Torre("W");

        /*
        Esto especificamente para los peones
         */

        for (int i = 0; i < 8; i++) {
            tablero [1][i] = new Peon("B");
        }

        for (int i = 0; i < 8; i++) {
            tablero [6][i] = new Peon("W");
        }


    }

    /**
     * Permite ubicar las figuras en el tablero
     */
    public void pintarTablero() {
        System.out.println("\t"+"a"+"\t" + "b"+"\t" + " c" +"\t" + "d" +"\t" + "e" +"\t" + "f" +"\t" + "g" +"\t" + "h");
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < 8; j++) {
                if (tablero[i][j] != null) {
                    System.out.print("\t" + tablero[i][j].getNombre());     //t es de tab
                }
                else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    /**
     * determina si hay una pieza de acuerdo a fila y columna
     * @param fila
     * @param columna
     * @return
     */

    public boolean hayPieza(int fila,int columna){
        return tablero[fila][columna]!=null;
    }

    /**
     * Determina si hay una pieza de acuerdo a la posicion
     * @param pos
     * @return
     */
    public boolean hayPieza(Posicion pos){
        return hayPieza(pos.getFila(),pos.getColumna());
    }

    /**
     * Se utiliza para mover o colocar nuevas piezas en el tablero despues de la inicializacion
     * @param figura la figura correspondiente a la fila y columna
     * @param fila
     * @param columna
     */

    public void ponPieza(Pieza figura, int fila, int columna){
        tablero[fila][columna]=figura;
    }

    /**
     * Reemplazará la pieza de acuerdo a la posicion basicamente
     * @param figura
     * @param pos
     */

    public void ponPieza(Pieza figura, Posicion pos){
        tablero[pos.getFila()][pos.getColumna()] = figura;

    }

    /**
     * Al quitar la pieza debe dejar el espacio del array como nulo
     * @param fila
     * @param columna
     */
    public void quitaPieza(int fila,int columna){
        tablero[fila][columna]=null;
    }
    public void quitaPieza(Posicion pos){
        quitaPieza(pos.getFila(),pos.getColumna());
    }

    /**
     * nos dice la pieza que tenemos en esa fila, columna y en el otro metodo de posicion
     * @param fila
     * @param columna
     * @return
     */

    public Pieza devuelvePieza(int fila,int columna){
        return tablero[fila][columna];
    }
    public Pieza devuelvePieza(Posicion pos){
        return devuelvePieza(pos.getFila(),pos.getColumna());

    }

    public boolean hayPiezasEntre(Movimiento mov) {
        Posicion inicio = mov.getPosInicial();
        Posicion fin = mov.getPosFinal();

        int filaActual = inicio.getFila();
        int columnaActual = inicio.getColumna();
        int filaDestino = fin.getFila();
        int columnaDestino = fin.getColumna();

        // Determinar la dirección del movimiento
        int dirFila = 0;
        int dirColumna = 0;

        if (filaDestino > filaActual) {
            dirFila = 1;  // Movimiento hacia abajo, ya que si es mayor significa que avanzo en el array hacia abajo del 0 al 7
        } else if (filaDestino < filaActual) {
            dirFila = -1; // Movimiento hacia arriba, ya que es menor, mas cercano al 0 para arriba
        }

        if (columnaDestino > columnaActual) {
            dirColumna = 1;  // Movimiento a la derecha
        } else if (columnaDestino < columnaActual) {
            dirColumna = -1; // Movimiento a la izquierda
        }

        // Avanzamos una casilla en la dirección hasta la posición final
        filaActual += dirFila;
        columnaActual += dirColumna;

        while (filaActual != filaDestino || columnaActual != columnaDestino) {
            if (hayPieza(filaActual, columnaActual)) {
                return true; // Se encontró una pieza en el camino
            }
            filaActual += dirFila;
            columnaActual += dirColumna;
        }

        return false; // No hay piezas bloqueando el movimiento
    }

    public boolean moverPieza(Movimiento mov) {
        Pieza pieza = devuelvePieza(mov.getPosInicial());

        // Verificando si hay una pieza en la posición inicial
        if (pieza == null) {
            System.out.println("No hay pieza en la posición inicial.");
            return false;
        }

        // Depuración: Ver qué está pasando
        System.out.println("Intentando mover " + pieza.getClass().getSimpleName() +
                " de " + mov.getPosInicial() + " a " + mov.getPosFinal());
        System.out.println("Es movimiento válido: " + pieza.validoMovimiento(mov, this));
        System.out.println("Hay piezas en el camino: " + hayPiezasEntre(mov));

        // Comprobar que el movimiento es válido para esta pieza, this representa a la pieza actual
        if (!pieza.validoMovimiento(mov, this)) {
            System.out.println("Movimiento no válido para esta pieza.");
            return false;
        }

        //  Si la pieza es diferente de caballo y hay piezas entre el movimiento, da falso
        if (!(pieza instanceof Caballo) && hayPiezasEntre(mov)) {
            System.out.println("Movimiento bloqueado por otra pieza.");
            return false;
        }
        //verificando si hay una pieza del mismo color
        Pieza piezaDestino = devuelvePieza(mov.getPosFinal());
        if (piezaDestino != null && piezaDestino.getColor().equals(pieza.getColor())) { //basicamente aqui identifica si el "color", que es string, es del mismo que el otro
            System.out.println("No puedes mover a una casilla ocupada por tu propio clan.");
            return false;
        }
        else{
            System.out.println("Pieza capturada");
            quitaPieza(mov.getPosFinal()); //elimina la pieza enemiga captura
        }

        // Verificar si un Peón ha llegado a la última fila y promoverlo
        if (pieza instanceof Peon) {
            int filaFinal = mov.getPosFinal().getFila();

            // Blancos promueven en fila 0, Negros en fila 7
            if ((pieza.getColor().equals("W") && filaFinal == 0) ||
                    (pieza.getColor().equals("B") && filaFinal == 7)) {

                System.out.println("Peón llego al final");

                Scanner sc = new Scanner(System.in);
                Pieza nuevaPieza = null;

                while (nuevaPieza == null) {
                    System.out.println("Elige una pieza para promocionar, de acuerdo a su inicial: [R]eina, [T]orre, [A]lfil, [C]aballo");
                    String eleccion = sc.nextLine().toUpperCase(); // Convertir a mayúscula

                    switch (eleccion) {
                        case "R":
                            nuevaPieza = new Reina(pieza.getColor());
                            break;
                        case "T":
                            nuevaPieza = new Torre(pieza.getColor());
                            break;
                        case "A":
                            nuevaPieza = new Alfil(pieza.getColor());
                            break;
                        case "C":
                            nuevaPieza = new Caballo(pieza.getColor());
                            break;
                        default:
                            System.out.println("Selección no válida. Intenta de nuevo.");
                    }
                }

                // Reemplazar el Peón con la pieza elegida
                ponPieza(nuevaPieza, mov.getPosFinal());

                System.out.println("Peón promovido a " + nuevaPieza.getClass().getSimpleName());
                return true;
            }
        }

        // Mover la pieza al nuevo lugar y eliminarla de la posición anterior
        ponPieza(pieza, mov.getPosFinal());
        quitaPieza(mov.getPosInicial());

        System.out.println("Pieza movida de " + mov.getPosInicial() + " a " + mov.getPosFinal());
        return true;

    }

}