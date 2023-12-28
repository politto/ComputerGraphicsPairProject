import javax.swing.*;
import org.w3c.dom.Node;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class Assignment1_65050101_65050301 extends JPanel{
    public static void main(String[] args) {
        Assignment1_65050101_65050301 wr = new Assignment1_65050101_65050301();

        JFrame jf = new JFrame();
        jf.add(wr);
        jf.setTitle("Project_Of_65050301_65050101");
        jf.setSize(600, 600);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }

    public void paintComponent(Graphics g) {

        BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buffer.createGraphics();

        g2.setColor(new Color(200, 152, 87));
        g2.fillRect(0, 0, 600, 600);

        g2.setColor(new Color(205, 160, 95));
        // bezierCurve(g2, 100, 100, 500, 500, 100, 500, 500, 100);
        // BresenhamLine(g2, 100, 100, 500, 100);

        // int[] xpoly = {100, 250, 550, 400, 250, 90 ,40};
        // int[] ypoly = {100, 50, 150, 300, 500, 400, 200};
        // Polygon poly = new Polygon(xpoly, ypoly,7);
        // g2.drawPolygon(poly);
        // buffer = floodFill(buffer, 480, 110, new Color(200, 152, 87), Color.BLUE);
        drawHead(g2);
        paintHead(buffer);
        paintSep(g2);


        g.drawImage(buffer, 0, 0, null);
        
    }

    void drawHead(Graphics g) {
        drawCircle(g, 117, 225, 12);
        drawCircle(g, 117, 225, 10);
        drawCircle(g, 175, 227, 12);
        drawCircle(g, 175, 227, 10);
        NodeCoordinate[] outer = {
            new NodeCoordinate(82, 268),
            new NodeCoordinate(89, 287),
            new NodeCoordinate(105, 311),
            new NodeCoordinate(134, 318),
            new NodeCoordinate(150, 318),
            new NodeCoordinate(187, 308),
            new NodeCoordinate(201, 289),
            new NodeCoordinate(208, 271),
            new NodeCoordinate(212, 264),
            new NodeCoordinate(211, 238),
            new NodeCoordinate(207, 226),
            new NodeCoordinate(211, 215),
            new NodeCoordinate(220, 168),
            new NodeCoordinate(216, 161),
            new NodeCoordinate(203, 168),
            new NodeCoordinate(181, 186),
            new NodeCoordinate(181, 171),
            new NodeCoordinate(187, 161),
            new NodeCoordinate(195, 150),
            new NodeCoordinate(193, 129),
            new NodeCoordinate(185, 131),
            new NodeCoordinate(185, 150),
            new NodeCoordinate(182, 159),
            new NodeCoordinate(174, 147),
            new NodeCoordinate(172, 154),
            new NodeCoordinate(171, 168),
            new NodeCoordinate(162, 186),
            new NodeCoordinate(126, 184),
            new NodeCoordinate(119, 167),
            new NodeCoordinate(121, 148),
            new NodeCoordinate(119, 143),
            new NodeCoordinate(111, 152),
            new NodeCoordinate(108, 144),
            new NodeCoordinate(109, 119),
            new NodeCoordinate(102, 127),
            new NodeCoordinate(101, 147),
            new NodeCoordinate(106, 159),
            new NodeCoordinate(100, 152),
            new NodeCoordinate(90, 148),
            new NodeCoordinate(86, 162),
            new NodeCoordinate(87, 192),
            new NodeCoordinate(79, 224),
        };
        myPolygonDraw(g, outer);

        //Right horn        
        g.setColor(new Color(205, 160, 95));
        ArrayList<NodeCoordinate> inner = new ArrayList<>();

        inner.add(new NodeCoordinate(177, 160));
        inner.add(new NodeCoordinate(181, 171));
        inner.add(new NodeCoordinate(162, 186));
        inner.add(new NodeCoordinate(157, 195));
        inner.add(new NodeCoordinate(173, 200));
        inner.add(new NodeCoordinate(181, 186));
        inner.add(new NodeCoordinate(181, 211));
        inner.add(new NodeCoordinate(160, 211));
        inner.add(new NodeCoordinate(151, 223));
        inner.add(new NodeCoordinate(138, 222));
        inner.add(new NodeCoordinate(130, 190));
        inner.add(new NodeCoordinate(126, 184));
        inner.add(new NodeCoordinate(106, 159));
        inner.add(new NodeCoordinate(113, 200));
        inner.add(new NodeCoordinate(130, 190));
        
        continuousDraw(g, inner);
        inner.clear();

        //Left horn



        
        // autoDrawByPart(g, outer, inner);
        // autoDraw2(g, outer);

    }

    void paintHead(BufferedImage bf){
        long start = new Date().getTime();
        floodFill(bf, 117, 220, new Color(200, 152, 87), Color.BLACK);
        floodFill(bf, 175, 227, new Color(200, 152, 87), Color.BLACK);
        floodFill(bf, 102, 226, new Color(200, 152, 87), Color.WHITE);
        floodFill(bf, 147, 203, new Color(200, 152, 87), Color.WHITE);
        floodFill(bf, 172, 184, new Color(200, 152, 87), new Color(235, 218, 70));
        floodFill(bf, 178, 168, new Color(200, 152, 87), new Color(242, 115, 64));
        floodFill(bf, 121, 189, new Color(200, 152, 87), new Color(235, 218, 70));        
        floodFill(bf, 105, 143, new Color(200, 152, 87), new Color(242, 115, 64));
        System.out.println(new Date().getTime() - start);

    }
    void drawCircle(Graphics g, int cenx, int ceny, int rad){
        if (rad % 2 > 0){
            System.out.println("Error in this case rad must be even!");
            return;
        } 
        bezierCurve(g, cenx - rad, ceny, cenx - rad, ceny - rad / 2, cenx - rad / 2, ceny - rad, cenx, ceny - rad);
        bezierCurve(g, cenx, ceny - rad, cenx + rad / 2, ceny - rad, cenx + rad, ceny - rad / 2, cenx + rad, ceny);
        bezierCurve(g, cenx + rad, ceny, cenx + rad, ceny + rad / 2, cenx + rad / 2, ceny + rad, cenx, ceny + rad);
        bezierCurve(g, cenx, ceny + rad, cenx - rad / 2, ceny + rad, cenx - rad, ceny + rad / 2, cenx - rad, ceny);
        
    }

    void paintSep(Graphics g2) {
        bresenhamLine(g2, 300, 0, 300, 120);
        bresenhamLine(g2, 300, 120, 310, 110);
        bresenhamLine(g2, 310, 110, 360, 80);
        bresenhamLine(g2, 360, 80, 380, 75);
        bresenhamLine(g2, 380, 75, 370, 90);
        bresenhamLine(g2, 370, 90, 410, 80);
        bresenhamLine(g2, 410, 80, 395, 110);
        bresenhamLine(g2, 395, 110, 390, 130);
        bresenhamLine(g2, 390, 130, 395, 135);
        bresenhamLine(g2, 395, 135, 380, 150);
        bresenhamLine(g2, 380, 150, 375, 200);
        bresenhamLine(g2, 375, 200, 380, 220);
        bresenhamLine(g2, 380, 220, 360, 218);
        bresenhamLine(g2, 360, 218, 320, 260);
        bresenhamLine(g2, 320, 260, 280, 350);
        bresenhamLine(g2, 280, 350, 240, 360);
        bresenhamLine(g2, 240, 360, 275, 380);
        bresenhamLine(g2, 275, 380, 290, 400);
        bresenhamLine(g2, 290, 400, 290, 430);
        bresenhamLine(g2, 290, 430, 270, 450);
        bresenhamLine(g2, 270, 450, 230, 500);
        bresenhamLine(g2, 230, 500, 210, 505);
        bresenhamLine(g2, 210, 505, 220, 512);
        bresenhamLine(g2, 220, 512, 205, 520);
        bresenhamLine(g2, 205, 520, 210, 528);
        bresenhamLine(g2, 210, 528, 210, 600);
    }

    void bezierCurve(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
        for (int i = 0; i < 10000; i++) {
            float t = i / 10000.0f;
            // System.out.println( (Math.pow(1 - t, 3) * x1 + 3 * t * Math.pow(1 - t, 2) * x2 + 3 * t * t * (1 - t) * x3 + Math.pow(t, 4) * x4));
            plot(
            g, 
            (int) (
                Math.pow(1 - t, 3) * x1 
                + 3 * t * Math.pow(1 - t, 2) * x2 
                + 3 * t * t * (1 - t) * x3 
                + Math.pow(t, 3) * x4),
            (int) (
                Math.pow(1 - t, 3) * y1
                 + 3 * t * Math.pow(1 - t, 2) * y2
                 + 3 * t * t * (1 - t) * y3
                 + Math.pow(t, 3) * y4));
        }
    }

    public BufferedImage floodFill (BufferedImage m, int x, int y, Color targetColor, Color replacementColor){
        Queue<NodeCoordinate> q = new LinkedList<>();
        coloredPlot(m.getGraphics(), x, y, replacementColor);
        q.add(new NodeCoordinate(x, y));

        while (!q.isEmpty()) {
            NodeCoordinate cur = q.poll();
            try {
                //Sounth
                if (m.getRGB(cur.getX(), cur.getY() + 1) == targetColor.getRGB()) {
                    coloredPlot(m.getGraphics(), cur.getX(), cur.getY() + 1, replacementColor);
                    q.add(new NodeCoordinate(cur.getX(), cur.getY() + 1));
                }

            }
            catch (ArrayIndexOutOfBoundsException e) {
                
            }
            try {
                //North
                if (m.getRGB(cur.getX(), cur.getY() - 1) == targetColor.getRGB()) {
                    coloredPlot(m.getGraphics(), cur.getX(), cur.getY() - 1, replacementColor);
                    q.add(new NodeCoordinate(cur.getX(), cur.getY() - 1));
                }

            }
            catch (ArrayIndexOutOfBoundsException e) {
                
            }
            try {
                //West
                if (m.getRGB(cur.getX() - 1, cur.getY()) == targetColor.getRGB()) {
                    coloredPlot(m.getGraphics(), cur.getX() - 1, cur.getY(), replacementColor);
                    q.add(new NodeCoordinate(cur.getX() - 1, cur.getY()));
                }

            }
            catch (ArrayIndexOutOfBoundsException e) {
                
            }
            try {
                //East
                if (m.getRGB(cur.getX() + 1, cur.getY()) == targetColor.getRGB()) {
                    coloredPlot(m.getGraphics(), cur.getX() + 1, cur.getY(), replacementColor);
                    q.add(new NodeCoordinate(cur.getX() + 1, cur.getY()));
                }

            }
            catch (ArrayIndexOutOfBoundsException e) {
                
            }

        }

        return m;
    }

    void bresenhamLine(Graphics g, int x1, int y1, int x2, int y2){
        float dx = Math.abs(x2 - x1);
        float dy = Math.abs(y2 - y1);

        float sx = (x1 < x2)? 1 : -1;
        float sy = (y1 < y2)? 1 : -1;
        boolean isSwap = false;

        if (dy > dx) {
            float tmp = dx;
            dx = dy;
            dy = tmp;
            isSwap = true;
        }

        float D = 2 * dy / dx;

        float x = x1;
        float y = y1;

        for (int i = 0; i < dx; i++) {
            plot(g, x, y);
            // if (i % 4 == 0) System.out.println(x + " " + y + " " + D);
            if (D >= 0) {
                if (isSwap) x += sx;
                else y += sy;

                D -= 2 * dx;
            }

            if (isSwap) y += sy;
            else x += sx;

            D += 2 * dy;

        }

    }

    void myPolygonDraw(Graphics g, NodeCoordinate[] input){

        for (int i = 1; i < input.length; i++) {
            bresenhamLine(g, input[i - 1].getX(), input[i - 1].getY(), input[i].getX(), input[i].getY());
        }
        bresenhamLine(g, input[input.length - 1].getX(), input[input.length - 1].getY(), input[0].getX(), input[0].getY());
    }

    void continuousDraw(Graphics g, NodeCoordinate[] input) {
                for (int i = 1; i < input.length; i++) {
            bresenhamLine(g, input[i - 1].getX(), input[i - 1].getY(), input[i].getX(), input[i].getY());
        }
    }

    void myPolygonDraw(Graphics g, ArrayList<NodeCoordinate> input){

        for (int i = 1; i < input.size(); i++) {
            bresenhamLine(g, input.get(i - 1).getX(), input.get(i - 1).getY(), input.get(i).getX(), input.get(i).getY());
        }
        bresenhamLine(g, input.get(input.size() - 1).getX(), input.get(input.size() - 1).getY(), input.get(0).getX(), input.get(0).getY());
    }

    void continuousDraw(Graphics g, ArrayList<NodeCoordinate> input) {
                for (int i = 1; i < input.size(); i++) {
            bresenhamLine(g, input.get(i - 1).getX(), input.get(i - 1).getY(), input.get(i).getX(), input.get(i).getY());
        }
    }

    void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, 1, 1);
    }

    void plot(Graphics g, float x, float y) {
        g.fillRect((int) x, (int) y, 1, 1);
    }

    void coloredPlot(Graphics g, int x, int y, Color c) {
        g.setColor(c);
        g.fillRect(x, y, 1, 1);
        g.setColor(Color.BLACK);
    }
}