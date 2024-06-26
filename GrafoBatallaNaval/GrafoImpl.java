package GrafoBatallaNaval;

import java.util.ArrayList;
import java.util.List;

public class GrafoImpl {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        Puerto puerto1 = new Puerto("Madero");
        Puerto puerto2 = new Puerto("Rodas");
        Puerto puerto3 = new Puerto("Napoles");
        Puerto puerto4 = new Puerto("Sicilia");
        grafo.addNodo(puerto1);
        grafo.addNodo(puerto2);
        grafo.addNodo(puerto3);
        grafo.addNodo(puerto4);

        List<Arista> aristas = new ArrayList<>();
        aristas.add(new Arista(200, puerto2));
        aristas.add(new Arista(30, puerto3));
        aristas.add(new Arista(8, puerto4));
        puerto1.setAristas(aristas);


        List<Arista> aristas2 = new ArrayList<>();
        aristas2.add(new Arista(200, puerto1));
        aristas2.add(new Arista(3700, puerto3));
        aristas2.add(new Arista(2, puerto4));
        puerto2.setAristas(aristas2);


        List<Arista> aristas3 = new ArrayList<>();
        aristas3.add(new Arista(30, puerto1));
        aristas3.add(new Arista(3700, puerto2));
        aristas3.add(new Arista(600, puerto4));
        puerto3.setAristas(aristas3);


        List<Arista> aristas4 = new ArrayList<>();
        aristas4.add(new Arista(8, puerto1));
        aristas4.add(new Arista(2, puerto2));
        aristas4.add(new Arista(600, puerto3));
        puerto4.setAristas(aristas4);

        grafo.barridoProfundidad((Puerto) grafo.getNodos().get(0));
        System.out.println(grafo.caminoMasCorto(puerto1, puerto2));
    }
}
