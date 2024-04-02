# Sousa_Daniel_1ParcialJava

## **"GRAFO"**

1. **Clase `Arista`**:
   - Esta clase representa una arista en el grafo, que conecta dos nodos (puertos en este caso).
   - Tiene dos atributos privados: `distancia` (que representa la distancia entre los puertos) y `destino` (el nodo de destino al que lleva la arista).
   - El constructor `Arista(int distancia, Nodo destino)` crea una nueva arista con la distancia y el nodo de destino especificados.
   - Tiene métodos para obtener la distancia (`getDistancia()`) y el nodo de destino (`getDestino()`).

2. **Clase `Nodo`**:
   - Esta clase representa un nodo en el grafo. Puede ser un puerto o cualquier otro tipo de nodo.
   - Tiene una lista de aristas salientes que conectan este nodo con otros nodos.
   - Tiene un atributo `visitado` para el algoritmo de búsqueda en profundidad.
   - Tiene un atributo estático `id` para asignar un identificador único a cada nodo.
   - El método `addArista(Arista arista)` añade una arista saliente al nodo.
   - Además de los métodos getter y setter para `visitado`, `id` y `aristas`, tiene un método `toString()` para representar el nodo como una cadena de texto.

3. **Clase `Puerto`**:
   - Esta clase hereda de `Nodo` y representa un puerto en el grafo.
   - Tiene un atributo adicional `nombre` para almacenar el nombre del puerto.
   - El constructor `Puerto(String nombre)` crea un nuevo puerto con el nombre especificado.
   - Tiene métodos getter y setter para el nombre, y un método `toString()` que muestra el nombre del puerto.

4. **Clase `Grafo`**:
   - Esta clase representa el grafo en sí.
   - Tiene una lista de nodos que forman parte del grafo.
   - Tiene métodos para agregar nodos al grafo, tanto para un grafo completo como para uno no completo (`addNodo(Nodo nodo)` y `addNodoGrafoNoCompleto(Nodo nodo)`).
   - Contiene métodos para realizar operaciones sobre el grafo, como búsqueda en profundidad (`barridoProfundidad(Puerto puerto)`), búsqueda del camino más corto entre dos puertos (`caminoMasCorto(Puerto inicio, Puerto destino)`) utilizando el algoritmo de Dijkstra, y eliminar el puerto con más aristas (`borrarPuertoConMasAristas()`).
   - Estos métodos manipulan la lista de nodos y las aristas de los puertos en el grafo.
   - `barridoProfundidad` es un método recursivo que realiza una búsqueda en profundidad desde un puerto específico, marcando los puertos visitados.
   - `caminoMasCorto` encuentra el camino más corto entre dos puertos usando el algoritmo de Dijkstra.
   - `borrarPuertoConMasAristas` elimina el puerto que tiene más aristas conectadas a él y actualiza las aristas correspondientes en otros nodos.

5. **Clase `GrafoImpl`**:
   - Esta clase es la clase principal que contiene el método `main` para ejecutar la aplicación.
   - En el método `main`, se crea una instancia del grafo y varios puertos.
   - Se añaden los puertos al grafo y se establecen las aristas entre ellos.
   - Luego se realiza una búsqueda en profundidad desde el primer puerto y se imprime el camino más corto entre dos puertos específicos.
