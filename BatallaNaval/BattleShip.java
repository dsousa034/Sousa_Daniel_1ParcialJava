package BatallaNaval;

public class BattleShip extends Barco{

    int tamano = 5;

    public BattleShip(TipoBarcos tipo, int numero, String nombre) {
        super(TipoBarcos.BATTLESHIP, numero, nombre);
    }
}
