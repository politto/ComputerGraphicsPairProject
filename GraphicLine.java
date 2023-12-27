import java.awt.Graphics;

public class GraphicLine {
    NodeCoordinate end1;
    NodeCoordinate end2;
    boolean isDrawn;

    GraphicLine(NodeCoordinate e1, NodeCoordinate e2) {
        end1 = e1;
        end2 = e2;
    }

    public NodeCoordinate getEnd1() {
        return end1;
    }

    public NodeCoordinate getEnd2() {
        return end2;
    }

    public void draw(Graphics g) {
        isDrawn = true;
        // bresenhamLine(g, end1.getX(), end1.getY(), end2.getX(), end2.getY());
    }

    public int getDistance() {
        return (int) Math.sqrt(Math.pow(Math.abs(end1.getX() - end2.getX()) + Math.abs(end1.getY() - end2.getY()), 2));
    }

    public boolean equals(GraphicLine other) {
        if (other == null) return false;
        return (this.end1.getX() == other.getEnd1().getX() && this.end2.getX() == other.getEnd2().getX()) || (this.end1.getX() == other.getEnd2().getX() && this.end2.getX() == other.getEnd1().getX());
    }

    public String toString() {
        return "End1 : " + getEnd1() + ", End2 : " + getEnd2();
    }
}
