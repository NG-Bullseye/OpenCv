import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.*;
import org.opencv.imgcodecs.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main  {
    static {System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}

    public static void main(String args[]){
        new Main();
    }

    final  int  WIDTH=2048/2;
    final  int  HEIGHT=1536/2;
    public Main() {
        System.out.println(Core.VERSION);
        String imgpath="src/recources/ThomasKevinLeo.JPEG";
        Mat image= loadImage(imgpath);
        Mat color_img=image.clone();

        DrawFrame myFrame = new DrawFrame(WIDTH,HEIGHT);
        JLabel myLabel = new JLabel();
        myLabel.setText("Test");
        myFrame.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        myFrame.pack();
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);

        ImageWindow window = new ImageWindow("Image", image);
        window.setFrameLabelVisible(myFrame, myLabel);

        myFrame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                double x2=0;
                double y2=0;
                double gamma;
                System.out.println("Mouse Event: " + e.getPoint().toString());
                x2=e.getX();
                y2=HEIGHT- e.getY();
                gamma=Math.log(y2/HEIGHT)/Math.log(x2/WIDTH);

                System.out.println("hi handsome");
                System.out.println("x="+x2+" y="+y2+ "gamma "+gamma);
                //myLabel.setText("x0="+x0+" y0="+y0);
                myFrame.setGamma(gamma);
               // window.setFrameLabelVisible(myFrame, myLabel);
                System.out.println("ready");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        //HighGui.namedWindow("GreyCurve");
        //HighGui.namedWindow("Picture");
        //HighGui.imshow("Picture",color_img);
/*System.out.println("Test");
        Mat mapCurveImage512= new Mat();
        mapCurveImage512.create(512,512, CvType.CV_8U);
        HighGui.imshow("GreyCurve",mapCurveImage512);**/
        //Mat mapCurveImage512= new Mat();
        //mapCurveImage512.create(512,512, CvType.CV_8U);
        //MyHighGui.imshow("GreyCurve",mapCurveImage512);
        //HighGui.waitKey(30);


    }

    private static Mat loadImage(String imgpath) {
        return Imgcodecs.imread(imgpath);
    }

    private static boolean saveImage(Mat imageMatrix,String imgpath) {
        return Imgcodecs.imwrite(imgpath,imageMatrix);
    }

}
