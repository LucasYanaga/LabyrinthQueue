public class Node {
    Coordinate coord;
    Node next;

    public Node(Coordinate coord) {
        this.coord = coord;
        this.next = null;
    }

    public Coordinate getCoord() {
        return coord;
    }

    public void setCoord(Coordinate coord) {
        this.coord = coord;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}
