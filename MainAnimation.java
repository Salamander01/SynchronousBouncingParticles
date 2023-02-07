import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainAnimation extends JPanel {
    private final ArrayList<Ball> balls;

    public MainAnimation() {
        this.balls = new ArrayList<>();

        setBackground(Color.BLACK);

        JFrame frame = new JFrame("Main Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        frame.setResizable(true);

        frame.setContentPane(this);
        frame.setVisible(true);
    }

    public void step() {
        int width = getWidth();
        int height = getHeight();

        if (Main.DEBUG) System.out.println("Width: " + width + " : " + "Height: " + height);

        for (Ball ball : balls) {
            ball.step(width, height);
        }

        if (Main.DEBUG) System.out.println("\nBREAK!!");

        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball ball : balls) {
            g.setColor(ball.getColor());
            g.fillOval((int) (ball.getX() - ball.getRadius()), (int) (ball.getY() - ball.getRadius()), (int) ball.getDiameter(), (int) ball.getDiameter());
        }
    }

    public void addBall(float radius, float startX, float startY, float dx, float dy, Color color) {
        this.balls.add(new Ball(radius, startX, startY, dx, dy, color));
    }
}
