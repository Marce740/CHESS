public class Movimiento {

    Posicion posInicial;
    Posicion posFinal;

    public Movimiento(Posicion posInicial, Posicion posFinal) {
        this.posInicial = posInicial;
        this.posFinal = posFinal;
    }

    public boolean esVertical(){
        if(posInicial.columna==posFinal.columna){
            return true;
        }
        return false;
    }

    public boolean esHorizontal(){
        if(posInicial.fila==posFinal.fila){
            return true;
        }
        return false;
    }

    public boolean esDiagonal(){ //absoluto
        if(Math.abs(saltoHorizontal())==Math.abs(saltoVertical())) {
            return true;
        }
            return false;
    }

    public int saltoHorizontal(){ //signos
        int salto;
        salto = posFinal.getColumna() - posInicial.getColumna();
        return salto;
    }

    public int saltoVertical(){
        int salto;
        salto = posFinal.getFila() - posInicial.getFila();
        return salto;
    }

}
