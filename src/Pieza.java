public abstract class Pieza {

    private String color;
    protected String nombre;

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

    @Override
    public String toString() {
        return "Pieza{" + "color=" + color + ", nombre=" + nombre + '}';
    }
}
