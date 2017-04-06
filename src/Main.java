import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import static javax.swing.SwingConstants.EAST;
import static javax.swing.SwingConstants.NORTH;
import static javax.swing.SwingConstants.WEST;

/**
 * Created by jackson_fletcher on 3/13/17.
 */
public class Main extends JPanel {
    public static final int FRAMEWIDTH = 800, FRAMEHEIGHT = 600;
    private Timer timer;
    private ArrayList<Sprite> helis;
    private ArrayList<Sprite> paras;
    private ArrayList<Sprite> bullets;
    private Sprite para;
    private Muzzle muzzle;
    private Missle missle;
    private int points;
    private int point;

    private int helitime = 0;

    public Main (){
        helis = new ArrayList<Sprite>();
        paras =new ArrayList<Sprite>();
        bullets = new ArrayList<Sprite>();
        muzzle = new Muzzle(405,550,425,540);
        para = new parachuteman(30,30,EAST);
        missle=new Missle(400,565);
        points=10;
        point=0;


        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                //Ask the world if any sprites contain the click
//                Sprite.click(mouseEvent);
                muzzle = new Muzzle(425,540,425,540);
                    Bullet b = new Bullet(muzzle.getLoc().x, muzzle.getLoc().y, muzzle.getDir());
                bullets.add(b);
//                Bullet b = new Bullet(@Gun location)
                b.setDir(getDirection(muzzle.getLoc(), mouseEvent.getPoint()));
                b.setSpeed(10);
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

                for(Sprite b: bullets){
                    b.update();

                    for(Sprite p: paras){
                        if(p.intersects(b)==true && p.getLoc().y<550){
                            p.setDir(EAST);
                            p.setSpeed(1000000);
                            point++;


                        }
                        if (p.getLoc().x>800){
                            p.setSpeed(0);
                        }
                        if (points==0){
                            p.setSpeed(0);
                        }

                    }
                    for(Sprite h: helis){
                        if(h.intersects(b)==true){
                            h.setDir(EAST);
                            h.setSpeed(1000000);
                            point++;


                        }
                        if (h.getLoc().x>800){
                            h.setSpeed(0);
                        }
                        if(points==0){
                            h.setSpeed(0);
                        }
                    }


                }
                for(Sprite i: helis) {
                    i.update();

                    if(Math.random() < .005){
                        parachuteman man = new parachuteman(i.getLoc().x, i.getLoc().y+10, Sprite.SOUTH);
                        paras.add(man);


                    }
                }
                for(Sprite z: paras) {

                    z.update();
                    if(z.getLoc().y>550 && z.getSpeed() !=0 && z.getLoc().x>0 && z.getLoc().x<800){
                        z.setSpeed(0);
                        points--;

                    }
                }

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


        Sky yee = new Sky(0,0,getWidth(),800);
        yee.drawSky(g2);
//        Missle missle= new Missle(400,565);
        g2.setColor(Color.BLACK);
        missle.drawMissle(g2);
//        Muzzle muzzle = new Muzzle(405,550,425,540);
        muzzle.drawMuzzle(g2);
//        Bullet bullet = new Bullet(muzzle.getLoc().x,muzzle.getLoc().y, NORTH);
//        bullet.drawBullet(g2);
        for (Sprite b: bullets){
            b.draw(g2);
        }
        for (Sprite s : helis) {
            s.draw(g2);

        }

        for (Sprite q : paras) {
            q.draw(g2);

        }

        if (points==0){
            g2.setColor(Color.black);
            g2.fillRect(0,0,800,800);
            g2.setColor(Color.white);
            g2.drawString("FINAL SCORE:" + point, 300, 400 );
        }


                g2.drawString("LIVES:" + points, 650,100);
                g2.drawString("SCORE:" + point, 650,150);







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
