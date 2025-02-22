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
        for (int i = 0; i < 8; i++) {
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
     * determina si hay una pieza de acuerdo a la posicion
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
     * nos dice la pieza que tenemos en esa fila, columna  y en el otro metodo de posicion
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

    public boolean hayPiezasEntre(Movimiento mov){

    }
}