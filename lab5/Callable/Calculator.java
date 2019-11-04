package lab5.Callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Calculator implements Callable<List<Pixel>> {
    private final int MAX_ITER = 570;
    private final double ZOOM = 150;
    private int index, length;
    private int width, height;

    public Calculator(int startPosition, int length, int width, int height){
        this.index = startPosition;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public List<Pixel> call(){
        List<Pixel> res = new ArrayList<>();
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
            res.add(new Pixel(index%width, index/width, iter));
            index++;
        }
        return res;
    }
}
