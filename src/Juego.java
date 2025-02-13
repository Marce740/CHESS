/**
 * se van a determinar los turnos y las jugadas
 */

public class Juego {


        private int elTurno; //0->Negras 1->Blancas //Boolean o String o char

        public Movimiento getMov() {
                return mov;
        }

        public void setMov(Movimiento mov) {
                this.mov = mov;
        }

        private Movimiento mov;//el movimiento en la jugada actual

        public int getTurno(){
            return elTurno;
        }
        public void setTurno(){

        }


        /**
         * Si la jugada introducida por el usuario es correcta inicializa el atributo movimiento de la jugada actual y devuelve un String a null. En el caso contrario, devuelve el mensaje a mostrar al usuario en caso de haber introducido una jugada incorrecta.
         * @param jugada
         * @param tablero
         * @return
         */
        public String jugada(String jugada, Tablero tablero){

        }

}
