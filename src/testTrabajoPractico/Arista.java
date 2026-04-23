package testTrabajoPractico;

public class Arista implements Comparable<Arista>{
	/*
	 * Los nodos son representados por numeros del tipo int, por ende el origen y destino son los nodos conectados por esta arista
	 */
	private int origen;
	private int destino;
	private int peso; //peso / valor / precio de la arista
	
	/*
	 * A la hora de crear la arista, ya se debe de haber calculado su valor de instalacion
	 */
	public Arista(int origen, int destino, int peso) {
		this.origen = origen;
		this.destino = destino;
		this.peso = peso;
	}

	public int getOrigen() {
		return origen;
	}

	public void setOrigen(int origen) {
		this.origen = origen;
	}

	public int getDestino() {
		return destino;
	}

	public void setDestino(int destino) {
		this.destino = destino;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	@Override
	public int compareTo(Arista o) {
		return Double.compare(peso, o.getPeso());
	}
	
    @Override
    public String toString() {
        return "(" + origen + " <-> " + destino + " : $" + peso + ")";
    }
	
}
