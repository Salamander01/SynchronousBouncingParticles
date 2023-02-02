import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;

class Ball {
    private final float radius;
    private final float diameter;

    private float x;
    private float y;

    private float dx;
    private float dy;

    private Color color;


    public Ball(float radius, float startX, float startY, float dx, float dy, Color color) {
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

        x = x + dx;
        y = y + dy;

        if (x - radius < 0) {
            dx = -dx;
            x = radius;
            Ball.playSound();
        } else if (x + radius > width) {
            dx = -dx;
            x = width - radius;
            Ball.playSound();
        }

        if (y - radius < 0) {
            dy = -dy;
            y = radius;
            Ball.playSound();
        } else if (y + radius > height) {
            dy = -dy;
            y = height - radius;
            Ball.playSound();
        }
    }

    protected Color getColor() {
        return this.color;
    }

    protected float getX() {
        return this.x;
    }

    protected float getY() {
        return this.y;
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
