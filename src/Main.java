import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import static javax.swing.SwingConstants.EAST;
import static javax.swing.SwingConstants.WEST;

/**
 * Created by jackson_fletcher on 3/13/17.
 */
public class Main extends JPanel {
    public static final int FRAMEWIDTH = 800, FRAMEHEIGHT = 600;
    private Timer timer;
    private ArrayList<Sprite> helis;
    private ArrayList<Sprite> paras;
    private Sprite para;

    private int helitime = 0;

    public Main (){
        helis = new ArrayList<Sprite>();
        paras =new ArrayList<Sprite>();

        para = new parachuteman(30,30,EAST);


        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                //Ask the world if any sprites contain the click
//                Sprite.click(mouseEvent);

//                Bullet b = new Bullet(@Gun location)
//                b.setDirection( getDirection(gun.loc, mouseEvent.getPoint()));
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });

        timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                helitime++;

                if(helitime==45) {
                    helitime=0;
                    Helicopter heli = new Helicopter(0, 15, EAST);
                    helis.add(heli);
                }
//                if(helitime==30){
//                    helitime=0;
//                    parachuteman man = new parachuteman(0,0,WEST);
//                    paras.add(man);
//                }
//                for(Sprite h: paras)
//                    if(para.getLoc().y==400) {
//                        para.setSpeed(0);
//                    }
                for(Sprite i: helis) {
                    i.update();

                    if(Math.random() < .005){
                        parachuteman man = new parachuteman(i.getLoc().x, i.getLoc().y+10, Sprite.SOUTH);
                        paras.add(man);
                        if(i.getLoc().y>400)
                            i.setSpeed(0);

                    }
                }
                for(Sprite z: paras)

                    z.update();
                repaint();
            }
        });
        timer.start();

    }


    //This will call update on each sprite.


    public int getDirection(Point from, Point to){
        double dx = to.x - from.x;
        double dy = from.y - to.y;
        int deg =  (int)Math.toDegrees(Math.atan(dy/dx));
        if(to.x < from.x)
            deg += 180;
        return deg;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        Missle missle= new Missle(400,565);
        missle.drawMissle(g2);
        Muzzle muzzle = new Muzzle(400,565,400,565);
        muzzle.drawMuzzle(g2);

        for (Sprite s : helis) {
            s.draw(g2);

        }
        int counter= 0;
        for (Sprite q : paras) {
            q.draw(g2);
            if(q.getLoc().y>550){
                q.setSpeed(0);
                counter++;
            }
        }

        if(counter==0){
            g2.drawString("LIVES: 3", 700,100);
        }
        if(counter==1){
            g2.drawString("LIVES: 2", 700,100);
        }
        if(counter==2){
            g2.drawString("LIVES: 1", 700,100);
        }
    }


    public static void main(String[] args) {
        JFrame window = new JFrame("Paratrooper!!!");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, FRAMEWIDTH, FRAMEHEIGHT + 22); //(x, y, w, h) 22 due to title bar.

        Main panel = new Main();
        panel.setSize(FRAMEWIDTH, FRAMEHEIGHT);

        panel.setFocusable(true);
        panel.grabFocus();

        window.add(panel);
        window.setVisible(true);
        window.setResizable(false);
    }
}
