import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.round;

public class Main {

    final static boolean DEBUG = false;
    final static float SPEED_MULTIPLIER = 0.4F;
    final static int BALL_RADIUS = 10;

    public static void main(String[] args) {
        MainAnimation animation = new MainAnimation();
        while (animation.getHeight() < 200 && animation.getWidth() < 200);
//        int width = (int) round(animation.getWidth() / 40.0);
//        int height = (int) round(animation.getHeight() / 40.0);
//        animation.setSize(animation.getWidth() - (animation.getWidth() % 40), animation.getHeight() - (animation.getHeight() % 40));
        int width = 24;
        int height = 12;
        for (int i = 1; i <= width; i++) {
            for (int j = 1; j <= height; j++) {
                Color color = new Color(i * 10, 0, 255);
                animation.addBall(BALL_RADIUS, 0, 0, (float) (i) * SPEED_MULTIPLIER,  (float) (j) * SPEED_MULTIPLIER, color);
            }
        }
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(animation::step, 5, 20, TimeUnit.MILLISECONDS);
    }
}
