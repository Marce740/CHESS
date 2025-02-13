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
     *
     */
    public Posicion() {
        fila = 0;
        columna = 0;
    }

    /**
     *
     * @return
     */

    public int getFila() {
        return fila;
    }

    /**
     *
     * @param fila
     */

    public void setFila(int fila) {
        this.fila = fila;
    }

    /**
     *
     * @return
     */

    public int getColumna() {
        return columna;
    }

    /**
     *
     * @param columna
     */

    public void setColumna(int columna) {
        this.columna = columna;
    }

    /**
     *
      * @return
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fila"+ fila);
        sb.append("Columna"+ fila);
    }

}