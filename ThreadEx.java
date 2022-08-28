import java.awt.Graphics;
import java.awt.Color;
import java.util.*;

import javax.swing.JFrame;

public class ThreadEx extends JFrame{
    //!! Thread t, t1, t2;

    int xx = new Random().nextInt(800);
    int yy = new Random().nextInt(80);

    int j = 10;
    int i = 10;
    boolean exe = false;

    public ThreadEx() {
        setSize(1000,800); // Define tamanho do frame
        setVisible(true); // Torna o frame visivel
        setTitle("aaa"); // Definindo título pra janela 
        setLocationRelativeTo(null); // Definindo a posição da janela no centro da tela 
        setResizable(false); // Bloqueado maximização e customização de tamanho
        setVisible(true);

        showNotify();
    }

    public void showNotify(){
        exe = true;
        new Thread(t).start();
        new Thread(t1).start();
        new Thread(t2).start();
    }
           
    public void hideNotify(){
        exe = false;
        t = null;
        t1 = null;
        t2 = null;
    }      

    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        // posiçao x e y // tamanho x e y
        g.setColor(Color.blue);
        
        g.fillOval(xx,yy,100,80);
        // g.drawRect(50, 50, i, i);
        // g.drawLine(2*i, 3*i, i, 3*i);
        // int [] starx = {50+xx, 100+xx, xx-25, 125+xx, xx};
        // int [] stary = {yy, 150+yy, 50+yy, 50+yy, 150+yy};
        // g.setColor(Color.red);
        // g.drawRect(100, 100, i, i);
        // g.setColor(Color.pink);
        // g.drawLine(400+i, 300+i, i, i);
        //g.drawPolygon(starx, stary, 5);
    }

    public Runnable t = new Runnable() {
        public void run() {
            runtherandom();
        }
    };

    public Runnable t1 = new Runnable() {
        public void run() {
            //runtherandom();
        }
    };
    
    public Runnable t2 = new Runnable() {
        public void run() {
            //runtherandom();
        }
    };

    public void runtherandom(){
        while(exe){
            int xa = new Random().nextInt(20,50);
            int yb = new Random().nextInt(20,50);
            int xc = new Random().nextInt(30,50);
            int yd = new Random().nextInt(1,80);

            while (!(yy>(getHeight()-80)||xx>(getWidth()-110))){
                xx+=xa;
                yy+=yb;
                trycatch();
            }
            while (!(yy<=30||xx<=20)){
                xx-=xc;
                yy-=yd;
                trycatch();
            }
            while ((yy>(getHeight()-80)||xx>(getWidth()-110))&&(yy<=30||xx<=20)){
                xx+=xc+xa;
                yy-=yd+yb;
                trycatch();
            }

        }
    }

    public void trycatch(){
        try{
            Thread.sleep(40);
        }catch(Exception e){Thread.currentThread().interrupt();}
        repaint();
    }
        

    public static void main(String [] args){
        ThreadEx d = new ThreadEx();
        d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
