import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ServicioBFS<T> {
    private Grafo<T> grafo;

    public ServicioBFS(Grafo<T> grafo) {
        this.grafo = grafo;
    }

    public List<Integer> bfsForest() {
        LinkedList<Vertice<T>> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (Vertice<T> v : grafo.getVertices().values()) {
            v.setColor('b');
        }

        for (Vertice<T> v : grafo.getVertices().values()) {
            if (v.getColor() == 'b') {
                bfs(v, queue, result);
            }
        }

        return result;

    }

    protected void bfs(Vertice<T> v, LinkedList<Vertice<T>> queue, List<Integer> result) {
        v.setColor('n');
        queue.add(v);

        while (!queue.isEmpty()) {
            Vertice<T> vertice = queue.poll();
            result.add(vertice.getId());

            for (Arco<T> arco : vertice.getAdyacentes()) {
                Vertice<T> adyacente = grafo.getVertices().get(arco.getVerticeDestino());
                if (adyacente.getColor() == 'b') {
                    adyacente.setColor('n');
                    queue.add(adyacente);
                }
            }
        }
    }
}
