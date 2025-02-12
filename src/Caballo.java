public class Caballo extends Pieza{

    public Caballo(String color){
        super(color);
        if (color.equals("B")) //B ES DE BLACK
            nombre="\u265E";
        else                    //AQUI LOS WHITE
            nombre="\u2658";

    }

    public boolean validoMovimiento(Movimiento mov, Tablero tablero){
        boolean respuesta = false;
        if(mov.esVertical() || mov.esHorizontal())
            respuesta = true;
        return respuesta;
    }

}
