package GrafoBatallaNaval;

public class Arista {
    private int distancia;
    private Nodo destino;

    public Arista(int distancia, Nodo destino){
        this.distancia = distancia;
        this.destino = destino;
    }

    public int getDistancia() {
        return distancia;
    }

    public Nodo getDestino() {
        return destino;
    }
}
