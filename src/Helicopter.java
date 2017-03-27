import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by tony_park on 3/16/17.
 */
public class Helicopter extends Sprite {

    public Helicopter(int x, int y, int dir) {
        super(x, y, dir);
        setSpeed(5);
        setPic("Helicopter.png", EAST);
    }
//    @Override
//    public void draw(Graphics2D g2){
//        super.draw(g2); //image
//    }

    @Override
    public void update(){
        super.update(); //move forward



    }


//    BufferedImage pic;
//    private int picOrientation;
//    public void setPic(String heli , int orientation) {
//        try {
//            pic = ImageIO.read(new File("res/" + "Helicopter1"));
//            picOrientation = orientation;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
