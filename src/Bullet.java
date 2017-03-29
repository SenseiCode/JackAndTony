import java.awt.*;

/**
 * Created by jackson_fletcher on 3/28/17.
 */
public class Bullet extends Sprite {

    public Bullet(int x, int y, int dir){
        super(x, y, dir);
    }

    public void drawBullet(Graphics2D g){
        Graphics2D g2 = (Graphics2D) g;
        g2.fillOval(500,500, 5,5);
    }

}


