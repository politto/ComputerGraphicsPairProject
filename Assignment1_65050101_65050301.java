import javax.swing.*;
import org.w3c.dom.Node;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Date;
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
        drawHead(g2);
        paintHead(buffer);
        drawWing(g2);
        g2.setColor(new Color(140, 131, 138));
        drawfrontBody(g2);
        paintWing(buffer);
        paintFrontBody(buffer);
        paintLegs(buffer);
        drawBodyBack(g2);
        drawDragonSpike(g2);
        //paintBackBody(buffer);

        
        g2.setColor(Color.black);
        bezierCurve(g2, 120, 246, 50, 250, 100, 300, 40, 310);
        bezierCurve(g2, 118, 242, 90, 235, 60, 280, 30, 280);
        bezierCurve(g2, 161, 247, 200, 245, 180, 300, 220, 310);
        bezierCurve(g2, 162, 243, 200, 240, 225, 290, 250, 280);

        g.drawImage(buffer, 0, 0, null);
        
    }

    void paintLegs(BufferedImage bf) {
        Color baseColor = new Color(200, 152, 87);

        floodFill(bf, 110, 380, baseColor, new Color(27, 39, 26));
        floodFill(bf, 110, 365, baseColor, new Color(43, 50, 40));
        floodFill(bf, 100, 375, baseColor, new Color(152, 122, 110));
        floodFill(bf, 100, 365, baseColor, new Color(132, 102, 88));
        floodFill(bf, 100, 385, baseColor, new Color(152, 122, 110));

        floodFill(bf, 108, 438, baseColor,  new Color(70, 58, 60));
        floodFill(bf, 145, 435, baseColor,  new Color(70, 58, 60));
        floodFill(bf, 80, 430, baseColor, new Color(182, 152, 150));
        floodFill(bf, 70, 430, baseColor, new Color(176, 147, 150));
        floodFill(bf, 90, 425, baseColor, new Color(195, 170, 175));
        floodFill(bf, 100, 425, baseColor, new Color(160, 155, 154));
        floodFill(bf, 200, 425, baseColor, new Color(210, 180, 185));
        floodFill(bf, 200, 405, baseColor, new Color(150, 130, 125));
        floodFill(bf, 150, 400, baseColor, new Color(210, 180, 185));
        floodFill(bf, 250, 400, baseColor, new Color(160, 134, 122));
        floodFill(bf, 250, 420, baseColor, new Color(134, 112, 122));
        floodFill(bf, 250, 398, baseColor, new Color(160, 134, 122));
        floodFill(bf, 250, 380, baseColor, new Color(200, 175, 179));
        floodFill(bf, 210, 390, baseColor, new Color(200, 165, 175));
        floodFill(bf, 210, 380, baseColor, new Color(215, 198, 199));
        floodFill(bf, 210, 360, baseColor, new Color(225, 210, 205));

        floodFill(bf, 289, 416, baseColor, new Color(120, 99, 89));
        floodFill(bf, 55, 450, baseColor, new Color(110, 99, 89));
        floodFill(bf, 52, 445, baseColor, new Color(120, 102, 105));
        floodFill(bf, 50, 440, baseColor, new Color(145, 132, 125));
        
        
    }

    void paintFrontBody(BufferedImage bf){
        Color baseColor = new Color(200, 152, 87);

        floodFill(bf, 264, 344, baseColor, new Color(210, 180, 185));
        floodFill(bf, 264, 324, baseColor, new Color(220, 200, 215));
        floodFill(bf, 240, 300, baseColor, new Color(230, 234, 220));floodFill(bf, 220, 330, baseColor, new Color(230, 224, 220));floodFill(bf, 230, 280, baseColor, new Color(230, 224, 220));
        floodFill(bf, 230, 310, baseColor, new Color(220, 230, 230));
        floodFill(bf, 187, 334, baseColor, new Color(220, 200, 190));floodFill(bf, 220, 310, baseColor, new Color(210, 220, 200));floodFill(bf, 220, 280, baseColor, new Color(210, 220, 200));floodFill(bf, 206, 280, baseColor, new Color(210, 220, 200));
        
        floodFill(bf, 120, 364, baseColor, new Color(117, 89, 83));
        floodFill(bf, 100, 304, baseColor, new Color(137, 105, 102));
        floodFill(bf, 130, 350, baseColor, new Color(137, 110, 112));
        floodFill(bf, 150, 324, baseColor, new Color(155, 140, 143));
        floodFill(bf, 180, 324, baseColor, new Color(165, 158, 162));
        floodFill(bf, 180, 344, baseColor, new Color(155, 140, 143));
        floodFill(bf, 220, 250, baseColor, new Color(165, 158, 162));
    }

    void paintWing(BufferedImage bf) {
        Color baseColor = new Color(200, 152, 87);

        floodFill(bf, 260, 215, baseColor, Color.black);
        floodFill(bf, 250, 215, baseColor, Color.black);
        floodFill(bf, 252, 250, baseColor, Color.black);
        floodFill(bf, 247, 223, baseColor, Color.black);
        floodFill(bf, 300, 101, baseColor, new Color(220, 209, 193));
        floodFill(bf, 300, 120, baseColor, new Color(200, 180, 169));
        floodFill(bf, 300, 130, baseColor, new Color(177, 149, 136));
        floodFill(bf, 300, 150, baseColor, new Color(220, 209, 193));
        floodFill(bf, 340, 170, baseColor, new Color(200, 180, 169));
        floodFill(bf, 300, 180, baseColor, new Color(177, 149, 136));
        floodFill(bf, 330, 230, baseColor, new Color(220, 209, 193));
        floodFill(bf, 300, 250, baseColor, new Color(177, 149, 136));

        floodFill(bf, 260, 130, baseColor, new Color(177, 149, 136));

        //floodFill(bf, 463, 360, baseColor, Color.BLACK);
    }

    void drawfrontBody(Graphics g){
        ArrayList<NodeCoordinate> inner = new ArrayList<>();

        inner.add(new NodeCoordinate(203, 226));
        inner.add(new NodeCoordinate(240, 223));

        continuousDraw(g, inner);
        inner.clear();

        //หนามบน
        bresenhamLine(g, 203, 226, 225, 205);
        bresenhamLine(g, 225, 205, 222, 225);
        bresenhamLine(g, 223, 222, 245, 200);
        bresenhamLine(g, 245, 200, 240, 223);
        bresenhamLine(g, 240, 223, 254, 216);


        
        inner.add(new NodeCoordinate(82, 268));
        inner.add(new NodeCoordinate(79, 291));
        // inner.add(new NodeCoordinate(100, 335));
        inner.add(new NodeCoordinate(121, 378));
        inner.add(new NodeCoordinate(138, 387));
        inner.add(new NodeCoordinate(167, 368));
        inner.add(new NodeCoordinate(218, 341));
        inner.add(new NodeCoordinate(262, 390));
        inner.add(new NodeCoordinate(279, 399));
        inner.add(new NodeCoordinate(277, 423));
        inner.add(new NodeCoordinate(315, 425));
        inner.add(new NodeCoordinate(295, 411));
        inner.add(new NodeCoordinate(317, 396));
        inner.add(new NodeCoordinate(301, 375));
        inner.add(new NodeCoordinate(278, 311));
        inner.add(new NodeCoordinate(264, 251));
        inner.add(new NodeCoordinate(240, 223));
        
        


        continuousDraw(g, inner);
        inner.clear();

        inner.add(new NodeCoordinate(106, 312));
        inner.add(new NodeCoordinate(100, 335));
        inner.add(new NodeCoordinate(131, 357));
        inner.add(new NodeCoordinate(153, 349));
        inner.add(new NodeCoordinate(198, 323));
        inner.add(new NodeCoordinate(278, 308));
        inner.add(new NodeCoordinate(211, 262));
        inner.add(new NodeCoordinate(195, 352));

        continuousDraw(g, inner);
        inner.clear();
        
        inner.add(new NodeCoordinate(242, 225));
        inner.add(new NodeCoordinate(210, 261));
        inner.add(new NodeCoordinate(231, 296));
        inner.add(new NodeCoordinate(218, 341));
        inner.add(new NodeCoordinate(170, 341));

        continuousDraw(g, inner);
        inner.clear();
        
        bresenhamLine(g, 200, 290, 295, 355);
        bresenhamLine(g, 130, 357, 134, 316);
        bresenhamLine(g, 151, 316, 156, 377);
        bresenhamLine(g, 279, 400, 297, 412);

        drawLegs(g, inner);
    }

    void drawLegs(Graphics g, ArrayList<NodeCoordinate> inner) {

        inner.add(new NodeCoordinate(102, 337));
        inner.add(new NodeCoordinate(84, 377));
        inner.add(new NodeCoordinate(72, 390));
        inner.add(new NodeCoordinate(67, 408));
        inner.add(new NodeCoordinate(49, 420));
        inner.add(new NodeCoordinate(57, 421));
        inner.add(new NodeCoordinate(52, 437));
        inner.add(new NodeCoordinate(59, 444));
        inner.add(new NodeCoordinate(57, 453));
        inner.add(new NodeCoordinate(79, 451));
        inner.add(new NodeCoordinate(108, 441));
        inner.add(new NodeCoordinate(167, 440));
        inner.add(new NodeCoordinate(279, 424));

        continuousDraw(g, inner);
        inner.clear();
        
        inner.add(new NodeCoordinate(115, 366));
        inner.add(new NodeCoordinate(112, 385));
        inner.add(new NodeCoordinate(100, 400));
        inner.add(new NodeCoordinate(100, 405));
        inner.add(new NodeCoordinate(126, 399));
        inner.add(new NodeCoordinate(140, 387));

        continuousDraw(g, inner);
        inner.clear();

        inner.add(new NodeCoordinate(111, 358));
        inner.add(new NodeCoordinate(105, 368));
        inner.add(new NodeCoordinate(113, 371));
        inner.add(new NodeCoordinate(102, 388));
        inner.add(new NodeCoordinate(100, 400));
        inner.add(new NodeCoordinate(89, 411));

        continuousDraw(g, inner);
        inner.clear();
        
        inner.add(new NodeCoordinate(105, 368));
        inner.add(new NodeCoordinate(89, 361));
        inner.add(new NodeCoordinate(102, 388));

        continuousDraw(g, inner);
        inner.clear();
        
        inner.add(new NodeCoordinate(67, 409));
        inner.add(new NodeCoordinate(78, 415));
        inner.add(new NodeCoordinate(92, 410));
        inner.add(new NodeCoordinate(100, 432));
        inner.add(new NodeCoordinate(129, 440));
        inner.add(new NodeCoordinate(160, 429));
        inner.add(new NodeCoordinate(168, 439));
        inner.add(new NodeCoordinate(152, 418));
        inner.add(new NodeCoordinate(214, 408));
        inner.add(new NodeCoordinate(222, 434));
        inner.add(new NodeCoordinate(219, 426));
        inner.add(new NodeCoordinate(265, 410));
        inner.add(new NodeCoordinate(278, 424));

        continuousDraw(g, inner);
        inner.clear();

        inner.add(new NodeCoordinate(218, 415));
        inner.add(new NodeCoordinate(263, 391));
        inner.add(new NodeCoordinate(214, 408));
        inner.add(new NodeCoordinate(173, 389));
        inner.add(new NodeCoordinate(190, 396));
        inner.add(new NodeCoordinate(205, 349));
        inner.add(new NodeCoordinate(220, 388));
        inner.add(new NodeCoordinate(194, 386));
        inner.add(new NodeCoordinate(220, 388));
        inner.add(new NodeCoordinate(227, 354));
        inner.add(new NodeCoordinate(218, 406));

        continuousDraw(g, inner);
        inner.clear();

        inner.add(new NodeCoordinate(100, 434));
        inner.add(new NodeCoordinate(78, 415));
        inner.add(new NodeCoordinate(56, 454));
        inner.add(new NodeCoordinate(48, 450));
        inner.add(new NodeCoordinate(42, 444));
        inner.add(new NodeCoordinate(38, 437));
        inner.add(new NodeCoordinate(50, 420));

        continuousDraw(g, inner);
        inner.clear();

        bresenhamLine(g, 48, 450, 58, 445);
        bresenhamLine(g, 42, 444, 55, 438);
        bresenhamLine(g, 78, 450, 100, 434);
        bresenhamLine(g, 144, 414, 126, 397);
       bresenhamLine(g, 144, 414, 147, 415);
 
        inner.add(new NodeCoordinate(144, 414));
        inner.add(new NodeCoordinate(156, 419));
        inner.add(new NodeCoordinate(173, 388));
        inner.add(new NodeCoordinate(156, 377));

        continuousDraw(g, inner);
        inner.clear();

    }

    void drawWing(Graphics g){
        ArrayList<NodeCoordinate> inner = new ArrayList<>();

        g.setColor(Color.black);
        drawLeftWing(g, inner);
        drawRightWing(g, inner);
    }

    void drawLeftWing(Graphics g, ArrayList<NodeCoordinate> inner) {
        inner.add(new NodeCoordinate(250, 250));
        inner.add(new NodeCoordinate(260, 120));
        inner.add(new NodeCoordinate(300, 80));
        inner.add(new NodeCoordinate(400, 50));
        inner.add(new NodeCoordinate(400, 55));
        inner.add(new NodeCoordinate(305, 92));
        inner.add(new NodeCoordinate(275, 125));
        inner.add(new NodeCoordinate(272, 150));
        inner.add(new NodeCoordinate(325, 135));
        inner.add(new NodeCoordinate(390, 145));
        inner.add(new NodeCoordinate(388, 149));
        inner.add(new NodeCoordinate(325, 140));
        inner.add(new NodeCoordinate(275, 160));
        inner.add(new NodeCoordinate(275, 180));
        inner.add(new NodeCoordinate(310, 200));
        inner.add(new NodeCoordinate(350, 230));
        inner.add(new NodeCoordinate(348, 233));
        inner.add(new NodeCoordinate(310, 205));
        inner.add(new NodeCoordinate(275, 190));
        inner.add(new NodeCoordinate(274, 230));
        inner.add(new NodeCoordinate(290, 250));
        inner.add(new NodeCoordinate(270, 260));

        myPolygonDraw(g, inner);
        inner.clear();
        
        inner.add(new NodeCoordinate(400, 55));
        inner.add(new NodeCoordinate(390, 80));
        inner.add(new NodeCoordinate(275, 125));
        inner.add(new NodeCoordinate(385, 110));
        inner.add(new NodeCoordinate(390, 80));
        inner.add(new NodeCoordinate(385, 110));
        inner.add(new NodeCoordinate(390, 145));

        inner.add(new NodeCoordinate(388, 149));
        inner.add(new NodeCoordinate(380, 170));
        inner.add(new NodeCoordinate(275, 170));
        inner.add(new NodeCoordinate(360, 180));
        inner.add(new NodeCoordinate(380, 170));
        inner.add(new NodeCoordinate(360, 180));
        inner.add(new NodeCoordinate(350, 230));

        

        continuousDraw(g, inner);
        inner.clear();

        inner.add(new NodeCoordinate(290, 250));
        inner.add(new NodeCoordinate(320, 260));
        inner.add(new NodeCoordinate(275, 190));

        continuousDraw(g, inner);
        inner.clear();

        bresenhamLine(g, 320, 260, 350, 230);
    }

    void drawRightWing(Graphics g, ArrayList<NodeCoordinate> inner){
        inner.add(new NodeCoordinate(245, 200));
        inner.add(new NodeCoordinate(240, 120));
        inner.add(new NodeCoordinate(270, 90));
        inner.add(new NodeCoordinate(300, 80));

        continuousDraw(g, inner);
        inner.clear();

        inner.add(new NodeCoordinate(286, 93));
        inner.add(new NodeCoordinate(253, 125));
        inner.add(new NodeCoordinate(257, 160));

        continuousDraw(g, inner);
        inner.clear();
    }

    void drawHead(Graphics g) {
        drawCircle(g, 115, 222, 14);
        drawCircle(g, 115, 222, 10);
        drawCircle(g, 172, 224, 14);
        drawCircle(g, 172, 224, 10);
        ArrayList<NodeCoordinate> outer = new ArrayList<>();

        outer.add(new NodeCoordinate(82, 268));
        outer.add(new NodeCoordinate(89, 287));
        outer.add(new NodeCoordinate(105, 311));
        outer.add(new NodeCoordinate(134, 318));
        outer.add(new NodeCoordinate(150, 318));
        outer.add(new NodeCoordinate(187, 308));
        outer.add(new NodeCoordinate(201, 289));
        outer.add(new NodeCoordinate(208, 271));
        outer.add(new NodeCoordinate(212, 264));
        outer.add(new NodeCoordinate(211, 238));
        outer.add(new NodeCoordinate(207, 226));
        outer.add(new NodeCoordinate(211, 215));
        outer.add(new NodeCoordinate(220, 168));
        outer.add(new NodeCoordinate(216, 161));
        outer.add(new NodeCoordinate(203, 168));
        outer.add(new NodeCoordinate(181, 186));
        outer.add(new NodeCoordinate(181, 171));
        outer.add(new NodeCoordinate(187, 161));
        outer.add(new NodeCoordinate(195, 150));
        outer.add(new NodeCoordinate(193, 129));
        outer.add(new NodeCoordinate(185, 131));
        outer.add(new NodeCoordinate(185, 150));
        outer.add(new NodeCoordinate(182, 159));
        outer.add(new NodeCoordinate(174, 147));
        outer.add(new NodeCoordinate(172, 154));
        outer.add(new NodeCoordinate(171, 168));
        outer.add(new NodeCoordinate(162, 186));
        outer.add(new NodeCoordinate(126, 184));
        outer.add(new NodeCoordinate(119, 167));
        outer.add(new NodeCoordinate(121, 148));
        outer.add(new NodeCoordinate(119, 143));
        outer.add(new NodeCoordinate(111, 152));
        outer.add(new NodeCoordinate(108, 144));
        outer.add(new NodeCoordinate(109, 119));
        outer.add(new NodeCoordinate(102, 127));
        outer.add(new NodeCoordinate(101, 147));
        outer.add(new NodeCoordinate(106, 159));
        outer.add(new NodeCoordinate(100, 152));
        outer.add(new NodeCoordinate(90, 148));
        outer.add(new NodeCoordinate(86, 162));
        outer.add(new NodeCoordinate(87, 192));
        outer.add(new NodeCoordinate(79, 224));
        myPolygonDraw(g, outer);
        outer.clear();


        //horn        
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

        drawEars(g);
        //node mounth
        drawNoseAndMounth(g);
        drawChin(g, inner, outer);
    }

    void drawChin(Graphics g, ArrayList<NodeCoordinate> inner, ArrayList<NodeCoordinate> outer) {
                //chin
        g.setColor(new Color(98, 69, 61));

        outer.add(new NodeCoordinate(82, 266));
        outer.add(new NodeCoordinate(109, 300));
        outer.add(new NodeCoordinate(168, 304));
        outer.add(new NodeCoordinate(197, 289));
        outer.add(new NodeCoordinate(183, 247));
        outer.add(new NodeCoordinate(170, 250));
        outer.add(new NodeCoordinate(113, 250));
        outer.add(new NodeCoordinate(95, 244));

        myPolygonDraw(g, outer);
        outer.clear();

        inner.add(new NodeCoordinate(100, 204));
        inner.add(new NodeCoordinate(99, 233));
        inner.add(new NodeCoordinate(81, 245));
        inner.add(new NodeCoordinate(95, 244));
        inner.add(new NodeCoordinate(110, 270));
        inner.add(new NodeCoordinate(180, 272));
        inner.add(new NodeCoordinate(210, 268));
        inner.add(new NodeCoordinate(180, 272));
        inner.add(new NodeCoordinate(170, 285));
        inner.add(new NodeCoordinate(120, 284));
        inner.add(new NodeCoordinate(110, 270));
        continuousDraw(g, inner);
        inner.clear();

        inner.add(new NodeCoordinate(95, 244));
        inner.add(new NodeCoordinate(109, 303));
        inner.add(new NodeCoordinate(120, 284));
        inner.add(new NodeCoordinate(130, 270));
        inner.add(new NodeCoordinate(160, 271));
        inner.add(new NodeCoordinate(170, 285));
        inner.add(new NodeCoordinate(168, 304));

        continuousDraw(g, inner);
        inner.clear();

        inner.add(new NodeCoordinate(195, 243));
        inner.add(new NodeCoordinate(183, 247));
        inner.add(new NodeCoordinate(180, 272));
        inner.add(new NodeCoordinate(168, 304));
        inner.add(new NodeCoordinate(140, 284));
        inner.add(new NodeCoordinate(140, 302));
        inner.add(new NodeCoordinate(120, 284));
        
        continuousDraw(g, inner);
        inner.clear();

    }

    void drawEars(Graphics g){
        
        ArrayList<NodeCoordinate> inner = new ArrayList<>();
        g.setColor(new Color(126, 94, 95));

        //left ear
        inner.add(new NodeCoordinate(113, 200));
        inner.add(new NodeCoordinate(92, 206));
        inner.add(new NodeCoordinate(91, 189));
        inner.add(new NodeCoordinate(90, 163));
        inner.add(new NodeCoordinate(92, 150));
        inner.add(new NodeCoordinate(104, 168));
        inner.add(new NodeCoordinate(106, 159));
        inner.add(new NodeCoordinate(104, 168));
        inner.add(new NodeCoordinate(94, 180));
        inner.add(new NodeCoordinate(101, 192));
        inner.add(new NodeCoordinate(92, 206));
        inner.add(new NodeCoordinate(84, 206));
        
        continuousDraw(g, inner);
        inner.clear();

        //Rignt ear
        inner.add(new NodeCoordinate(181, 186));
        inner.add(new NodeCoordinate(189, 192));
        inner.add(new NodeCoordinate(207, 166));
        inner.add(new NodeCoordinate(209, 183));
        inner.add(new NodeCoordinate(200, 193));
        inner.add(new NodeCoordinate(205, 200));
        inner.add(new NodeCoordinate(195, 210));
        inner.add(new NodeCoordinate(207, 230));
        inner.add(new NodeCoordinate(190, 225));
        inner.add(new NodeCoordinate(195, 210));
        inner.add(new NodeCoordinate(189, 192));
        inner.add(new NodeCoordinate(181, 211));
        inner.add(new NodeCoordinate(195, 243));
        inner.add(new NodeCoordinate(212, 250));
        
        continuousDraw(g, inner);
        inner.clear();

    }

    void drawNoseAndMounth(Graphics g) {

        ArrayList<NodeCoordinate> inner = new ArrayList<>();
        Polygon nose = new Polygon();
        nose.addPoint(128, 241);
        nose.addPoint(154, 243);
        nose.addPoint(143, 227);
        g.drawPolygon(nose);

        nose = new Polygon();
        nose.addPoint(128, 241);
        nose.addPoint(154, 243);
        nose.addPoint(142, 246);
        g.drawPolygon(nose);

        g.setColor(Color.black);
        inner.add(new NodeCoordinate(142,246));
        inner.add(new NodeCoordinate(141, 255));
        bezierCurve(g, 141, 255, 139, 258, 130, 256, 120,255);
        bezierCurve(g, 141, 255, 143, 259, 152, 258, 162,256);
        continuousDraw(g, inner);
        inner.clear();
    }

    void paintHead(BufferedImage bf){


        Color baseColor = new Color(200, 152, 87);
        floodFill(bf, 117, 220, baseColor, Color.BLACK);
        floodFill(bf, 175, 227, baseColor, Color.BLACK);
        floodFill(bf, 125, 222, baseColor, Color.WHITE);
        floodFill(bf, 160, 224, baseColor, Color.WHITE);

        //horn
        floodFill(bf, 178, 168, baseColor, new Color(235, 218, 70));
        floodFill(bf, 172, 184, baseColor, new Color(242, 115, 64));
        floodFill(bf, 105, 143, baseColor, new Color(235, 218, 70));
        floodFill(bf, 121, 189, baseColor, new Color(242, 115, 64));

        // headpat
        floodFill(bf, 145, 186, baseColor, new Color(220, 180, 185));

        //ears
        floodFill(bf, 101, 176, baseColor, new Color(144, 110, 113));
        floodFill(bf, 86, 198, baseColor, new Color(112, 74, 81));
        floodFill(bf, 102, 160, baseColor, new Color(112, 74, 81));
        floodFill(bf, 95, 171, baseColor, new Color(130, 88, 95));
        floodFill(bf, 189, 191, baseColor, new Color(112, 74, 81));
        floodFill(bf, 213, 191, baseColor, new Color(144, 110, 113));
        floodFill(bf, 200, 185, baseColor, new Color(148, 120, 105));
        floodFill(bf, 190, 208, baseColor, new Color(33, 18, 44));
        floodFill(bf, 199, 221, baseColor, new Color(55, 40, 60));
        floodFill(bf, 180, 190, baseColor, new Color(55, 40, 60));

        //face
                
        floodFill(bf, 110, 235, baseColor, new Color(220, 160, 165));        
        floodFill(bf, 89, 234, baseColor, new Color(200, 160, 165));
        floodFill(bf, 85, 251, baseColor, new Color(157, 124, 115));
        floodFill(bf, 89, 263, baseColor, new Color(137, 104, 95));
        floodFill(bf, 110, 281, baseColor, new Color(145, 110, 100));
        floodFill(bf, 154, 300, baseColor, new Color(120, 90, 100));
        floodFill(bf, 173, 300, baseColor, new Color(110, 75, 81));
        floodFill(bf, 195, 280, baseColor, new Color(160, 130, 135));
        floodFill(bf, 154, 270, baseColor, new Color(175, 150, 142));
        floodFill(bf, 142, 281, baseColor, new Color(155, 130, 122));
        floodFill(bf, 120, 281, baseColor, new Color(150, 125, 115));
        floodFill(bf, 170, 281, baseColor, new Color(120, 95, 95));
        floodFill(bf, 150, 290, baseColor, new Color(116, 88, 79));
        floodFill(bf, 175, 285, baseColor, new Color(110, 75, 81));
        floodFill(bf, 128, 290, baseColor, new Color(120, 90, 100));
        floodFill(bf, 114, 300, baseColor, new Color(120, 90, 100));
        floodFill(bf, 187, 268, baseColor, new Color(110, 75, 81));
        floodFill(bf, 187, 250, baseColor, new Color(150, 120, 120));
    

    }

    void paintSep(Graphics g2) {
        // bresenhamLine(g2, 300, 0, 300, 120);
        // bresenhamLine(g2, 300, 120, 310, 110);
        // bresenhamLine(g2, 310, 110, 360, 80);
        // bresenhamLine(g2, 360, 80, 380, 75);
        // bresenhamLine(g2, 380, 75, 370, 90);
        // bresenhamLine(g2, 370, 90, 410, 80);
        // bresenhamLine(g2, 410, 80, 395, 110);
        // bresenhamLine(g2, 395, 110, 390, 130);
        // bresenhamLine(g2, 390, 130, 395, 135);
        // bresenhamLine(g2, 395, 135, 380, 150);
        // bresenhamLine(g2, 380, 150, 375, 200);
        // bresenhamLine(g2, 375, 200, 380, 220);
        // bresenhamLine(g2, 380, 220, 360, 218);
        bresenhamLine(g2, 360, 218, 320, 260);
        bresenhamLine(g2, 320, 260, 300, 377);
        bresenhamLine(g2, 300, 377, 240, 360);
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
    
    void drawCircle(Graphics g, int cenx, int ceny, int rad){
        if (rad % 2 > 0){
            System.out.println("Error in this case rad must be even!");
            return;
        } 
        //ceny = ceny-25;
        bezierCurve(g, cenx - rad, ceny, cenx - rad, ceny - rad / 2, cenx - rad / 2, ceny - rad, cenx, ceny - rad);
        bezierCurve(g, cenx, ceny - rad, cenx + rad / 2, ceny - rad, cenx + rad, ceny - rad / 2, cenx + rad, ceny);
        bezierCurve(g, cenx + rad, ceny, cenx + rad, ceny + rad / 2, cenx + rad / 2, ceny + rad, cenx, ceny + rad);
        bezierCurve(g, cenx, ceny + rad, cenx - rad / 2, ceny + rad, cenx - rad, ceny + rad / 2, cenx - rad, ceny);

        // bezierCurve(g, cenx - rad, ceny, cenx - rad, ceny - rad / 2, cenx - rad / 2, ceny - rad, cenx, ceny - rad);
        // bezierCurve(g, cenx, ceny - rad, cenx + rad / 2, ceny - rad, cenx + rad, ceny - rad / 2, cenx + rad, ceny);
        // bezierCurve(g, cenx + rad, ceny, cenx + rad, ceny + rad / 2, cenx + rad / 2, ceny + rad, cenx, ceny + rad);
        // bezierCurve(g, cenx, ceny + rad, cenx - rad / 2, ceny + rad, cenx - rad, ceny + rad / 2, cenx - rad, ceny);
        
        
    }
    void drawBodyBack(Graphics g){
        //blackTriangle
        bresenhamLine(g,388,240,340,274);
        bresenhamLine(g,388,240,350,230);
        bresenhamLine(g,340,274,314,326);
        //bresenhamLine(g,314,326,300,387);
        bresenhamLine(g,314,326,317, 396);
        //bresenhamLine(g,300,387,265,268);
        //bresenhamLine(g,265,268, 243,243);
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

        //MiddleLittleTriangle.
        bresenhamLine(g,388,333,355,364);
        bresenhamLine(g,355,364,396,362);

        //MiddleSmallpentagon.
        bresenhamLine(g,355,364,345,390);
        bresenhamLine(g,345,390,345,413);
        bresenhamLine(g,345,413,354,440);

        //tinytriTail.
        bresenhamLine(g,345,413,332,436);

        //GraybesideWhitepentagon******Dubug
        //bresenhamLine(g,300,387,329,389);
        bresenhamLine(g,329,389,317, 396);
        bresenhamLine(g,329,389,345,390);

        //superTinyUndertinyTri.
        bresenhamLine(g,329,389,355,364);

        //tinyPigchin.
        bresenhamLine(g,379,324,364,350);

        //tinyMiddleTriangle.
        bresenhamLine(g,372,348,345,354);
        bresenhamLine(g,345,354,346,374);

        //WhitePentagon.
        bresenhamLine(g,314,326,345,354);

        //underBlackMiddle ******************
        //bresenhamLine(g,300,387,316,406);
        bresenhamLine(g,316,406,329,389);

        //catPentagonStomach*********** fit20
        //bresenhamLine(g,316,406,298,423);
        bresenhamLine(g,316,406,315, 425);
        bresenhamLine(g,314,406,317, 396);
        //bresenhamLine(g,314,436,298,423);
        bresenhamLine(g,314,436,315, 425);

        //.
        bresenhamLine(g,314,436,318,452);
        bresenhamLine(g,314,436,332,436);

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
        bresenhamLine(g, 404, 229, 350,230);
        
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
     void paintBackBody(BufferedImage bf){
        Color baseColor = new Color(200,152,87);
        floodFill(bf, 340,275 , baseColor, Color.gray);
        floodFill(bf, 385, 241, baseColor, Color.BLACK);
     }

// 
//     void paintSep(Graphics g2) {
//         bresenhamLineSep(g2, 300, 0, 300, 120);
//         bresenhamLineSep(g2, 300, 120, 310, 110);
//         bresenhamLineSep(g2, 310, 110, 360, 80);
//         bresenhamLineSep(g2, 360, 80, 380, 75);
//         bresenhamLineSep(g2, 380, 75, 370, 90);
//         bresenhamLineSep(g2, 370, 90, 410, 80);
//         bresenhamLineSep(g2, 410, 80, 395, 110);
//         bresenhamLineSep(g2, 395, 110, 390, 130);
//         bresenhamLineSep(g2, 390, 130, 395, 135);
//         bresenhamLineSep(g2, 395, 135, 380, 150);
//         bresenhamLineSep(g2, 380, 150, 375, 200);
//         bresenhamLineSep(g2, 375, 200, 380, 220);
//         bresenhamLineSep(g2, 380, 220, 360, 218);
//         bresenhamLineSep(g2, 360, 218, 320, 260);
//         bresenhamLineSep(g2, 320, 260, 280, 350);
//         bresenhamLineSep(g2, 280, 350, 240, 360);
//         bresenhamLineSep(g2, 240, 360, 275, 380);
//         bresenhamLineSep(g2, 275, 380, 290, 400);
//         bresenhamLineSep(g2, 290, 400, 290, 430);
//         bresenhamLineSep(g2, 290, 430, 270, 450);
//         bresenhamLineSep(g2, 270, 450, 230, 500);
//         bresenhamLineSep(g2, 230, 500, 210, 505);
//         bresenhamLineSep(g2, 210, 505, 220, 512);
//         bresenhamLineSep(g2, 220, 512, 205, 520);
//         bresenhamLineSep(g2, 205, 520, 210, 528);
//         bresenhamLineSep(g2, 210, 528, 210, 600);
//     }

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

    <T> boolean checkArrContains(T[] arr, T target){
        if (arr.length == 0) return false;
        for (T t : arr) {
            if (t == null) continue;
            if (t.equals(target)) return true; 
        }

        return false;
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