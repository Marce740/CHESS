public class Tablero {

    private Pieza[][] tablero;

    /**
     *
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
     *
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
     *
     * @param fila
     * @param columna
     * @return
     */

    public boolean hayPieza(int fila,int columna){
        return tablero[fila][columna]!=null;
    }

    /**
     *
     * @param pos
     * @return
     */
    public boolean hayPieza(Posicion pos){
        return hayPieza(pos.getFila(),pos.getColumna());
    }
    /*public boolean hayPiezasEntre(Movimiento mov){
    }*/
    public void ponPieza(Pieza figura, int fila, int columna){
        tablero[fila][columna]=figura;
    }

    public void ponPieza(Pieza figura, Posicion Pos){

    }
    public void quitaPieza(int fila,int columna){

    }
    public void quitaPieza(Posicion pos){


    }
    public Pieza devuelvePieza(int fila,int columna){
        return tablero[fila][columna];
    }
    public Pieza devuelvePieza(Posicion pos){
        return devuelvePieza(pos.getFila(),pos.getColumna());
    }

}