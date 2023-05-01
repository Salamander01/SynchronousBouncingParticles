
import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class MainAnimation extends JPanel {
    private final ArrayList<Particle> particles;


    // Initialize the JPanel and the JFrame that it goes in
    public MainAnimation() {
        super();

        // Initialize attributes
        this.particles = new ArrayList<>();

        setBackground(Color.BLACK);

        // Create and initialize the JFrame
        JFrame frame = new JFrame("Main Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(true);

        frame.setContentPane(this);

        frame.setVisible(true);
    }

    public synchronized void drawFrame() {
        // Get the width and the height for collision checking
        int width = getWidth();
        int height = getHeight();

        // Debug print
        if (Main.DEBUG) System.out.println("Width: " + width + " : " + "Height: " + height);

        // For each particle call the particle.update() method to update and progress the animation.
        for (Particle particle : particles) {
            particle.update(width, height);
        }

        // Debug print
        if (Main.DEBUG) System.out.println("\nBREAK!!");

        // Redraw the screen
        repaint();
    }

    // Overridden method that draws the particles onto the JPanel
    public synchronized void paintComponent(Graphics g) {
        super.paintComponent(g);

        // For each particle, set its color and draw it
        for (Particle particle : particles) {
            g.setColor(particle.getColor());
            g.fillOval((int) (particle.getX() - particle.getRadius()), (int) (particle.getY() - particle.getRadius()), (int) particle.getDiameter(), (int) particle.getDiameter());
        }
    }

    // Method for adding new particles to the animation from other scopes
    public void addParticle(int radius, BigDecimal dx, BigDecimal dy, Color color) {
        this.particles.add(new Particle(radius, new BigDecimal(radius), new BigDecimal(radius), dx, dy, color));
    }
}
