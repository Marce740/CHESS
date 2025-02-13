/**
 * Clase torre que hereda de Pieza
 */

public class Torre extends Pieza{

    /**
     * utilizamos "color" para ubicar la pieza, B:black, else: white
     * @param color
     */
    public Torre(String color){
        super(color);
        if (color.equals("B")) //B ES DE BLACK
            nombre="\u265C";
        else                    //AQUI LOS WHITE
            nombre="\u2656";

    }

    /**
     * verifica el movimiento para la torre y que corresponde como "valido"
     * @param mov
     * @param tablero
     * @return
     */

    public boolean validoMovimiento (Movimiento mov, Tablero tablero) {
        boolean respuesta = false;
        if (mov.esVertical() || mov.esHorizontal())
            respuesta = true;
        return respuesta;
    }

}
