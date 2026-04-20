package agm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GrafoPonderado {
    private int cantidadVertices;
    
    // Lista de adyacencia: Cada índice tiene una lista de sus cables conectados
    private List<List<Arista>> adyacencia;
    
    // Lista maestra para Kruskal
    private List<Arista> todasLasAristas;

    public GrafoPonderado(int vertices) {
        this.cantidadVertices = vertices;
        this.todasLasAristas = new ArrayList<>();
        this.adyacencia = new ArrayList<>(vertices);
        
        for (int i = 0; i < vertices; i++) {
            adyacencia.add(new LinkedList<>());
        }
    }

    // Agregar un cable bidireccional (fibra óptica)
    public void agregarArista(int u, int v, double peso) {
        verificarVertice(u);
        verificarVertice(v);

        Arista aristaIda = new Arista(u, v, peso);
        Arista aristaVuelta = new Arista(v, u, peso);

        adyacencia.get(u).add(aristaIda);
        adyacencia.get(v).add(aristaVuelta);
        
        // Guardamos solo una copia en la lista maestra para no evaluar el doble en Kruskal
        todasLasAristas.add(aristaIda); 
    }

    // Método para Prim: "Dame los cables que salen de esta ciudad"
    public List<Arista> obtenerAristasDesde(int vertice) {
        verificarVertice(vertice);
        return adyacencia.get(vertice);
    }

    // Método para Kruskal: "Dame todos los cables del mapa"
    public List<Arista> obtenerTodasLasAristas() {
        return todasLasAristas;
    }

    public int tamano() {
        return cantidadVertices;
    }

    private void verificarVertice(int i) {
        if (i < 0 || i >= cantidadVertices) {
            throw new IllegalArgumentException("Vértice inválido: " + i);
        }
    }
}