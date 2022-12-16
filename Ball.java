import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.io.File;

class Ball {
    private float radius;
    private float diameter;

    private float x;
    private float y;

    private float dx;
    private float dy;

    private Color color = Color.RED;

    public Ball() {
        this.radius = 40;
        this.diameter = this.radius * 2;

        this.x = radius + 50;
        this.y = radius + 20;

        this.dx = 3;
        this.dy = 3;
    }

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
            playSound();
        } else if (x + radius > width) {
            dx = -dx;
            x = width - radius;
            playSound();
        }

        if (y - radius < 0) {
            dy = -dy;
            y = radius;
            playSound();
        } else if (y + radius > height) {
            dy = -dy;
            y = height - radius;
            playSound();
        }
    }

    private static void playSound() {
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("QKTA234-pop.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected  Color getColor() {
        return color;
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
}
