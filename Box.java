import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

/**
 * myFrame
 */

public class Box extends JPanel {

    ArrayList<Ball> bList;

    public Box(int nr, int width, int height, double vx, double vy, double r) {
        bList = new ArrayList<>();
        for (int i = 0; i < nr; i++) {
            bList.add(
                    new Ball(this, Math.round(width * Math.random()), Math.round(height * Math.random()), vx, vy, r));
        }

        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.white);
        this.setBorder(new LineBorder(Color.black, 2));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball b : bList) {
            b.paint(g);
        }
    }

    public void step() {
        for (Ball b : bList) {
            b.move();
        }

        for (int j = 0; j < bList.size() - 1; j++) {
            for (int i = j + 1; i < bList.size(); i++) {
                bList.get(j).collide(bList.get(i));
            }
        }

        repaint();
    }

}