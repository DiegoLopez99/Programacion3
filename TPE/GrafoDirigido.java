import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo{
    protected HashMap<Integer, Vertice<T>> vertices;
    private int cantidadArcos;

    public GrafoDirigido() {
        this.vertices = new HashMap<>();
        this.cantidadArcos = 0;
    }

    @Override
    public void agregarVertice(int verticeId) {
        if (!contieneVertice(verticeId)) {
            Vertice<T> v = new Vertice<>(verticeId);
            vertices.put(verticeId, v);
        }
    }
    /**
     * Complejidad: O(1)
     * Descripción: Agregar un vértice implica simplemente una entrada al mapa vertices,
     * lo cual tiene una complejidad constante.
     */

    @Override
    public void borrarVertice(int verticeId) {
        if (contieneVertice(verticeId)) {
            Vertice<T> v = vertices.get(verticeId);
            for (Arco adyacente : v.getAdyacentes()) {
                int adyacenteId = adyacente.getVerticeDestino();
                borrarArco(verticeId, adyacenteId);
            }
            vertices.remove(verticeId);
        }
    }
    /**
     * Complejidad: O(V + E)
     * Descripción: Para borrar un vértice, se deben eliminar los arcos que lo conectan con otros vértices.
     * Esto implica iterar sobre los adyacentes del vértice y eliminar los arcos correspondientes.
     * La complejidad depende del número de arcos adyacentes, que puede ser proporcional al número total de vértices (V)
     * y arcos (E) en el grafo.
     */

    @Override
    public void agregarArco(int verticeId1, int verticeId2, Object etiqueta) {
        if (contieneVertice(verticeId1) && contieneVertice(verticeId2)) {
            Vertice<T> v1 = vertices.get(verticeId1);
            Vertice<T> v2 = vertices.get(verticeId2);
            if (!v1.existeAdyacente(verticeId2)) {
                v1.agregarAdyacente(v2);
                cantidadArcos++;
            }
        }
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        if (existeArco(verticeId1, verticeId2)) {
            Vertice<T> v1 = vertices.get(verticeId1);
            v1.borrarAdyacente(verticeId2);
            cantidadArcos--;
        }
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return vertices.containsKey(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        if (contieneVertice(verticeId1)) {
            Vertice<T> v1 = vertices.get(verticeId1);
            return v1.existeAdyacente(verticeId2);
        }
        return false;
    }

    @Override
    public Arco obtenerArco(int verticeId1, int verticeId2) {
        if (existeArco(verticeId1, verticeId2)) {
            Vertice<T> v1 = vertices.get(verticeId1);
            return v1.getArco(verticeId2);
        }
        return null;
    }

    @Override
    public int cantidadVertices() {
        return vertices.size();
    }

    @Override
    public int cantidadArcos() {
        return this.cantidadArcos;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        return vertices.keySet().iterator();
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        if (contieneVertice(verticeId)) {
            Vertice<T> v = vertices.get(verticeId);
            ArrayList<Integer> idAdyacentes = new ArrayList<>();
            for(Arco<T> adyacente : v.getAdyacentes()){
                idAdyacentes.add(adyacente.getVerticeDestino());
            }
            return idAdyacentes.iterator();
        }
        return Collections.emptyIterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        ArrayList<Arco<T>> listaArcos = new ArrayList<>();
        for (Vertice<T> vertice : vertices.values()) {
            ArrayList<Arco<T>> adyacentes = vertice.getAdyacentes();
            listaArcos.addAll(adyacentes);
        }
        return listaArcos.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        if (contieneVertice(verticeId)) {
            Vertice<T> vertice = vertices.get(verticeId);
            return vertice.getAdyacentes().iterator();
        }
        return Collections.emptyIterator();
    }
}
