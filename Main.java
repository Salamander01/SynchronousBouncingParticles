import java.awt.*;
import java.math.BigDecimal;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.round;

public class Main {

    final static boolean DEBUG = true;
    final static double SPEED_MULTIPLIER = 5F;
    final static int BALL_RADIUS = 10;

    public static void main(String[] args) {
        MainAnimation animation = new MainAnimation();
        while (animation.getHeight() < 200 && animation.getWidth() < 200);
        if (DEBUG)  System.out.println(animation.getWidth() + " x " + animation.getHeight());
        animation.setSize(animation.getWidth() - ((animation.getWidth() - BALL_RADIUS) % 40), animation.getHeight() - ((animation.getHeight() - BALL_RADIUS) % 40));
//        int width = (int) round((animation.getWidth()) / 40.0);
//        int height = (int) round((animation.getHeight()) / 40.0);
        int width = 1;
        int height = 1;
        if (DEBUG) {
            System.out.println(width + " x " + height);
            System.out.println(animation.getWidth() + " x " + animation.getHeight());
        }
        for (int i = 1; i <= width; i++) {
            for (int j = 1; j <= height; j++) {
                Color color = new Color(i * (i / 255), 0, 255);
                animation.addBall(BALL_RADIUS, new BigDecimal(i).multiply(new BigDecimal(SPEED_MULTIPLIER)),  new BigDecimal(j).multiply(new BigDecimal(SPEED_MULTIPLIER)), color);
            }
        }
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(animation::step, 5, 20, TimeUnit.MILLISECONDS);
    }
}
