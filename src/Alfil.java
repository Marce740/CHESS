/**
 * Hereda de Pieza
 */

public class Alfil extends Pieza{

    /**
     *
     * @param color: define la imagen de pieza, B:black, else: white
     */

    public Alfil(String color){
        super(color);
        if (color.equals("B")) //B es de BLACK
            nombre = "\u265D";
        else
            nombre = "\u2657";
    }

    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero) {
        return mov.esDiagonal();

    }
}
