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

    public boolean esDiagonal(){
        if {
            return true;
        }
        return false;
    }

    public int saltoHorizontal(){       //

    }

    public int saltoVertical(){

    }

}
