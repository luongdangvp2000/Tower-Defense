import java.awt.*;
import java.awt.geom.Ellipse2D;

public class drawElip {
    Ellipse2D e ;
    private int x,y,r;
    public drawElip(Graphics g, int x, int y, int r){
        Graphics2D g1 = (Graphics2D) g;
        e = new Ellipse2D.Double(x,y,r,r);
        g1.draw(e);
    }
}
