package bfs;
import matrizAd.GrafoM;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import listaV.GrafoL;

public class BFS {
	private List<Integer> L;
	private boolean[] marcados;

	public boolean esConexo(GrafoL g) {
		if (g == null)
			throw new IllegalArgumentException("El grafo no puede ser null.");
		
		return g.tamano() == 0 || alcanzables(g, 0).size() == g.tamano();
	}
	
	public Set<Integer> alcanzables(GrafoL g, int origen) {
		Set<Integer> ret = new HashSet<>();
		inicializarRecorrido(g, origen);
		
		while(!L.isEmpty()) {
			//DFS ->
			//int i = L.get(L.size()-1);
			int i = L.get(0);
			marcados[i] = true;
			ret.add(i);
			agregarVecinosPendientes(g, i);
			//aca radica la diferencia entre Breadth First Search y Depth First Search
			L.remove(0);
			//DFS ->
			//L.remove(L.size()-1);
		}
		return ret;
	}
	
	private void agregarVecinosPendientes(GrafoL g, int vertice) {
		for(int vecino : g.vecinos(vertice)) {
			if(!marcados[vecino] && !L.contains(vecino)) {
				L.add(vecino);
			}
		}
	}
	
	public void inicializarRecorrido(GrafoL g, int origen) {
		this.L = new LinkedList<Integer>();
		marcados = new boolean[g.tamano()];
		L.add(origen);
	}
	

}
