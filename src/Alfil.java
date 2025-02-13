/**
 * Hereda de Pieza
 */

public class Alfil extends Pieza{

    /**
     * utilizamos "color" para ubicar la pieza, B:black, else: white
     * @param color
     */

    public Alfil(String color){
        super(color);
        if (color.equals("B")) //B es de BLACK
            nombre = "\u265D";
        else
            nombre = "\u2657";
    }

    @Override
    public boolean validoMovimiento(Movimiento movimiento, Tablero tablero) {


        return false;
    }
}
