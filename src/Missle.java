import java.awt.*;

/**
 * Created by jackson_fletcher on 3/16/17.
 */
public class Missle {

    private int x, y;
    public Missle (int x, int y){
        this.x= x;
        this.y = y;

    }

    public void drawMissle(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.fillArc(x,y, 50,50,0,180);
    }



}
