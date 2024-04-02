package BatallaNaval;

public class Canoe extends Barco{

    int tamano = 1;

    public Canoe(TipoBarcos tipo, int numero, String nombre) {
        super(TipoBarcos.CANOE, numero, nombre);
    }
}
