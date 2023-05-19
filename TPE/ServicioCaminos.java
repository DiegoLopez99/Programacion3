import java.util.*;

public class ServicioCaminos<T> {
    private Grafo<T> grafo;
    private int origen;
    private int destino;
    private int lim;

    // Servicio caminos
    public ServicioCaminos(Grafo<T> grafo, int origen, int destino, int lim) {
        this.grafo = grafo;
        this.origen = origen;
        this.destino = destino;
        this.lim = lim;
    }

    public List<List<Integer>> caminos() {
        List<List<Integer>> todosCaminos = new ArrayList<>();
        List<Integer> caminoActual = new ArrayList<>();
        Set<Arco<T>> arcosVisitados = new HashSet<>();

        obtenerCaminos(origen, caminoActual, todosCaminos, arcosVisitados, 0);

        return todosCaminos;
    }

    private void obtenerCaminos(int verticeActual, List<Integer> caminoActual, List<List<Integer>> todosCaminos, Set<Arco<T>> arcosVisitados, int numArcosRecorridos) {
        if (verticeActual == destino) {
            todosCaminos.add(new ArrayList<>(caminoActual));
            return;
        }

        if (numArcosRecorridos >= lim) {
            return;
        }

        for(Iterator<Arco<T>> iterator = grafo.obtenerArcos(verticeActual); iterator.hasNext();) {
            Arco<T> arco = iterator.next();
            if (!arcosVisitados.contains(arco)) {
                arcosVisitados.add(arco);
                caminoActual.add(verticeActual);
                obtenerCaminos(arco.getVerticeDestino(), caminoActual, todosCaminos, arcosVisitados, numArcosRecorridos + 1);
                caminoActual.remove(caminoActual.size() - 1);
                arcosVisitados.remove(arco);
            }
        }
    }
}
