import java.awt.*;

public class Main {

    final static boolean DEBUG = false;

    final static int WIDTH = 48;
    final static int HEIGHT = 24;
    final static float SPEED_MULTIPLIER = 0.25F;
    final static int BALL_RADIUS = 5;

    public static void main(String[] args) {
        MainAnimation animation = new MainAnimation();
        for (int i = 1; i <= WIDTH; i++) {
            for (int j = 1; j <= HEIGHT; j++) {
                Color color = new Color(i * 4, 0, 255);
                animation.addBall(BALL_RADIUS, 0, 0, (float) (i) * SPEED_MULTIPLIER,  (float) (j) * SPEED_MULTIPLIER, color);
            }
        }
        while (true) {
            animation.step();
            try {
                Thread.sleep(20);
            } catch (Exception e) {
                System.out.println("Something went wrong with the sleep command.");
                e.printStackTrace();
            }
        }
    }
}
