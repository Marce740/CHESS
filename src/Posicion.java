public class Posicion {

    int fila;
    int columna;

    public Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public Posicion() {
        fila = 0;
        columna = 0;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    /*
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fila"+ fila);
        sb.append("Columna"+ fila);
    }
*/
}