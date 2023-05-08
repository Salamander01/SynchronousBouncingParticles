
import java.awt.*;
import java.math.BigDecimal;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.round;

public class Main {

    /*
    Strings: Not exactly used in this project.
        Some concatenation examples are on line 48 in this file and lines 60 and 61.
    Variables names:
        Lines 7-16 in Particle.java has some good examples.
    Functions/Methods:
        Line 31 in MainAnimation.java is a good example. There are more examples in Particle.java
    Loops:
        The only while loop is on line 45 of this file, and it is used as a sort of wait to prevent the program from going on before some initialization is done.
        There is a nested standard for loop on line 65 and 66 of this file that creates all the particles and the color gradient.
        There is a good example of a foreach loop on line 41 of MainAnimation.java
    Conditionals:
        Lines 47 and 82 in Particle.java are some good examples.
    User Input: Not included in this program.
    Produce output to the console: Only happens when DEBUG is set to true. Look at lines 48, 60, and 61 in this file for some examples.
        There are more examples in the other classes.
    List/Array/Vector:
        Line 8 of MainAnimation is an ArrayList of all the Particles; used to iterate over all the Particles in foreach loops.
    Class/Objects:
        The best overall example is probably Particle.java, although MainAnimation.java does include a bit of inheritance.
     */

    // Constants
    final static boolean DEBUG = false;
    final static double SPEED_MULTIPLIER = 0.06;
    final static int BALL_RADIUS = 10;

    public static void main(String[] args) {
        // Instantiate the MainAnimation to create the window
        MainAnimation animation = new MainAnimation();

        // Wait until the windows width and height actually have values (otherwise following code break)
        while (animation.getHeight() < 200 && animation.getWidth() < 200);

        // Debug print
        if (DEBUG) System.out.println(animation.getWidth() + " x " + animation.getHeight());

        // Supposed to set the panel size to the max possible size that maintains a certain ration between the width and height
        // (not really sure if it actually works, but I don't want to try to revert it to how it was)
        animation.setSize(animation.getWidth() - ((animation.getWidth() - (2 * BALL_RADIUS)) % 40), animation.getHeight() - ((animation.getHeight() - (2 * BALL_RADIUS)) % 40));

        // Sets the width and height of the number of particles that go bouncing around the screen dependent on the size of the window
        int width = (int) round((animation.getWidth() - (2 * BALL_RADIUS)) / 40.0);
        int height = (int) round((animation.getHeight() - (2 * BALL_RADIUS)) / 40.0);

        // Debug printing
        if (DEBUG) {
            System.out.println(width + " x " + height);
            System.out.println(animation.getWidth() + " x " + animation.getHeight());
        }

        // Creates the particles (nested for loops for x and y axis)
        for (int i = 1; i <= width; i++) {
            for (int j = 1; j <= height; j++) {
                // Code for creating the color gradient along the x-axis along with the ability to scale with the width of the particle grid
                Color color = new Color(i * (255 / width), 0, 255);
                // Create the particles
                animation.addParticle(BALL_RADIUS, new BigDecimal(i).multiply(new BigDecimal(SPEED_MULTIPLIER)), new BigDecimal(j).multiply(new BigDecimal(SPEED_MULTIPLIER)), color);
            }
        }

        // Create a thread that will update the particles positions and redraw the screen every 20 milliseconds by calling animation.drawFrame()
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(animation::drawFrame, 5, 20, TimeUnit.MILLISECONDS);
    }
}
