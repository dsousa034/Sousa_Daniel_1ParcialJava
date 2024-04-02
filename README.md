# Sousa_Daniel_1ParcialJava

## **BATALLA NAVAL**

1. **Clase `Barco`**:
   - Esta clase representa un barco genérico en el juego.
   - Tiene atributos como el tipo de barco, número de identificación, nombre y un arreglo de booleanos `impactos` que indica si el barco ha sido impactado en una determinada posición.
   - El método `estaHundido()` comprueba si el barco está hundido (si todas las partes del barco han sido impactadas).
   - El método `impacto(int posicion)` marca una posición del barco como impactada.

2. **Clases `BattleShip`, `Canoe` y `Frigate`**:
   - Estas clases heredan de `Barco` y representan diferentes tipos de barcos con tamaños específicos.
   - Cada clase tiene un atributo adicional `tamano` que indica el tamaño del barco.

3. **Enumeración `TipoBarcos`**:
   - Esta enumeración enumera los diferentes tipos de barcos disponibles en el juego.

4. **Clase `TablasBarcos`**:
   - Esta clase gestiona las tablas hash para almacenar los barcos.
   - Tiene tres tablas hash: una para mapear el tipo de barco a los barcos, otra para mapear el número de barco a los barcos, y otra para mapear el nombre del barco a los barcos.
   - Tiene métodos para agregar barcos a estas tablas.

5. **Clase `Tablero`**:
   - Esta clase representa el tablero de juego.
   - Tiene constantes para el tamaño del tablero, los caracteres que representan el mar y los barcos.
   - El método `inicializarTablero(char[][] tablero)` inicializa el tablero con agua y coloca aleatoriamente tres barcos para el Jugador 1.
   - El método `mostrarTablero(char[][] tablero)` muestra el tablero en la consola.

```
Clase Barco:
    Atributos:
        - tipo: TipoBarcos
        - numero: entero
        - nombre: cadena de caracteres
        - impactos: arreglo de booleanos

    Constructor:
        Barco(tipo: TipoBarcos, numero: entero, nombre: cadena de caracteres)

    Métodos:
        estaHundido(): boolean
        impacto(posicion: entero)

Clase BattleShip hereda de Barco:
    Atributo:
        - tamano: entero (valor constante = 5)

    Constructor:
        BattleShip(tipo: TipoBarcos, numero: entero, nombre: cadena de caracteres)

Clase Canoe hereda de Barco:
    Atributo:
        - tamano: entero (valor constante = 1)

    Constructor:
        Canoe(tipo: TipoBarcos, numero: entero, nombre: cadena de caracteres)

Clase Frigate hereda de Barco:
    Atributo:
        - tamano: entero (valor constante = 3)

    Constructor:
        Frigate(tipo: TipoBarcos, numero: entero, nombre: cadena de caracteres)

Enumeración TipoBarcos:
    Valores: BATTLESHIP, FRIGATE, CANOE

Clase TablasBarcos:
    Atributos:
        - tablaTipoBarco: Hashtable<TipoBarcos, Hashtable<entero, Barco>>
        - tablaNumeroBarco: Hashtable<entero, Hashtable<entero, Barco>>
        - tablaNombreBarco: Hashtable<cadena de caracteres, Hashtable<entero, Barco>>

    Constructor:
        TablasBarcos()

    Métodos:
        hashTipoBarco(tipo: TipoBarcos): entero
        hashNumeroBarco(numero: entero): entero
        hashNombreBarco(nombre: cadena de caracteres): entero
        agregarBarco(barco: Barco)

Clase Tablero:
    Constantes:
        - filas: entero (valor constante = 4)
        - columnas: entero (valor constante = 4)
        - mar: caracter (valor constante = '-')
        - barco: caracter (valor constante = 'B')

    Métodos estáticos:
        inicializarTablero(tablero: arreglo bidimensional de caracteres)
        mostrarTablero(tablero: arreglo bidimensional de caracteres)
        main(args: arreglo de cadenas de caracteres)

Algoritmo principal:
    tablero: arreglo bidimensional de caracteres de tamaño [filas][columnas]
    inicializarTablero(tablero)
    mostrarTablero(tablero)

```


### **"GRAFO"**

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

```
Clase Arista:
    Atributos:
        - distancia: entero
        - destino: Nodo

    Constructor:
        Arista(distancia: entero, destino: Nodo)

    Métodos:
        getDistancia(): entero
        getDestino(): Nodo

Clase Grafo:
    Atributos:
        - nodos: lista de Nodo

    Constructor:
        Grafo()

    Métodos:
        getNodos(): lista de Nodo
        setNodos(nodos: lista de Nodo)
        addNodo(nodo: Nodo)
        addNodoGrafoNoCompleto(nodo: Nodo)
        barridoProfundidad(puerto: Puerto): boolean
        caminoMasCorto(inicio: Puerto, destino: Puerto): lista de Puerto
        borrarPuertoConMasAristas(): boolean

Clase Nodo:
    Atributos:
        - aristas: lista de Arista
        - id: entero (estático)
        - visitado: boolean

    Constructor:
        Nodo()

    Métodos:
        getVisitado(): boolean
        setVisitado(b: boolean)
        getAristas(): lista de Arista
        setAristas(aristas: lista de Arista)
        getId(): entero (estático)
        setId(id: entero) (estático)
        addArista(arista: Arista)
        toString(): cadena de caracteres

Clase Puerto hereda de Nodo:
    Atributos:
        - nombre: cadena de caracteres

    Constructor:
        Puerto(nombre: cadena de caracteres)

    Métodos:
        getNombre(): cadena de caracteres
        setNombre(nombre: cadena de caracteres)
        toString(): cadena de caracteres

Clase GrafoImpl:
    Método principal:
        main(args: arreglo de cadenas de caracteres)

Algoritmo principal:
    grafo: Grafo
    puerto1: Puerto
    puerto2: Puerto
    puerto3: Puerto
    puerto4: Puerto

    grafo = nueva instancia de Grafo
    puerto1 = nueva instancia de Puerto con nombre "Madero"
    puerto2 = nueva instancia de Puerto con nombre "Rodas"
    puerto3 = nueva instancia de Puerto con nombre "Paris"
    puerto4 = nueva instancia de Puerto con nombre "Valencia"

    grafo.addNodo(puerto1)
    grafo.addNodo(puerto2)
    grafo.addNodo(puerto3)
    grafo.addNodo(puerto4)

    aristas = nueva lista de Arista
    aristas.agregar(new Arista(250, puerto2))
    aristas.agregar(new Arista(20, puerto3))
    aristas.agregar(new Arista(2, puerto4))
    puerto1.setAristas(aristas)

    aristas2 = nueva lista de Arista
    aristas2.agregar(new Arista(250, puerto1))
    aristas2.agregar(new Arista(2000, puerto3))
    aristas2.agregar(new Arista(5, puerto4))
    puerto2.setAristas(aristas2)

    aristas3 = nueva lista de Arista
    aristas3.agregar(new Arista(20, puerto1))
    aristas3.agregar(new Arista(2000, puerto2))
    aristas3.agregar(new Arista(800, puerto4))
    puerto3.setAristas(aristas3)

    aristas4 = nueva lista de Arista
    aristas4.agregar(new Arista(2, puerto1))
    aristas4.agregar(new Arista(5, puerto2))
    aristas4.agregar(new Arista(800, puerto3))
    puerto4.setAristas(aristas4)

    grafo.barridoProfundidad((Puerto) grafo.getNodos().obtener(0))
    imprimir grafo.caminoMasCorto(puerto1, puerto2)

```
