public class Movimiento {

    Posicion posInicial;
    Posicion posFinal;


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
     *
     * @return
     */
    public boolean esVertical(){
        if(posInicial.columna==posFinal.columna){
            return true;
        }
        return false;
    }

    /**
     *
     * @return
     */
    public boolean esHorizontal(){
        if(posInicial.fila==posFinal.fila){
            return true;
        }
        return false;
    }


    /**
     *
     * @return
     */
    public boolean esDiagonal(){ //absoluto
        if(Math.abs(saltoHorizontal())==Math.abs(saltoVertical())) {
            return true;
        }
            return false;
    }


    /**
     *
     * @return
     */
    public int saltoHorizontal(){ //signos
        int salto;
        salto = posFinal.getColumna() - posInicial.getColumna();
        return salto;
    }


    /**
     *
     * @return
     */
    public int saltoVertical(){
        int salto;
        salto = posFinal.getFila() - posInicial.getFila();
        return salto;
    }

}
