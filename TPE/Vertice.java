import java.util.ArrayList;
import java.util.Iterator;

public class Vertice<T>{
    private int id;
    private ArrayList<Arco<T>> adyacencias;
    private char color;

    public Vertice(int id){
        this.id = id;
        this.adyacencias = new ArrayList<>();
        this.color = 'b';
    }

    public ArrayList<Arco<T>> getAdyacentes(){
        return new ArrayList<>(adyacencias);
    }

    public void addArco(Arco<T> arco){
        if(arco != null)
            adyacencias.add(arco);
    }

    public void setColor(char color){
        this.color = color;
    }

    public char getColor(){
        return color;
    }

    public int getId() {
        return id;
    }

    public Arco<T> getArco(int verticeId) {
        for (Arco<T> arco : adyacencias) {
            if (arco.getVerticeDestino() == verticeId) {
                return arco;
            }
        }
        return null;
    }

    public boolean existeAdyacente(int verticeId) {
        for (Arco<T> arco : adyacencias) {
            if (arco.getVerticeDestino() == verticeId) {
                return true;
            }
        }
        return false;
    }

    public void borrarAdyacente(int verticeId) {
        Iterator<Arco<T>> iterator = adyacencias.iterator();
        while (iterator.hasNext()) {
            Arco<T> arco = iterator.next();
            if (arco.getVerticeDestino() == verticeId) {
                iterator.remove();
                break;
            }
        }
    }

    public void agregarAdyacente(Vertice<T> v) {
        int verticeDestino = v.getId();
        Arco<T> arco = new Arco<>(this.id, verticeDestino, null);
        adyacencias.add(arco);
    }

    @Override
    public String toString(){
        return "Id del Vertice: " + id;
    }
}
