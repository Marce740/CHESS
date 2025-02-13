/**
 * Clase para determinar los movimientos de las piezas de acuerdo a la posicion
 */

public class Movimiento {

    Posicion posInicial;
    Posicion posFinal;

    /**
     * inicializando movimiento
     */

    public Movimiento(){
        posInicial = new Posicion(0,0);
        posFinal = new Posicion(0,0);
    }

    /**
     *
     * @param posInicial
     * @param posFinal
     */
    public Movimiento(Posicion posInicial, Posicion posFinal) {
        this.posInicial = posInicial;
        this.posFinal = posFinal;
    }


    /**
     * si el movimiento fue vertical, comparando las posiciones
     * @return
     */
    public boolean esVertical(){
        if(posInicial.columna==posFinal.columna){
            return true;
        }
        return false;
    }

    /**
     * determina si el movimiento fue horizontal, comparando las posiciones
     * @return
     */
    public boolean esHorizontal(){
        if(posInicial.fila==posFinal.fila){
            return true;
        }
        return false;
    }


    /**
     * si el movimiento fue en diagonal, comparando los saltos, tanto horizontal como vertical, con un absoluto
     * @return
     */
    public boolean esDiagonal(){ //absoluto
        if(Math.abs(saltoHorizontal())==Math.abs(saltoVertical())) {
            return true;
        }
            return false;
    }


    /**
     *  aqui nos devuelve el int del salto ejecutado en horizontal
     * @return
     */
    public int saltoHorizontal(){ //signos
        int salto;
        salto = posFinal.getColumna() - posInicial.getColumna();
        return salto;
    }


    /**
     * devuelve el int del salto ejecutado en vertical
     * @return
     */
    public int saltoVertical(){
        int salto;
        salto = posFinal.getFila() - posInicial.getFila();
        return salto;
    }

}
