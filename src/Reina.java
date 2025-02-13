/**
 * Hereda de Pieza
 */

public class Reina extends Pieza{


    /**
     * utilizamos "color" para ubicar la pieza, B:black, else: white
     * @param color
     */
    public Reina(String color){
        super(color);
        if (color.equals("B")) //B ES DE BLACK
            nombre="\u265B";
        else                    //AQUI LOS WHITE
            nombre="\u2655";
    }

    @Override
    public boolean validoMovimiento(Movimiento movimiento, Tablero tablero) {


        return false;
    }
}
