public class Torre extends Pieza{

    public Torre(String color){
        super(color);
        if (color.equals("B")) //B ES DE BLACK
            nombre="\u265C";
        else                    //AQUI LOS WHITE
            nombre="\u2656";

    }

    public boolean validoMovimiento (Movimiento mov) {
        boolean respuesta = false;
        if (mov.esVertical() || mov.esHorizontal())
            respuesta = true;
        return respuesta;
    }

}
