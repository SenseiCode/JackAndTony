import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

    private int helitime = 0;

    public Main (){
        helis = new ArrayList<Sprite>();
        paras =new ArrayList<Sprite>();


        timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                helitime++;

                if(helitime==45) {
                    helitime=0;
                    Helicopter heli = new Helicopter(15, 15, EAST);
                    helis.add(heli);
                }
                if(helitime==30){
                    helitime=0;
                    parachuteman man = new parachuteman(0,0,WEST);
                    paras.add(man);
                }
                for(Sprite i: helis)
                    i.update();
                for(Sprite z: paras)
                    z.update();
                repaint();
            }
        });
        timer.start();

    }


            //This will call update on each sprite.




    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for (Sprite s : helis) {
            s.draw(g2);

        }
        for (Sprite q : paras) {
            q.draw(g2);
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
