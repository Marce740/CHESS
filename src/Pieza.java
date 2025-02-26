public abstract class Pieza {



    protected String color;
    protected String nombre;

    /**
     *
     * @param color
     */

    public String getColor() {
        return color;
    }

    public Pieza(String color) {
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract boolean validoMovimiento(Movimiento movimiento, Tablero tablero);

    /**
     *
     * @return
     */

    @Override
    public String toString() {
        return "Pieza{" + "color=" + color + ", nombre=" + nombre + '}';
    }
}
