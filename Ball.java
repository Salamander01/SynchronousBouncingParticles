import java.awt.*;
import java.math.BigDecimal;

class Ball {
    private final int radius;
    private final int diameter;

    private BigDecimal x;
    private BigDecimal y;

    private BigDecimal dx;
    private BigDecimal dy;

    private Color color;


    public Ball(int radius, BigDecimal startX, BigDecimal startY, BigDecimal dx, BigDecimal dy, Color color) {
        this.radius = radius;
        this.diameter = radius * 2;
        this.x = startX;
        this.y = startY;
        this.dx = dx;
        this.dy = dy;
        this.color = color;
    }

    protected void step(int width, int height) {
        IncrementColor();

//        if (Main.DEBUG) printStuff();

        x = x.add(dx);
        y = y.add(dy);

        if (x.subtract(new BigDecimal(radius)).compareTo(new BigDecimal(0)) < 0) {
            if (Main.DEBUG) {
                System.out.print("x - radius : " + x.subtract(new BigDecimal(radius)) + " | ");
                printStuff();
            }
            dx = dx.negate();
            x = new BigDecimal(radius);
            Ball.playSound();
        } else if (x.add(new BigDecimal(radius)).compareTo(new BigDecimal(width)) > 0) {
            if (Main.DEBUG) {
                System.out.print("x + radius : " + x.add(new BigDecimal(radius)) + " | ");
                printStuff();
            }
            dx = dx.negate();
            x = new BigDecimal(width - radius);
            Ball.playSound();
        }

        if (y.subtract(new BigDecimal(radius)).compareTo(new BigDecimal(0)) < 0) {
            if (Main.DEBUG) {
                System.out.print("y - radius : " + y.subtract(new BigDecimal(radius)) + " | ");
                printStuff();
            }
            dy = dy.negate();
            y = new BigDecimal(radius);
            Ball.playSound();
        } else if (y.add(new BigDecimal(radius)).compareTo(new BigDecimal(height)) > 0) {
            if (Main.DEBUG) {
                System.out.print("y + radius : " + y.add(new BigDecimal(radius)) + " | ");
                printStuff();
            }
            dy = dy.negate();
            y = new BigDecimal(height - radius);
            Ball.playSound();
        }

    }

    private void printStuff() {
        System.out.println("dx: " + dx + " | dy: " + dy + " | x: " + x + " | y: " + y);
    }

    protected Color getColor() {
        return this.color;
    }

    protected double getX() {
        return this.x.doubleValue();
    }

    protected double getY() {
        return this.y.doubleValue();
    }

    protected float getRadius() {
        return this.radius;
    }

    protected float getDiameter() {
        return this.diameter;
    }

    protected void IncrementColor() {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();

        if (r == 255 && g < 255 && b == 0) {
            g++;
        } else if (r > 0 && g == 255 && b == 0) {
            r--;
        } else if (r == 0 && g == 255 && b < 255) {
            b++;
        } else if (r == 0 && g > 0 && b == 255) {
            g--;
        } else if (r < 255 && g == 0 && b == 255) {
            r++;
        } else if (r == 255 && g == 0 && b > 0) {
            b--;
        }

        color = new Color(r, g, b);
    }

    private static void playSound() {
        // TODO
    }

}
