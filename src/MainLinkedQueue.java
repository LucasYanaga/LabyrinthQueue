public class MainLinkedQueue {
    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue(5);
        Coordinate c1 = new Coordinate(0, 1);
        Coordinate c2 = new Coordinate(0, 2);
        Coordinate c3 = new Coordinate(0, 3);
        Coordinate c4 = new Coordinate(0, 4);
        Coordinate c5 = new Coordinate(0, 5);
        Coordinate c6 = new Coordinate(0, 6);
        queue.add(c1);
        queue.add(c2);
        queue.add(c3);

        queue.printLinkedQueue();

        System.out.println(queue.first.coord.printCoordinate());
        System.out.println(queue.last.coord.printCoordinate());

        queue.add(c4);
        queue.add(c5);
        queue.add(c6);

        queue.printLinkedQueue();

        System.out.println(queue.first.coord.printCoordinate());
        System.out.println(queue.last.coord.printCoordinate());

        queue.remove();
        queue.remove();
        queue.remove();

        queue.printLinkedQueue();

        System.out.println(queue.first.coord.printCoordinate());
        System.out.println(queue.last.coord.printCoordinate());

        queue.remove();
        queue.remove();

        queue.printLinkedQueue();
    }
}
