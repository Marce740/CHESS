/**
 * Hereda de Pieza
 */

public class Rey extends Pieza{

    /**
     * Utilizamos "color" para ubicar la pieza, B:black, else: white
     * @param color
     */

    public Rey(String color){
        super(color);
        if (color.equals("B")) //B ES DE BLACK
            nombre="\u265A";
        else                    //AQUI LOS WHITE
            nombre="\u2654";
    }

    @Override
    public boolean validoMovimiento(Movimiento movimiento, Tablero tablero) {
        int movcol=movimiento.saltoHorizontal();
        int movfil=movimiento.saltoVertical();
        //solo es un espacio
        return (movcol == 1 && movfil == 1) || (movcol == 1) || (movfil == 1);

    }
}
