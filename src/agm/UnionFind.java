package agm;

public class UnionFind {
    private int[] padre;

    // Al principio, cada ciudad es su propio "jefe" o país independiente
    public UnionFind(int cantidadVertices) {
        padre = new int[cantidadVertices];
        for (int i = 0; i < cantidadVertices; i++) {
            padre[i] = i; 
        }
    }

    // Busca quién es el jefe supremo de un vértice (con compresión de caminos)
    public int find(int i) {
        if (padre[i] == i) {
            return i; // Si soy mi propio jefe, soy la raíz.
        }
        // Atajo: hace que este vértice apunte directo al jefe supremo para acelerar futuras búsquedas
        padre[i] = find(padre[i]); 
        return padre[i];
    }

    // Intenta unir dos ciudades. 
    // Devuelve TRUE si se unieron con éxito.
    // Devuelve FALSE si ya estaban unidas (¡ALERTA DE CIRCUITO!)
    public boolean union(int i, int j) {
        int raizI = find(i);
        int raizJ = find(j);

        if (raizI == raizJ) {
            return false; // Ya están en el mismo grupo. Si ponés el cable, hacés un ciclo.
        }

        // Si están en grupos distintos, los fusionamos.
        padre[raizI] = raizJ;
        return true; 
    }
}