package hu.uniobuda.nik.torpedo;

/**
 * Created by Papír Tigris on 2014.12.06..
 */
public class Pozicio {
    int x;
    int y;

    public Pozicio(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
