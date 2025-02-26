/**
 * Hereda de Pieza
 */

public class Caballo extends Pieza{

    /**
     * utilizamos "color" para ubicar la pieza, B:black, else: white
     * @param color
     */

    public Caballo(String color){
        super(color);
        if (color.equals("B")) //B ES DE BLACK
            nombre="\u265E";
        else                    //AQUI LOS WHITE
            nombre="\u2658";

    }

    public boolean validoMovimiento(Movimiento mov, Tablero tablero){
        int movcol = Math.abs(mov.saltoHorizontal()); // Diferencia en columnas
        int movfil = Math.abs(mov.saltoVertical());   // Diferencia en filas

        /*
        System.out.println("Caballo intenta moverse de " + mov.getPosInicial() + " a " + mov.getPosFinal());
        System.out.println("movcol: " + movcol + ", movfil: " + movfil);
         */

        // movimiento en "L" (2 casillas en una dirección y 1 en la otra)
        return ((movcol == 2 && movfil == 1) || (movcol == 1 && movfil == 2));

    }
}
