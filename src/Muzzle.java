import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by jackson_fletcher on 3/21/17.
 */
public class Muzzle extends Sprite{

    private int xa, ya;
    public Muzzle(int x,int y, int xa,  int ya){
        super(x,y, EAST);

        this.xa= xa;
        this.ya=ya;

    }


    public void drawMuzzle(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        g2.fillRect(xa,ya, 1,1);
        g2.setColor(Color.BLACK);
    }




}
