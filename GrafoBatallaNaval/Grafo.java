package GrafoBatallaNaval;

import java.util.*;

public class Grafo {
    private List<Nodo> nodos;

    public Grafo(){
        this.nodos = new ArrayList<Nodo>();
    }

    public List<Nodo> getNodos() {
        return nodos;
    }

    public void setNodos(List<Nodo> nodos) {
        this.nodos = nodos;
    }





    //Opcion grafo completo
    public void addNodo(Nodo nodo){
        if (!nodos.isEmpty()){
            nodos.add(nodo);
        } else {
            for (Nodo n : nodos){
                n.addArista(new Arista(1,  nodo));
                nodo.addArista(new Arista(1,  n));
            }
            nodos.add(nodo);
        }
    }

    //Opcion grafo no completo
    public void addNodoGrafoNoCompleto(Nodo nodo){
        nodos.add(nodo);
    }


    public boolean barridoProfundidad(Puerto puerto){

        if (!puerto.getVisitado()){
            puerto.setVisitado(true);
            for (Arista a : puerto.getAristas()){
                if (!a.getDestino().getVisitado()){
                    barridoProfundidad((Puerto) a.getDestino());
                }
            }
            System.out.println(puerto.getNombre() + " visitado.");
            return true;
        }
        return false;
    }

    public List<Puerto> caminoMasCorto(Puerto inicio, Puerto destino) {
        Map<Puerto, Integer> distancia = new HashMap<>();
        Map<Puerto, Puerto> predecesor = new HashMap<>();
        PriorityQueue<Puerto> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(distancia::get));

        //Inicializar las distancias y predecesores
        for (Nodo nodo : nodos) {
            distancia.put((Puerto) nodo, Integer.MAX_VALUE);
            predecesor.put((Puerto) nodo, null);
        }

        //La distancia del nodo de inicio es 0
        distancia.put(inicio, 0);
        colaPrioridad.add(inicio);

        //Algoritmo de Dijkstra
        while (!colaPrioridad.isEmpty()) {
            Puerto actual = colaPrioridad.poll();
            if (actual == destino) {
                break;
            }
            for (Arista arista : actual.getAristas()) {
                Puerto vecino = (Puerto) arista.getDestino();
                int nuevaDistancia = distancia.get(actual) + arista.getDistancia();
                if (nuevaDistancia < distancia.get(vecino)) {
                    distancia.put(vecino, nuevaDistancia);
                    predecesor.put(vecino, actual);
                    colaPrioridad.add(vecino);
                }
            }
        }
        List<Puerto> caminoOptimo = new ArrayList<>();
        Puerto nodo = destino;
        while (nodo != null) {
            caminoOptimo.add(nodo);
            nodo = predecesor.get(nodo);
        }
        Collections.reverse(caminoOptimo);
        return caminoOptimo;
    }

    //Opcion borrar puerto con mas aristas
    public boolean borrarPuertoConMasAristas(){
        int max = 0;
        Puerto puerto = null;
        //Buscamos el puerto con mas aristas
        for (Nodo n : nodos){
            //Si el puerto tiene mas aristas que el maximo actual, lo guardamos
            if (n.getAristas().size() > max){
                max = n.getAristas().size();
                puerto = (Puerto) n;
            }
        }
        //Si encontramos un puerto con aristas, lo borramos
        if (puerto != null){
            nodos.remove(puerto);
            for (Nodo n : nodos){
                //Buscamos las aristas que apuntan al puerto
                for (Arista a : n.getAristas()){
                    if (a.getDestino().equals(puerto)){
                        n.getAristas().remove(a);
                    }
                }
            }
            return true;
        }
        return false;
    }
}
