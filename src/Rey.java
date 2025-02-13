/**
 * Hereda de Pieza
 */

public class Rey extends Pieza{

    /**
     * utilizamos "color" para ubicar la pieza, B:black, else: white
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
        return false;
    }
}
