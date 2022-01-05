
/**
 * Ball
 */

import java.awt.Color;
import java.awt.Graphics;

public class Ball {

    Vector p;
    Vector v;
    double r;
    Color c;
    Box f;

    public Ball(Box f, double x, double y, double vx, double vy, double r) {
        this.f = f;
        this.p = new Vector(x, y);
        this.v = new Vector(vx, vy);
        this.r = r;
        c = new Color(
                (float) Math.random(),
                (float) Math.random(),
                (float) Math.random());
    }

    public void move() {
        p.x += v.getX();
        p.y += v.getY();

        // Stays on the floor
        if (p.y > f.getHeight()) {
            p.y = f.getHeight();
        }
        p.y++;

        // Collision with the floor
        if (p.y > f.getHeight() - r && v.getY() > 0) {
            v = v.flipSignY();
            v.y = v.getY() + 2;
        }

        // Collision with the roof
        if (p.getY() < r && v.getY() < 0) {
            v = v.flipSignY();
        }

        // Collison with walls
        if (p.getX() < r && v.getX() < 0 || p.getX() > f.getWidth() - r && v.getX() > 0) {
            v = v.flipSignX();
        }

    }

    public void collide(Ball b) {
        if (this.p.dist(b.p) < 2 * r) {
            
            Vector vI = this.v;
            Vector vJ = b.v;

            // Vector pI = this.p;
            // Vector pJ = b.p;

            // Vector dVJI = vJ.sub(vI);
            // Vector dVIJ = vI.sub(vJ);
            // Vector dPos = pJ.sub(pI);

            // double numJI = dVJI.dot(dPos);
            // double numIJ = dVIJ.dot(dPos);
            // double den = pJ.dist(pI) * pJ.dist(pI);

            // double ratJI = numJI / den;
            // double ratIJ = numIJ / den;

            // Vector vCompJI = dPos.scale(ratJI);
            // Vector vCompIJ = dPos.scale(ratIJ);

            // this.v = vI.add(vCompJI);
            // b.v = vJ.add(vCompIJ);

            this.v = vI.flipSignX().flipSignY();
            b.v = vJ.flipSignX().flipSignY();

        }
    }

    public void paint(Graphics g) {
        g.setColor(c);
        g.fillOval((int) Math.round(p.getX() - r), (int) Math.round(p.getY() - r),
                (int) Math.round(2 * r), (int) Math.round(2 * r));
    }

}
