import java.util.Iterator;

public class MyIterator<T> implements Iterator<T> {
    private Node<T> nodo;

    public MyIterator(Node<T> nodo){
        super();
        this.nodo = nodo;
    }

    @Override
    public boolean hasNext() {
        return this.nodo != null;
    }

    @Override
    public T next() {
        T result = nodo.getInfo();
        nodo = nodo.getNext();
        return result;
    }

    public T getInfoNodo() {
        return this.nodo.getInfo();
    }
}
