import java.awt.*;

public class Main {

    public static void main(String[] args) {
        MainAnimation animation = new MainAnimation();
        for (int i = 1; i <= 12; i++) {
            for (int j = 1; j <= 6; j++) {
                Color color = new Color(i * 10, 0, 255);
                animation.addBall(10, 0, 0, (float) (i),  (float) (j), color);
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
