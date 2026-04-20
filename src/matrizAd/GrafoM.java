package matrizAd;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GrafoM {
	
	private boolean[][] matriz;
	
	public GrafoM(int vertices) {
		this.matriz = new boolean[vertices][vertices];
		
		for(boolean[] fila : this.matriz) {
			Arrays.fill(fila, false);
		}
	}
	
	public void agregarArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintosVertices(i, j);
        
		matriz[i][j] = true;
		matriz[j][i] = true;		
	}
	
	public void eliminarArista(int i, int j){
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintosVertices(i, j);

		matriz[i][j] = false;
		matriz[j][i] = false;
	}

	public boolean existeArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintosVertices(i, j);
		return matriz[i][j];
	}
	
	public Set<Integer> vecinos(int v) {
		verificarVertice(v);
		
		Set<Integer> vecinosVertice = new HashSet<Integer>();
		for(int j = 0; j < tamano(); j++) {
			if(v!=j) {
				if(this.existeArista(v, j)) {
					vecinosVertice.add(j);
				}
			}
		}
		return vecinosVertice;
	}
	
	public int grado(int v) {
		verificarVertice(v);
		return vecinos(v).size();
	}
	
	private void verificarVertice(int v) {
		if(v < 0 || v >= tamano()) {
			throw new IllegalArgumentException("El valor de los vertices debe de ser > 0 y < tamaño de matriz");
		}
	}
	
	private int tamano() {
		return matriz.length;
	}
	
	private void verificarDistintosVertices(int i, int j) {
		if(i==j) {
			throw new IllegalArgumentException("No se permiten loops");
		}
	}
	
	
}
