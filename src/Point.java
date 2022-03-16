import java.util.Random;

public class Point {

    private int type;
    private Point next;
    private boolean moved;
    private int speed;

    private final static double p = 0.2;
    private final static Random random = new Random();

    public void move() {
        if (!this.moved && this.type == 1)
        {
            if (speed > 0 && random.nextInt((int) (1 / p)) == 0)
                speed--;
            else
                // 5 is max speed
                speed = (speed + 1) % 6;

            Point current = this;
            for (int i = 0; i < speed; i++) {
                if (current.next.type == 1) {
                    speed = i;
                    break;
                }
                current = current.next;
            }

            this.type = 0;
            this.moved = true;
            current.moved = true;
            current.type = 1;
            current.speed = this.speed;
            this.speed = 0;
        }
    }

    public void clicked() {
        this.type = 1;
    }

    public void clear() {
        this.type = 0;
    }

    public void setNext(Point next) {
        this.next = next;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    public int getType() {
        return type;
    }
}

