package lab5.Callable;

public class Pixel {
    private int x, y;
    private int iter;

    public Pixel(int x, int y, int iter){
        this.x = x;
        this.y = y;
        this.iter = iter;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getIter() {
        return iter;
    }
}
