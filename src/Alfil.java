public class Alfil extends Pieza{

    /**
     *
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
