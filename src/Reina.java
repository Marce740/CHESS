public class Reina extends Pieza{

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
