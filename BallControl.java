import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.*;

import java.util.Scanner;

public class BallControl extends JFrame implements ActionListener {

    JLabel heightLabel = new JLabel("Window height  ");
    JTextField heightField = new JTextField();
    JLabel widthLabel = new JLabel("Window width  ");
    JTextField widthField = new JTextField();
    JLabel nrLabel = new JLabel("Nr of circles  ");
    JTextField nrField = new JTextField();
    JLabel delayLabel = new JLabel("Delay  ");
    JTextField delayField = new JTextField();

    JButton startButton = new JButton("Start");
    JButton exitButton = new JButton("Quit");
    JButton runButton = new JButton("Run");
    JButton stopButton = new JButton("Stop");
    BallFrame bf = null;

    public BallControl() {
        super("Control Panel");

        JPanel inputPart = new JPanel(new GridLayout(4, 2));
        inputPart.add(heightLabel);
        inputPart.add(heightField);
        inputPart.add(widthLabel);
        inputPart.add(widthField);
        inputPart.add(nrLabel);
        inputPart.add(nrField);
        inputPart.add(delayLabel);
        inputPart.add(delayField);

        JPanel clickPart = new JPanel(new GridLayout(2, 2));
        startButton.addActionListener(this);
        clickPart.add(startButton);
        exitButton.addActionListener(this);
        clickPart.add(exitButton);
        runButton.addActionListener(this);
        clickPart.add(runButton);
        stopButton.addActionListener(this);
        clickPart.add(stopButton);

        this.setLayout(new FlowLayout());
        this.add(inputPart);
        this.add(clickPart);
        this.setPreferredSize(new Dimension(300, 300));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        Scanner scWidth = new Scanner(widthField.getText());
        Scanner scHeight = new Scanner(heightField.getText());
        Scanner scNr = new Scanner(nrField.getText());
        Scanner scDelay = new Scanner(delayField.getText());

        int w = 0;
        if (scWidth.hasNextInt()) {
            w = scWidth.nextInt();
        }

        int h = 0;
        if (scHeight.hasNextInt()) {
            h = scHeight.nextInt();
        }

        int n = 0;
        if (scNr.hasNextInt()) {
            n = scNr.nextInt();
        }

        int d = 0;
        if (scDelay.hasNextInt()) {
            d = scDelay.nextInt();
        }

        if (e.getSource() == startButton) {
            if (bf == null) {
                bf = new BallFrame(n, w, h, d, 10, -30, 10);
            } else {
                JOptionPane.showMessageDialog(null, "Already started");
            }
        }
        if (e.getSource() == exitButton && bf != null) {
            int val = JOptionPane.showOptionDialog(null, "Program will be terminated", "",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
            if (val == 0) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        new BallControl();
    }

}
