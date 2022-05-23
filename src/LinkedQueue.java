public class LinkedQueue {
    Node last;
    Node first;
    int count;
    int lenght;

    public LinkedQueue(int lenght) {
        this.lenght = lenght;
        this.count = 0;
    }

    public boolean isEmpty(){
        if(this.first == null && this.last == null){
            return true;
        }else{
            return false;
        }
    }

    public boolean isFull(){
        return this.count == this.lenght;
    }

    public void clear(){
        this.last = null;
        this.first = null;
        this.count = 0;
    }

    public void add(Coordinate coord){
        Node node = new Node(coord);

        if(!isFull()) {
            if (isEmpty()) {
                this.last = node;
                this.first = node;
            } else {
                this.last.next = node;
                this.last = node;
            }

            this.count++;
        }else{
            System.out.println("Queue is full!");
        }
    }

    public Coordinate remove(){
        if(this.first == null){
            System.out.println("Queue is empty!");
            return null;
        }else{
           Node aux = this.first;
            this.first = this.first.next;
            this.count--;

            if(last == null){
                first = null;
            }

           return aux.coord;
        }
    }

    public void printLinkedQueue(){
        Node node = this.first;
        System.out.print("[");
        for (int i = 0; i < this.count; i++) {
            if(i == this.count - 1){
                System.out.print(node.getCoord().printCoordinate());
            }else {
                System.out.print(node.getCoord().printCoordinate() + ", ");
                node = node.getNext();
            }

        }
        System.out.println("]");
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }
}
