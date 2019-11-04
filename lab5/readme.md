# Lab 5

- Proszę zaimplementować przy użyciu Executor i Future program wykonujący obliczanie zbioru Mandelbrota w puli wątków. Jako podstawę implementacji proszę wykorzystać kod w Javie.

```
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
 
public class Mandelbrot extends JFrame {
 
    private final int MAX_ITER = 570;
    private final double ZOOM = 150;
    private BufferedImage I;
    private double zx, zy, cX, cY, tmp;
 
    public Mandelbrot() {
        super("Mandelbrot Set");
        setBounds(100, 100, 800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                zx = zy = 0;
                cX = (x - 400) / ZOOM;
                cY = (y - 300) / ZOOM;
                int iter = MAX_ITER;
                while (zx * zx + zy * zy < 4 && iter > 0) {
                    tmp = zx * zx - zy * zy + cX;
                    zy = 2.0 * zx * zy + cY;
                    zx = tmp;
                    iter--;
                }
                I.setRGB(x, y, iter | (iter << 8));
            }
        }
    }
 
    @Override
    public void paint(Graphics g) {
        g.drawImage(I, 0, 0, this);
    }
 
    public static void main(String[] args) {
        new Mandelbrot().setVisible(true);
    }
}
```
Proszę przetestować szybkość działania programu w zależności od liczby wątków w pul:
- jeden wątek
- tyle samo watkow co rdzeni
- dwa razy wiecej wątkow niz rdzeni

oraz stosunku liczby zadań do liczby watkow w puli:

- tyle samo zadan co wątków,
- 10x wiecej zadan co wątków,
- każde zadanie to jeden piksel.

Czas obliczeń można zwiększać manipulując parametrami problemu, np. liczbą iteracji (MAX_ITER). Czas należy zmierzyć 10 razy dla tego samego przypadku, policzyć średnią i odchylenie standardowe. Wyniki przedstawic w tabelce, znaleźć najszybszą konfigurację.
