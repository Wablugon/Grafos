package testTrabajoPractico;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraAGM {
    
    public static ResultadoAGM resultadoAGM(GrafoTP grafo) {
    	double costoTotal = 0;
    	List<Arista> aristasFinales = new ArrayList<>();
    	
    	//pedir aristas y ordenarlas
    	//usar el Union-Find
    	//sumar al costo y agregar a aristasFinales
    	
    	//termina el algoritmo, empaquetar y retornar
    	return new ResultadoAGM(costoTotal, aristasFinales);
    }
    
    /*
     * ^ es el metodo KRUSKAL con UNION-FIND
     * EL METODO COMENTADO SERIA PRIM, ELEGIR UNO SOLO
     */
    
    /*
    public static ResultadoAGM resultadoAGM(GrafoTP grafo, int nodoInicial) {
    	double costoTotal = 0;
    	List<Arista> aristasFinales = new ArrayList<>();
    	
    	//inicializar el priorityqueue y el boolean[] de visitados
    	//ejecutar el ciclo while
    	//sumar al costo y agregar a aristasFinales
    	
    	//termina el algoritmo, empaquetar y retornar
    	return new ResultadoAGM(costoTotal, aristasFinales);
    }
    */
}
