package BouncingBalls;

import java.awt.*;
import java.math.BigDecimal;

class Particle {

    // Attributes
    private final int radius;
    private final int diameter;

    private BigDecimal x;
    private BigDecimal y;

    private BigDecimal dx;
    private BigDecimal dy;

    private Color color;


    // New particle constructor
    public Particle(int radius, BigDecimal startX, BigDecimal startY, BigDecimal dx, BigDecimal dy, Color color) {
        this.radius = radius;
        this.diameter = radius * 2;
        this.x = startX;
        this.y = startY;
        this.dx = dx;
        this.dy = dy;
        this.color = color;
    }

    private static void playSound() {
        // TODO create system for playing sound
        // Broke because numerous particles would collide with the wall at the same time, causing the sound to be played over itself,
        // meaning that some sort of system needs to be made that can check if the sound has been played recently before playing it again.
        // Probably would need to be threaded.
    }

    protected void step(int width, int height) {
        // Increment the color
        IncrementColor();

        // Increment the position by the delta x and delta y values (speed values)
        x = x.add(dx);
        y = y.add(dy);

        // If (x - radius) < 0   ;   for when the particle hits the left side of the screen
        if (x.subtract(new BigDecimal(radius)).compareTo(new BigDecimal(0)) < 0) {

            // Debug printing
            if (Main.DEBUG) {
                System.out.print("x - radius : " + x.subtract(new BigDecimal(radius)) + " | ");
                debugPrintMethod();
            }

            // Reverse the direction of motion
            dx = dx.negate();

            // Set the position so the particle is not completely or partially off the screen
            x = new BigDecimal(radius);

            Particle.playSound();

            // if (x + radius) > width   ;   for when the particle hits the right side of the screen
        } else if (x.add(new BigDecimal(radius)).compareTo(new BigDecimal(width)) > 0) {

            // Debug printing
            if (Main.DEBUG) {
                System.out.print("x + radius : " + x.add(new BigDecimal(radius)) + " | ");
                debugPrintMethod();
            }

            // Reverse the direction of motion
            dx = dx.negate();

            // Set the position so the particle is not completely or partially off the screen
            x = new BigDecimal(width - radius);

            Particle.playSound();
        }

        // if (y - radius) < 0   ;   for when the particle hits the top of the screen
        if (y.subtract(new BigDecimal(radius)).compareTo(new BigDecimal(0)) < 0) {

            // Debug printing
            if (Main.DEBUG) {
                System.out.print("y - radius : " + y.subtract(new BigDecimal(radius)) + " | ");
                debugPrintMethod();
            }

            // Reverse the direction of motion
            dy = dy.negate();

            // Set the position so the particle is not completely or partially off the screen
            y = new BigDecimal(radius);

            Particle.playSound();

            // if (y + radius) > height   ;   for when the particle hits the bottom of the screen
        } else if (y.add(new BigDecimal(radius)).compareTo(new BigDecimal(height)) > 0) {

            // Debug printing
            if (Main.DEBUG) {
                System.out.print("y + radius : " + y.add(new BigDecimal(radius)) + " | ");
                debugPrintMethod();
            }

            // Reverse the direction of motion
            dy = dy.negate();

            // Set the position so the particle is not completely or partially off the screen
            y = new BigDecimal(height - radius);

            Particle.playSound();
        }

    }


    private void debugPrintMethod() {
        System.out.println("dx: " + dx + " | dy: " + dy + " | x: " + x + " | y: " + y);
    }

    // Getters

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

    // Messy method that steps the particles color along a gradient
    protected void IncrementColor() {
        int r = this.color.getRed();
        int g = this.color.getGreen();
        int b = this.color.getBlue();

        // Can't really comment this because I don't really know how it works all that well.
        // This code is mostly from Brandon.
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

        this.color = new Color(r, g, b);
    }

}
