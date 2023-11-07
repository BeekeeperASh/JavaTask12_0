import java.awt.Color;
import java.awt.Graphics;

abstract class Shape {
    protected int x;
    protected int y;

    int width;
    int height;
    protected Color color;

    public Shape(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public abstract void draw(Graphics g);
}

class Oval extends Shape {
    public Oval(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x - width/2, y - height/2, width, height);
    }
}

class Rectangle extends Shape {
    public Rectangle(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x - width / 2, y - height / 2, width, height);
    }
}
