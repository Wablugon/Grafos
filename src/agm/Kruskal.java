package agm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {

    public static double calcularCostoMinimo(int cantidadVertices, List<Arista> todasLasAristas) {
        double costoTotal = 0;
        List<Arista> arbolGenerador = new ArrayList<>();
        
        // 1. Instanciamos nuestro detector de circuitos
        UnionFind uf = new UnionFind(cantidadVertices);

        // 2. Ordenamos TODAS las aristas de la más barata a la más cara
        // Gracias a que implementamos Comparable, esto funciona mágicamente en O(E log E)
        Collections.sort(todasLasAristas);

        // 3. Evaluamos arista por arista
        for (Arista arista : todasLasAristas) {
            // Intentamos unir las dos ciudades. 
            // Si uf.union devuelve true, estaban en países distintos (no hay circuito)
            if (uf.union(arista.getOrigen(), arista.getDestino())) {
                arbolGenerador.add(arista);
                costoTotal += arista.getPeso();
                
                // Optimización: Un árbol generador siempre tiene V - 1 aristas.
                // Si ya llegamos a ese número, podemos cortar el for antes de tiempo.
                if (arbolGenerador.size() == cantidadVertices - 1) {
                    break;
                }
            }
        }

        // Aquí podrías retornar la lista 'arbolGenerador' si necesitas dibujar las líneas en el mapa
        return costoTotal; 
    }
}