package lab5.Runnable;

import java.util.concurrent.CountDownLatch;

public class Calculator implements Runnable{
    private final int MAX_ITER = 2000;
    private final double ZOOM = 150;
    private int index, length;
    private int width, height;
    private Mandelbrot mandelbrot;
    private CountDownLatch latch;

    public Calculator(int startPosition, int length, Mandelbrot mandelbrot, CountDownLatch latch){
        this.index = startPosition;
        this.length = length;
        this.mandelbrot = mandelbrot;
        this.width = mandelbrot.getWidth();
        this.height = mandelbrot.getHeight();
        this.latch = latch;
    }

    public void run(){
        for(int i = 0; i < length; i++) {
            double zx = 0;
            double zy = 0;
            double cX = (index%width - 400) / ZOOM;
            double cY = (index/width - 300) / ZOOM;
            double tmp;
            int iter = MAX_ITER;
            while (zx * zx + zy * zy < 4 && iter > 0) {
                tmp = zx * zx - zy * zy + cX;
                zy = 2.0 * zx * zy + cY;
                zx = tmp;
                iter--;
            }
            try {
                mandelbrot.setImage(index%width, index/width, iter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            index++;
        }
        latch.countDown();
    }
}
