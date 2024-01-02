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
        //drawHead(g2);
        //paintHead(buffer);        

        //paintSep(g2);

        drawBodyBack(g2);
        drawDragonSpike(g2);

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
    void drawBodyBack(Graphics g){
        //blackTriangle
        bresenhamLine(g,388,240,340,274);
        bresenhamLine(g,340,274,314,326);
        bresenhamLine(g,314,326,300,387);
        bresenhamLine(g,300,387,265,268);
        bresenhamLine(g,265,268, 243,243);
        bresenhamLine(g,388,240,396,286);
        bresenhamLine(g,396,286 , 445,266);
        bresenhamLine(g,388,240,445,266);

        //grayPolygon
        bresenhamLine(g,340,274,388,333);
        bresenhamLine(g,388,333,466,317);
        bresenhamLine(g,466,317,388,333);

        //PurplebeSideTriangle
        bresenhamLine(g , 445,266,439,296);
        bresenhamLine(g ,439,296, 500,340);
        bresenhamLine(g , 445,266,491,313);
        bresenhamLine(g,491,313 , 500,340);

        //smallTriangle
        bresenhamLine(g,466,317,462,359);
        bresenhamLine(g,462,359,500,340);

        //bigTriangle
        bresenhamLine(g,462,359,459,391);
        bresenhamLine(g,459,391,419,345);
        bresenhamLine(g,419,345,388,333);

        //pigChin
        bresenhamLine(g,459,391,457,403);
        bresenhamLine(g,457,403,482,425);
        bresenhamLine(g,482,425,500,390);
        bresenhamLine(g,500,390,500,340);

        //triangleBesideChin
        bresenhamLine(g,457,403,450,462);
        bresenhamLine(g,450,462,482,425);

        //catButt
        bresenhamLine(g,450,462,370,490);
        bresenhamLine(g,370,490,373,442);
        bresenhamLine(g,373,442,417,437);
        bresenhamLine(g,417,437,459,391);

        //BeforecatTail
        bresenhamLine(g,370,490,265,507);
        bresenhamLine(g,265,507,298,474);
        bresenhamLine(g,298,474,317,480);
        bresenhamLine(g,317,480,370,490);
        
        //triangleAboveTail
        bresenhamLine(g,298,474,332,436);
        bresenhamLine(g,332,436,317,480);

        //squreBesideAboveTail
        bresenhamLine(g,332,436,373,442);
        
        //MiddlePenta
        bresenhamLine(g,417,437,388,333);

        //MiddleTriangle
        bresenhamLine(g,354,440,396,362);

        //MiddleLittleTriangle
        bresenhamLine(g,388,333,355,364);
        bresenhamLine(g,355,364,396,362);

        //MiddleSmallpentagon
        bresenhamLine(g,355,364,345,390);
        bresenhamLine(g,345,390,345,413);
        bresenhamLine(g,345,413,354,440);

        //tinytriTail
        bresenhamLine(g,345,413,332,436);

        //GraybesideWhitepentagon
        bresenhamLine(g,300,387,329,389);
        bresenhamLine(g,329,389,345,390);

        //superTinyUndertinyTri
        bresenhamLine(g,329,389,355,364);

        //tinyPigchin
        bresenhamLine(g,379,324,364,350);

        //tinyMiddleTriangle
        bresenhamLine(g,372,348,345,354);
        bresenhamLine(g,345,354,346,374);

        //WhitePentagon
        bresenhamLine(g,314,326,345,354);

        //underBlackMiddle
        bresenhamLine(g,300,387,316,406);
        bresenhamLine(g,316,406,329,389);

        //catPentagonStomach
        bresenhamLine(g,316,406,298,423);
        bresenhamLine(g,298,423,314,436);
        bresenhamLine(g,314,436,332,436);

        //
        bresenhamLine(g,314,436,318,452);

        //Tail
        bresenhamLine(g, 278,526, 251,539);
        bresenhamLine(g, 278,526, 280,540);
        bresenhamLine(g, 251,539, 280,540);

        bresenhamLine(g, 280,540, 292,553);
        bresenhamLine(g, 292,553, 293,568);
        bresenhamLine(g, 293,568, 262,562);
        bresenhamLine(g, 262,562, 250,546);
        bresenhamLine(g, 250,546, 251,539);

        bresenhamLine(g, 292,553, 350,560);
        bresenhamLine(g, 293,568, 350,560);


    }

     void drawcatTail(Graphics g){

     }

     void drawDragonSpike(Graphics g){
        //1
        bresenhamLine(g, 404, 229, 401, 235);
        bresenhamLine(g, 401, 235, 396, 246);
        
        //2
        bresenhamLine(g, 401, 235, 448, 249);
        bresenhamLine(g, 448, 249, 433, 262);

        //3
        bresenhamLine(g, 433, 262, 465, 259);
        bresenhamLine(g, 465, 259, 452, 275);

        //4
        bresenhamLine(g, 452, 275, 484, 280);
        bresenhamLine(g, 484, 280, 467, 291);

        //5
        bresenhamLine(g, 467, 291, 495, 290);
        bresenhamLine(g, 495, 290, 480, 302);

        //6
        bresenhamLine(g, 480, 302, 500, 308);
        bresenhamLine(g, 500, 308, 491, 313);

        //7
        bresenhamLine(g, 491, 313, 518, 342);
        bresenhamLine(g, 518, 342, 499, 346);

        //8
        bresenhamLine(g, 499, 346, 520, 370);
        bresenhamLine(g, 520, 370, 499, 367);
        
        //9
        bresenhamLine(g, 499, 372, 521, 391);
        bresenhamLine(g, 521, 391, 499, 390);

        //10
        bresenhamLine(g, 499, 390, 495, 446);
        bresenhamLine(g, 495, 446, 488, 432);
        bresenhamLine(g, 488, 432, 482,425);

        //11
        bresenhamLine(g, 488, 432, 451,490);
        bresenhamLine(g, 451, 490, 452,477);
        bresenhamLine(g, 452, 477, 450,462);

        //12
        bresenhamLine(g, 452, 477, 401,506);
        bresenhamLine(g, 401,506, 411, 475);

        //13
        bresenhamLine(g, 411,475, 377, 506);
        bresenhamLine(g, 377, 506, 386,484);

        //14
        bresenhamLine(g, 386,484, 353,510);
        bresenhamLine(g, 353,510, 363,492);

        //15
        bresenhamLine(g, 363,492, 332,510);
        bresenhamLine(g, 332,510, 332,497);

        //16
        bresenhamLine(g, 332,497, 287,524);
        bresenhamLine(g, 287,524, 293,503);
        bresenhamLine(g, 287,524, 263,528);
        bresenhamLine(g, 263,528, 265,507);

        //17
        bresenhamLine(g, 265,507, 243,519);
        bresenhamLine(g, 243,519, 263,528);
        bresenhamLine(g, 263,528, 265,507);

        //18
        bresenhamLine(g, 243,519, 232,526);
        bresenhamLine(g, 232,526, 242,531);
        bresenhamLine(g, 242,531, 224,546);
        bresenhamLine(g, 224,546, 239,548);
        bresenhamLine(g, 239,548, 250,546);

        bresenhamLine(g, 239,548, 236,566);
        bresenhamLine(g, 236,566, 243,560);
        bresenhamLine(g, 243,560, 250,546);

        //
        bresenhamLine(g, 243,560, 256,584);
        bresenhamLine(g, 256,584, 256,569);
        bresenhamLine(g, 256,569, 262,562);
        
     }


    void paintSep(Graphics g2) {
        bresenhamLineSep(g2, 300, 0, 300, 120);
        bresenhamLineSep(g2, 300, 120, 310, 110);
        bresenhamLineSep(g2, 310, 110, 360, 80);
        bresenhamLineSep(g2, 360, 80, 380, 75);
        bresenhamLineSep(g2, 380, 75, 370, 90);
        bresenhamLineSep(g2, 370, 90, 410, 80);
        bresenhamLineSep(g2, 410, 80, 395, 110);
        bresenhamLineSep(g2, 395, 110, 390, 130);
        bresenhamLineSep(g2, 390, 130, 395, 135);
        bresenhamLineSep(g2, 395, 135, 380, 150);
        bresenhamLineSep(g2, 380, 150, 375, 200);
        bresenhamLineSep(g2, 375, 200, 380, 220);
        bresenhamLineSep(g2, 380, 220, 360, 218);
        bresenhamLineSep(g2, 360, 218, 320, 260);
        bresenhamLineSep(g2, 320, 260, 280, 350);
        bresenhamLineSep(g2, 280, 350, 240, 360);
        bresenhamLineSep(g2, 240, 360, 275, 380);
        bresenhamLineSep(g2, 275, 380, 290, 400);
        bresenhamLineSep(g2, 290, 400, 290, 430);
        bresenhamLineSep(g2, 290, 430, 270, 450);
        bresenhamLineSep(g2, 270, 450, 230, 500);
        bresenhamLineSep(g2, 230, 500, 210, 505);
        bresenhamLineSep(g2, 210, 505, 220, 512);
        bresenhamLineSep(g2, 220, 512, 205, 520);
        bresenhamLineSep(g2, 205, 520, 210, 528);
        bresenhamLineSep(g2, 210, 528, 210, 600);
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
        float y = y1-50;
        //float y = y1;

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

    void bresenhamLineSep(Graphics g, int x1, int y1, int x2, int y2){
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
        //float y = y1;

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

        // for (int i = 0; i < innerNodes.length; i++) {
        //     map[innerNodes[i].getY()][innerNodes[i].getX()] = innerNodes[i];
        // }

        // for (int i = 0; i < innerNodes.length; i++) {
        //     findTwoNearestNodeAndDrawLine(g, map,map[innerNodes[i].getY()][innerNodes[i].getX()]);
        // }


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