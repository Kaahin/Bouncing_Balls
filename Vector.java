
public class Vector {
    double x;
    double y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;

    }

    public String toString() {
        return "< " + this.x + " , " + this.y + " >";
    }

    public Vector add(Vector v) {
        double a = this.x + v.x;
        double b = this.y + v.y;
        return new Vector(a, b);
    }

    public Vector sub(Vector v) {
        double a = this.x - v.x;
        double b = this.y - v.y;
        return new Vector(a, b);
    }

    public double dot(Vector v) {
        double a = this.x * v.x;
        double b = this.y * v.y;
        return a + b;
    }

    public Vector scale(double d) {
        double a = this.x * d;
        double b = this.y * d;
        return new Vector(a, b);
    }

    public double dist(Vector v) {
        double a = this.x - v.x;
        double b = this.y - v.y;
        return Math.sqrt(a * a + b * b);
    }

    public double length() {
        double a = this.x;
        double b = this.y;
        return Math.sqrt(a * a + b * b);
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public Vector flipSignX() {
        double a = -1 * this.x;
        double b = this.y;
        return new Vector(a, b);
    }

    public Vector flipSignY() {
        double a = this.x;
        double b = -1 * this.y;
        return new Vector(a, b);
    }

    public static Vector randomVector(double len) {
        double a = Math.round(Math.random());
        double b = Math.round(Math.random());
        double c;
        double d;
        if (a == 0) {
            c = -1 * len;
        } else {
            c = 1 * len;
        }
        if (b == 0) {
            d = -1 * len;
        } else {
            d = 1 * len;
        }
        return new Vector(c, d);
    }

    public double angle() {
        double a = this.x;
        double b = this.y;
        return Math.atan2(b, a);
    }

    public static Vector polar(double length, double angle) {
        return new Vector(length, angle);
    }

    public static void main(String[] args) {

        // Constructor method
        Vector vec1 = new Vector(10.00, 20.00);
        System.out.println("Vector V1 contents: " + vec1.toString());
        Vector vec2 = new Vector(5.00, 10.00);
        System.out.println("Vector V2 contents: " + vec2.toString());
        // Add method
        Vector vec3 = vec1.add(vec2);
        System.out.println("Vector V3 contents after add: " + vec3.toString());
        // Sub method
        Vector vec4 = vec1.sub(vec2);
        System.out.println("Vector V4 contents after sub: " + vec4.toString());
        // Dot method
        double res1 = vec1.dot(vec2);
        System.out.println("Dot product of V1 and V2: " + res1);
        // Scalar product method
        Vector vec5 = vec1.scale(10);
        System.out.println("Scale V1 with magnitude of 10 : " + vec5.toString());
        // Distance method
        double res2 = vec1.dist(vec2);
        System.out.println("Distance between V1 and V2: " + res2);
        // Length method
        double res3 = vec1.length();
        System.out.println("Length of V1: " + res3);
        // Get (X/Y) method
        double resX = vec1.getX();
        System.out.println("V1 x-value: " + resX);
        double resY = vec1.getY();
        System.out.println("V1 y-value: " + resY);
        // Flipped Sign of (X/Y) property methods
        Vector vecFX = vec1.flipSignX();
        System.out.println("V1 with flipped x-value: " + vecFX.x);
        Vector vecFY = vec1.flipSignY();
        System.out.println("V1 with flipped y-value: " + vecFY.y);
        // Random Vector method
        Vector vecRandom = randomVector(10);
        System.out
                .println("Vector with length 10 in random directions: " + vecRandom.toString());
        // Angle method
        double theta = vec1.angle();
        System.out.println("Angle of V1: " + theta);
        // Polar method
        Vector vecPolar = polar(10, Math.PI);
        System.out.println("Vector using polar coord: " + vecPolar.toString());

    }
}