package agm;

public class Arista implements Comparable<Arista> {
    private int origen;
    private int destino;
    private double peso;

    public Arista(int origen, int destino, double peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    public int getOrigen() { return origen; }
    public int getDestino() { return destino; }
    public double getPeso() { return peso; }

    // Le enseña a Java a ordenar los cables del más barato al más caro
    @Override
    public int compareTo(Arista otra) {
        return Double.compare(this.peso, otra.peso);
    }
    
    @Override
    public String toString() {
        return "(" + origen + " <-> " + destino + " : $" + peso + ")";
    }
}