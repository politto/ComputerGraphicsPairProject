public class NodeCoordinate {
    private int x;
    private int y;
    private int linesInto = 0;

    NodeCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLinesInto() {
        return linesInto;
    }

    public void setLinesInto(int linesInto) {
        this.linesInto = linesInto;
    }

    public boolean equals(NodeCoordinate other) {
        if (other == null) return false;
        return other.getX() == this.getX() && other.getY() == this.getY();
    }
    public String toString() {
        return "NodeCoordinate x: " + x + ", y: " + y;
    }
}
