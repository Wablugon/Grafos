package agm;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

public class Prim {

    public static double calcularCostoMinimo(int cantidadVertices, GrafoPonderado grafo) {
        double costoTotal = 0;
        boolean[] visitados = new boolean[cantidadVertices]; // Nuestro "imperio"
        List<Arista> arbolGenerador = new ArrayList<>();
        
        // La Cola de Prioridad actúa como nuestra "Frontera" ordenada automáticamente
        PriorityQueue<Arista> frontera = new PriorityQueue<>();

        // 1. Elegimos una ciudad capital para arrancar (ejemplo: la ciudad 0)
        int capital = 0;
        visitados[capital] = true;
        
        // 2. Agregamos todos los cables que salen de la capital a nuestra frontera
        for (Arista a : grafo.obtenerAristasDesde(capital)) {
            frontera.add(a);
        }

        // 3. Comenzamos la expansión del imperio
        // Cortamos cuando hayamos construido (cantidadVertices - 1) aristas
        while (!frontera.isEmpty() && arbolGenerador.size() < cantidadVertices - 1) {
            
            // La Cola de Prioridad nos da instantáneamente el cable más barato de la frontera
            Arista cableMasBarato = frontera.poll(); 
            
            int ciudadDestino = cableMasBarato.getDestino();

            // Si la ciudad destino ya es parte de nuestro imperio, ignoramos el cable
            if (visitados[ciudadDestino]) {
                continue;
            }

            // ¡Conquistamos la ciudad nueva!
            visitados[ciudadDestino] = true;
            arbolGenerador.add(cableMasBarato);
            costoTotal += cableMasBarato.getPeso();

            // Agregamos los nuevos cables que salen de esta ciudad recién conquistada a la frontera
            for (Arista cableNuevo : grafo.obtenerAristasDesde(ciudadDestino)) {
                // Solo agregamos cables que vayan hacia ciudades oscuras (no visitadas)
                if (!visitados[cableNuevo.getDestino()]) {
                    frontera.add(cableNuevo);
                }
            }
        }

        return costoTotal;
    }
}