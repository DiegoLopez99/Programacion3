import java.util.ArrayList;
import java.util.List;

public class ServicioDFS<T> {
    private Grafo<T> grafo;

    public ServicioDFS(Grafo<T> grafo) {
        this.grafo = grafo;
    }

    public List<Integer> dfsForest() {
        List<Integer> ordenDescubrimiento = new ArrayList<>();

        for (Vertice<T> v : grafo.getVertices().values()) {
            v.setColor('b');
        }

        for (Vertice<T> v : grafo.getVertices().values()) {
            if (v.getColor() == 'b') {
                dfs(v, ordenDescubrimiento);
            }
        }

        return ordenDescubrimiento;
    }

    protected void dfs(Vertice<T> v, List<Integer> ordenDescubrimiento) {
        v.setColor('a');
        ordenDescubrimiento.add(v.getId());
        for (Arco<T> arco : v.getAdyacentes()) {
            Vertice<T> adyacente = grafo.getVertices().get(arco.getVerticeDestino());
            if (adyacente.getColor() == 'b') {
                adyacente.setColor('a');
                dfs(adyacente, ordenDescubrimiento);
            }
        }
        v.setColor('n');
    }
}
