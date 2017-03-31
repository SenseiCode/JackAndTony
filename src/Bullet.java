import java.awt.*;

/**
 * Created by jackson_fletcher on 3/28/17.
 */
public class Bullet extends Sprite {

    public Bullet(int x, int y, int dir){
        super(x, y, dir);
        setDir(NORTH);
        setSpeed(0);
        setPic("imgres-1.png", WEST);
    }

   @Override
    public void update(){
        super.update();
    }


}


