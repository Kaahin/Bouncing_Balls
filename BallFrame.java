import javax.swing.*;
import java.awt.event.*;

public class BallFrame extends JFrame implements ActionListener {

    Box box;
    Timer timer;
    int displacement = 0;

    public BallFrame(int nr, int width, int height, int delay, double vx, double vy, double r) {
        box = new Box(nr, width, height, vx, vy, r);
        timer = new Timer(delay, this);

        add(box);
        pack();
        setLocation(300 + displacement, 100 + displacement);
        displacement += 10;
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        box.step();
    }
 
    public static void main(String[] args) {
        new BallFrame(3, 800, 500, 20, 10, -30, 10);
    }
}
