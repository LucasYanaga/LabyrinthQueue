public class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String printCoordinate(){
        return "(" + this.x + ", " + this.y + ")";
    }
}