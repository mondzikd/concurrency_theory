package lab5.Callable;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Mandelbrot extends JFrame {
    private BufferedImage I;

    public Mandelbrot(int threads, int tasks) {
        super("Mandelbrot Set");
        setBounds(100, 100, 800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);


        if( getWidth()*getHeight() % tasks == 0 ) {
            for (int i = 0; i < 10; i++) {                                               // 10 measurements for each

                long startTime = System.currentTimeMillis();

                int pixelsNumber = getWidth() * getHeight();
                int pixelsForTask = pixelsNumber / tasks;
                int startingIndex = 0;

                ExecutorService executorService = Executors.newFixedThreadPool(threads);
                List<Future<List<Pixel>>> futures = new ArrayList<>();

                for (int t = 0; t < tasks; t++) {
                    Calculator calc = new Calculator(startingIndex, pixelsForTask, getWidth(), getHeight());
                    Future<List<Pixel>> res = executorService.submit(calc);
                    futures.add(res);
                    startingIndex += pixelsForTask;
                }

                for(Future<List<Pixel>> future : futures){
                    try{
                        List<Pixel> list = future.get();
                        while(!list.isEmpty()) {
                            Pixel p = list.remove(0);
                            I.setRGB(p.getX(), p.getY(), p.getIter()| (p.getIter() << 8));
                        }
                    }
                    catch (InterruptedException | ExecutionException e)
                    {
                        e.printStackTrace();
                    }
                }

                long stopTime = System.currentTimeMillis();
                long elapsedTime = stopTime - startTime;
                System.out.println(threads + " " + tasks + " " + elapsedTime);
            }
        }
        else {
            System.out.println(getWidth()*getHeight() + " pixels, " + tasks + " tasks. Change tasks number.");
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(I, 0, 0, this);
    }

    public static void main(String[] args) {
        new Mandelbrot(1, 1).setVisible(true);
        new Mandelbrot(2, 2).setVisible(true);
        new Mandelbrot(4, 4).setVisible(true);
        new Mandelbrot(8, 8).setVisible(true);


        new Mandelbrot(1, 10).setVisible(true);
        new Mandelbrot(2, 20).setVisible(true);
        new Mandelbrot(4, 40).setVisible(true);
        new Mandelbrot(8, 80).setVisible(true);


        new Mandelbrot(1, 480000).setVisible(true);
        new Mandelbrot(2, 480000).setVisible(true);
        new Mandelbrot(4, 480000).setVisible(true);
        new Mandelbrot(8, 480000).setVisible(true);
    }
}