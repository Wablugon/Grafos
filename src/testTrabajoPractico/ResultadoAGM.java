package testTrabajoPractico;
import java.util.ArrayList;
import java.util.List;


public class ResultadoAGM {
    private double costoTotal;
    private List<Arista> arbolGenerador;

    public ResultadoAGM(double costoTotal, List<Arista> arbolGenerador) {
        this.costoTotal = costoTotal;
        this.arbolGenerador = arbolGenerador;
    }

    public double getCostoTotal() { return costoTotal; }
    public List<Arista> getArbolGenerador() { return arbolGenerador; }
}