package testTrabajoPractico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrafoTP {
	/*
	 * Se elige implementacion Lista de Vecinos
	 */
	private Map<Integer, List<Integer>> listaVecinos;
	
	public GrafoTP() {
		listaVecinos = new HashMap<>();
	}
	
	public void agregarArista(int origen, int destino) {
		verificarVertice(origen);
		verificarVertice(destino);
		
		verificarDistintosVertices(origen, destino);
		
        listaVecinos.get(origen).add(destino);
        listaVecinos.get(destino).add(origen); 
	}
	
	public void eliminarArista(int origen, int destino) {
		verificarVertice(origen);
		verificarVertice(destino);
		
		verificarDistintosVertices(origen, destino);
		existeArista(origen, destino);
		
		listaVecinos.get(origen).remove(destino);
		listaVecinos.get(destino).remove(origen);
	}
	public void agregarVertice(int vertice) throws Exception {
		existeVertice(vertice);
		verificarVertice(vertice);
		listaVecinos.putIfAbsent(vertice, new ArrayList<>());
	}
	
	private void verificarVertice(int v) {
		if(v < 0 || v >= tamano()) {
			throw new IllegalArgumentException("El valor de los vertices debe de ser > 0 y < tamaño de la lista");
		}
	}
	
	public int tamano() {
		return listaVecinos.size();
	}
	
	private void verificarDistintosVertices(int i, int j) {
		if(i==j) {
			throw new IllegalArgumentException("No se permiten loops");
		}
	}
	
	private void existeVertice(int v) throws Exception {
		if(!listaVecinos.containsKey(v)) {
			throw new Exception("El vertice no existe");
		}
	}
	
	public List<Integer> vecinos(int v) {
		verificarVertice(v);
		
		List<Integer> ret = new ArrayList<>();
		ret = listaVecinos.get(v);
		return ret;
	}
	
	public boolean existeArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintosVertices(i, j);
		
		return listaVecinos.get(i).contains(j);
	}
}
