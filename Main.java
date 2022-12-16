import java.awt.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        MainAnimation animation = new MainAnimation();
        for (int i = 1; i <= 24; i++) {
            for (int j = 1; j <= 12; j++) {
                Color color = new Color(i *  10, 0, 255);
                animation.addBall(10,  0, 0, (float) i / 2, (float) j / 2, color);
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
    
