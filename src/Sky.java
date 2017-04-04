import java.awt.*;

/**
 * Created by tony_park on 4/4/17.
 */
public class Sky {
    private int x, y, width, height;

    public Sky(int ex, int why, int w, int h) {

        x = ex;
        y = why;
        width = w;
        height = h;
    }

    public void drawSky(Graphics2D g2) {
        //sky
        Color top = new Color(91, 216, 210);
        Color bottom = new Color(13, 84, 196);
        Paint origPaint = g2.getPaint();
        GradientPaint topBottom = new GradientPaint(x, y, top, x, height, bottom);
        g2.setPaint(topBottom);
        g2.fillRect(0, 0, width, height);
        g2.setPaint(origPaint);
        //grass
        Color grass = new Color(14, 163, 12);
        g2.setColor(grass);
        g2.fillRect(0, 510, 800,10);
        //sand
        Color up = new Color(125, 125, 114);
        Color down = new Color(198, 211, 193);
        Paint sandPaint = g2.getPaint();
        GradientPaint upDown = new GradientPaint(x, y, up, x, height, down);
        g2.setPaint(upDown);
        g2.fillRect(x, y + 520, width, height);
        g2.setPaint(sandPaint);

    }
}

