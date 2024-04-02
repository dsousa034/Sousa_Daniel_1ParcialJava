package BatallaNaval;

public class Frigate extends Barco{
    int tamano = 3;

    public Frigate(TipoBarcos tipo, int numero, String nombre) {
        super(TipoBarcos.FRIGATE, numero, nombre);
    }
}
