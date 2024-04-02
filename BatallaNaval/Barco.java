package BatallaNaval;

public class Barco {
    protected TipoBarcos tipo;
    protected int numero;
    protected String nombre;
    protected boolean[] impactos;

    public Barco(TipoBarcos tipo, int numero, String nombre) {
        this.tipo = tipo;
        this.numero = numero;
        this.nombre = nombre;
    }

    public boolean estaHundido(){
        for (boolean impactado : impactos) {
            if (!impactado) {
                return false;
            }
        }
        return true;
    }

    public void impacto(int posicion){
        impactos[posicion] = true;
    }
}
