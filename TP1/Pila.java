public class Pila<T> {
    private LinkedList<T> list;

    public Pila() {
        super();
        list = new LinkedList<>();
    }

    public void push(T obj) {
        list.insertFront(obj);
    }

    public T pop() {
        return list.extractFront();
    }

    public T top() {
        return list.get(0);
    }

    public void reverse() {
        LinkedList<T> listReverse = new LinkedList<>();
        int sizeList = list.getSize();
        for(int i = 0; i < sizeList; i++) {
            listReverse.insertFront(this.list.extractFront());
        }
        this.list = listReverse;
    }
}
