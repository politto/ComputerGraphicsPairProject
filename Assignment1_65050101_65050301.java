import javax.swing.*;
import org.w3c.dom.Node;
import java.awt.*;
import java.awt.image.BufferedImage;
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

        g2.setColor(Color.BLACK);
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
        drawCircle(g, 102, 220, 8);
        drawCircle(g, 102, 220, 4);
        drawCircle(g, 132, 220, 8);
        drawCircle(g, 132, 220, 4);
        NodeCoordinate[] outerr = {
            new NodeCoordinate(150, 150),
            new NodeCoordinate(150, 180),
            new NodeCoordinate(180, 200),
            new NodeCoordinate(180, 250),
            new NodeCoordinate(200, 250),
            new NodeCoordinate(200, 200),
            new NodeCoordinate(250, 200),
            new NodeCoordinate(300, 200),
            new NodeCoordinate(400, 200),
            new NodeCoordinate(400, 250),
            new NodeCoordinate(300, 220),
        };
        NodeCoordinate[] inner = {null};
        autoDrawByPart(g, outerr, inner);

    }

    void paintHead(BufferedImage bf){
        long start = new Date().getTime();
        floodFill(bf, 102, 220, new Color(200, 152, 87), Color.BLACK);
        floodFill(bf, 102, 226, new Color(200, 152, 87), Color.WHITE);
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


            // System.out.println(q.size());

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

    void autoDrawByPart(Graphics g, NodeCoordinate[] borderNodes, NodeCoordinate[] innerNodes){
        NodeCoordinate[][] map = new NodeCoordinate[600][600];

        for (int i = 0; i < borderNodes.length; i++) {
            map[borderNodes[i].getY()][borderNodes[i].getX()] = borderNodes[i];
        }

        for (int i = 0; i < borderNodes.length; i++) {
            findTwoNearestNodeAndDrawLine(g, map,map[borderNodes[i].getY()][borderNodes[i].getX()]);
        }

        for (int i = 0; i < innerNodes.length; i++) {
            map[innerNodes[i].getY()][innerNodes[i].getX()] = innerNodes[i];
        }

        for (int i = 0; i < innerNodes.length; i++) {
            findTwoNearestNodeAndDrawLine(g, map,map[innerNodes[i].getY()][innerNodes[i].getX()]);
        }


    }

    void findTwoNearestNodeAndDrawLine(Graphics g, NodeCoordinate[][] map, NodeCoordinate from) {
        NodeCoordinate[] nearest = new NodeCoordinate[2];
        int nullNearestLeft = 2;
        int radius = 1;
        System.out.println("Function find n draw Started!");
        while (nearest[0] == null && radius <= 600) {
            System.out.println(nearest[0] + " <1 Nearest 2> " + nearest[1]);
            for (int i = radius; i > 0; i--) {
                for (int j = -i; j <= i; j++) {

                    if (i == radius && j == 0 && i < 0) continue;

                    if (
                        from.getY() + i >= 0 && from.getY() + i < map.length 
                        && from.getX() + j >= 0 && from.getX() + j < map[0].length
                        && map[from.getY() + i][from.getX() + j] != null
                        && !checkArrContains(nearest, map[from.getY() + i][from.getX() + j])
                    ){

                        NodeCoordinate to = map[from.getY() + i][from.getX() + j];
                        nearest[nullNearestLeft - 1] = to;
                        bresenhamLine(g, from.getX(), from.getY(), to.getX(), to.getY());
                        nullNearestLeft--;
                    }

                    if (
                        from.getY() + i >= 0 && from.getY() + i < map.length 
                        && from.getX() - j >= 0 && from.getX() - j < map[0].length
                        && map[from.getY() + i][from.getX() - j] != null
                        && !checkArrContains(nearest, map[from.getY() + i][from.getX() - j])
                    ){

                        NodeCoordinate to = map[from.getY() + i][from.getX() - j];
                        nearest[nullNearestLeft - 1] = to;
                        bresenhamLine(g, from.getX(), from.getY(), to.getX(), to.getY());
                        nullNearestLeft--;
                    }

                    if (
                        from.getY() - i >= 0 && from.getY() - i < map.length 
                        && from.getX() + j >= 0 && from.getX() + j < map[0].length
                        && map[from.getY() - i][from.getX() + j] != null
                        && !checkArrContains(nearest, map[from.getY() - i][from.getX() + j])
                    ){

                        NodeCoordinate to = map[from.getY() - i][from.getX() + j];
                        nearest[nullNearestLeft - 1] = to;
                        bresenhamLine(g, from.getX(), from.getY(), to.getX(), to.getY());
                        nullNearestLeft--;
                    }

                    if (
                        from.getY() - i >= 0 && from.getY() - i < map.length 
                        && from.getX() - j >= 0 && from.getX() - j < map[0].length
                        && map[from.getY() - i][from.getX() - j] != null
                        && !checkArrContains(nearest, map[from.getY() - i][from.getX() - j])
                    ){

                        NodeCoordinate to = map[from.getY() - i][from.getX() - j];
                        nearest[nullNearestLeft - 1] = to;
                        bresenhamLine(g, from.getX(), from.getY(), to.getX(), to.getY());
                        nullNearestLeft--;
                    }

                    
                    
                    // System.out.println(nullNearestLeft + " << null left, radius : " + radius + ", i : " + i + ", j : " + j);
                    if (nullNearestLeft < 1) {
                        
                        System.out.println(nearest[0] + " <1 Nearest 2> " + nearest[1]);
                        return;
                    }

                
                }
            }
            radius++;
        }
    }

    // void findTwoNearestNodeAndDrawLine2(Graphics g, NodeCoordinate[][] map, NodeCoordinate from) {
    //     NodeCoordinate[] nearest = new NodeCoordinate[2];
    //     int nullNearestLeft = 2;
    //     int maxRadius = 600;
    //     int radius = 1;
    // 
    //     while (nullNearestLeft > 0 && radius <= maxRadius) {
    //         for (int i = radius; i > 0; i--) {
    //             boolean foundNearest = checkDirectionAndDrawLine(g, map, from, i, 0, nearest);
    //             foundNearest |= checkDirectionAndDrawLine(g, map, from, -i, 0, nearest);
    //             foundNearest |= checkDirectionAndDrawLine(g, map, from, 0, i, nearest);
    //             foundNearest |= checkDirectionAndDrawLine(g, map, from, 0, -i, nearest);
    // 
    //             if (foundNearest) {
    //                 return;
    //             }
    //         }
    //         radius++;
    //     }
    // }
    
    // boolean checkDirectionAndDrawLine(Graphics g, NodeCoordinate[][] map, NodeCoordinate from, int xOffset, int yOffset, NodeCoordinate[] nearest) {
    //     int newY = from.getY() + yOffset;
    //     int newX = from.getX() + xOffset;
    // 
    //     if (newY >= 0 && newY < map.length && newX >= 0 && newX < map[0].length) {
    //         NodeCoordinate to = map[newY][newX];
    //         if (to != null && !checkArrContains(nearest, to)) {
    //             nearest[1] = to;
    //             bresenhamLine(g, from.getX(), from.getY(), to.getX(), to.getY());
    //             nearestLeft--;
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    <T> boolean checkArrContains(T[] arr, T target){
        if (arr.length == 0) return false;
        for (T t : arr) {
            if (t == null) continue;
            if (t.equals(target)) return true; 
        }

        return false;
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