/**
 * Hereda de Pieza
 */
public class Peon extends Pieza{

    /**
     * utilizamos "color" para ubicar la pieza, B:black, else: white
     * @param color
     */
    public Peon(String color){
        super(color);
        if(color.equals("B")) //BLACK
            nombre = "\u265F";
        else
            nombre ="\u2659";
    }

    @Override
    public boolean validoMovimiento(Movimiento movimiento, Tablero tablero) {
        return false;
    }
}
