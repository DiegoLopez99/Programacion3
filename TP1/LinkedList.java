public class LinkedList<T> implements Iterable<T>{
    private Node<T> first;
    private Node<T> last;
    private int size;

    public LinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public void insertFront(T info) {
        Node<T> tmp = new Node<T> (info, null);
        tmp.setNext(first);
        this.first = tmp;
        this.size = size+1;
    }

    public void insertLast(T info) {
        if(info  != null){
            if (this.isEmpty()){
                this.insertFront(info);
            } else {
                Node<T> newNode = new Node<T>(info, null);
                if(this.last == null){
                    this.first.setNext(newNode);
                }else {
                    last.setNext(newNode);
                }
                last = newNode;
                this.size++;
            }
        }

    }

    public int getSize() {
        return size;
    }

    public T extractFront() {
        Node<T> firstExtract = this.first;
        this.first = firstExtract.getNext();
        this.size = this.size-1;
        return firstExtract.getInfo();
    }

    public boolean isEmpty() {
        return this.first != null;
    }

    public T get(int index) {
        Node<T> aux = this.first;
        if(aux != null) {
            int i = 0;
            while(i < this.size) {
                if(i == index) {
                    return aux.getInfo();
                }else {
                    aux = aux.getNext();
                }
                i++;
            }
            return null;
        }else {
            return null;
        }
    }

    public int indexOf(T obj) {
        Node<T> aux = this.first;
        int i = 0;
        while(i < this.size) {
            if(aux.getInfo().equals(obj)) {
                return i;
            }else {
                aux = aux.getNext();
            }
            i++;
        }
        return -1;
    }

    public String toString() {
        String result = "";
        Node<T> aux = this.first;
        for(int i = 0; i < this.size; i++) {
            result += aux.getInfo() + "\n";
            if(aux.getNext() != null) {
                aux = aux.getNext();
            }
        }
        return result;
    }

    @Override
    public MyIterator<T> iterator() {
        return new MyIterator<T>(this.first);
    }

}
