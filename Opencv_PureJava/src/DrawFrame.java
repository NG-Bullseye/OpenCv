import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class DrawFrame extends JFrame {

    private int hight;
    private int width;
    private int x;
    private double y;
    private double gamma=0.5;

    public DrawFrame(int hight,int width){
        super();
        this.hight=hight;
        this.width=width;
        x=width;
        y=hight;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void paint(Graphics g){
        //g.drawLine(0,hight,x,hight-y);
        //System.out.println("x="+x+" y="+y);
        double deltat=1;
        double kMinus1=0;
        double yMinus1=0;
        double yKurve=0;
        //for(double k = 0; yKurve <=hight;){
        for(double k = 0; k<=width;){

                //nextLine(t,k);
            yKurve =Math.pow(k/width,gamma)*hight;

            Graphics2D g2 = (Graphics2D) g;
            //Line2D lin = new Line2D.Float((float) kMinus1,(float)(hight-yMinus1),(float)k,(float)y);
            Line2D lin2 = new Line2D.Float((float) kMinus1,(float)(hight-yMinus1),(float)k,(float)(hight- yKurve));
            g2.draw(lin2);
            kMinus1=k;
            yMinus1= yKurve;
            k=k+deltat;
            //{
            //Thread.sleep(300);
            //tch (InterruptedException e) {
            //e.printStackTrace();
            //
        }
        this.repaint();
        //System.out.println("ready");
    }

    private void nextLine(double t, double k) {

    }

    public void setGamma(double gamma){
        this.gamma=gamma;
    }
}
