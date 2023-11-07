import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.abs;

public class RandomShapesApp extends JFrame {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    //private final ArrayList<Shape> shapes;

    public RandomShapesApp() {
        setTitle("Random Shapes");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //shapes = generateRandomShapes();

        setVisible(true);
    }

    private ArrayList<Shape> generateRandomShapes() {
        ArrayList<Shape> shapes = new ArrayList<>();
        Random random = new Random();
        int flag = 0;
        int width = 0, height = 0, x = 0, y = 0;
        while (true){
            do {
                if (flag > 10000000) break;
                flag++;
                width = random.nextInt(10) + 5;
                height = random.nextInt(10) + 5;
                x = random.nextInt(WIDTH - width * 2) + width;
                y = random.nextInt(HEIGHT - height * 3) + height + 20;
            } while (intersectsWithOtherShapes(x, y, width, height, shapes));
            if (flag > 10000000) break;
            flag = 0;
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            if (random.nextBoolean()) {
                shapes.add(new Oval(x, y, width, height, color));

            } else {
                shapes.add(new Rectangle(x, y, width, height, color));
            }
        }
        return shapes;
    }

    private boolean intersectsWithOtherShapes(int x, int y, int width, int height, ArrayList<Shape> shapes) {
        for (int j = 0; j < shapes.size(); j++){
            boolean xOverlap = abs(x - shapes.get(j).x) < (width/2 + shapes.get(j).width/2);
            boolean yOverlap = abs(y - shapes.get(j).y) < (height/2 + shapes.get(j).height/2);
            if (xOverlap && yOverlap){
                return true;
            }
        }
        return false;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Rectangle rectangle = new Rectangle(100, 100, 100, 100, Color.BLACK);
        Oval oval = new Oval(100, 200, 100, 100, Color.BLACK);
        //rectangle.draw(g);
        //oval.draw(g);
        Scanner scanner = new Scanner(System.in);
        ArrayList<Shape> shapes = new ArrayList<>();
        //shapes.add(rectangle);
        System.out.println(intersectsWithOtherShapes(100, 200, 100, 100, shapes));
        Random random = new Random();
        int flag = 0;
        int width = 0, height = 0, x = 0, y = 0;
        while (true){
            do {
                flag++;
                width = random.nextInt(100) + 10;
                height = random.nextInt(100) + 10;
                x = random.nextInt(WIDTH - width * 3) + width + 8;
                y = random.nextInt(HEIGHT - height * 3 - 32) + height + 32;
            } while (intersectsWithOtherShapes(x, y, width, height, shapes));
            flag = 0;
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            if (random.nextBoolean()) {
                shapes.add(new Oval(x, y, width, height, color));
                shapes.get(shapes.size()-1).draw(g);
            } else {
                shapes.add(new Rectangle(x, y, width, height, color));
                shapes.get(shapes.size()-1).draw(g);
            }
            //System.out.println(shapes);
            //scanner.next();
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RandomShapesApp());
    }
}
