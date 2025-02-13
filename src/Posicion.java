/**
 * Se utilizará para clase movimiento, se determina con fila y columna
 */


public class Posicion {

    /**
     *
     */
    protected int fila;
    protected int columna;


    /**
     *
     * @param fila
     * @param columna
     */
    public Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }


    /**
     * posicion default
     */
    public Posicion() {
        fila = 0;
        columna = 0;
    }

    /**
     * constructor
     * @return
     */

    public int getFila() {
        return fila;
    }

    /**
     * set
     * @param fila
     */

    public void setFila(int fila) {
        this.fila = fila;
    }

    /**
     * constructor
     * @return
     */

    public int getColumna() {
        return columna;
    }

    /**
     * set
     * @param columna
     */

    public void setColumna(int columna) {
        this.columna = columna;
    }

    /**
     * devuelve string de fila y columna
      * @return
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fila"+ fila);
        sb.append("Columna"+ columna);
    }

}