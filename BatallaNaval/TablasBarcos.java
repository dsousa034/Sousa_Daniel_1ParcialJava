package BatallaNaval;

import java.util.Hashtable;

public class TablasBarcos {
    private Hashtable<TipoBarcos, Hashtable<Integer, Barco>> tablaTipoBarco;
    private Hashtable<Integer, Hashtable<Integer, Barco>> tablaNumeroBarco;
    private Hashtable<String, Hashtable<Integer, Barco>> tablaNombreBarco;

    public TablasBarcos() {
        this.tablaTipoBarco = new Hashtable<TipoBarcos, Hashtable<Integer, Barco>>();
        this.tablaNumeroBarco = new Hashtable<Integer, Hashtable<Integer, Barco>>();
        this.tablaNombreBarco = new Hashtable<String, Hashtable<Integer, Barco>>();
    }

    public int hashTipoBarco(TipoBarcos tipo) {
        return tipo.hashCode() % tablaTipoBarco.size();
    }
    public int hashNumeroBarco(int numero) {
        return numero % tablaNumeroBarco.size();
    }
    public int hashNombreBarco(String nombre) {
        return nombre.hashCode() % tablaNombreBarco.size();
    }

    public void agregarBarco(Barco barco) {
        // Agrega un barco a las tres tablas hash
        int indice_tipo_barco = hashTipoBarco(barco.tipo);
        int indice_numero_barco = hashNumeroBarco(barco.numero);
        int indice_nombre_barco = hashNombreBarco(barco.nombre);

        // Agregar a la primera tabla hash (tipo de barco)
        if (!tablaTipoBarco.containsKey(barco.tipo)) {
            tablaTipoBarco.put(barco.tipo, new Hashtable<>());
        }
        tablaTipoBarco.get(barco.tipo).put(barco.numero, barco);

        // Agregar a la segunda tabla hash (número de barco)
        if (!tablaNumeroBarco.containsKey(indice_numero_barco)) {
            tablaNumeroBarco.put(indice_numero_barco, new Hashtable<>());
        }
        tablaNumeroBarco.get(indice_numero_barco).put(barco.numero, barco);

        // Agregar a la tercera tabla hash (nombre de barco)
        if (!tablaNombreBarco.containsKey(barco.nombre)) {
            tablaNombreBarco.put(barco.nombre, new Hashtable<>());
        }
        tablaNombreBarco.get(barco.nombre).put(barco.numero, barco);
    }
}
