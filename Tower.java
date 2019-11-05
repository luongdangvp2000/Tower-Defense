import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Tower {
    private int x, y, xB, yB, sp, scope, numberTower, dame;
    private boolean pX, pY, isInside = false;
    private int[] tPosX, tPosY;

    private List<towerEntity> towerList = new ArrayList<towerEntity>();

    public Tower(int x, int y){
        this.x = x;
        this.y = y;
        this.xB = x;
        this.yB = y;
        sp = 5;
        scope = 200;
        numberTower = 4;
        dame = 10;

        init();
    }

    public void init(){
        for(int i = 0; i < numberTower; ++i){
            towerEntity t1 = new towerEntity(450,150,200, 20);
        }
    }

    public void tick(double a, double b){

        //enermy inside tower's scope
        if(Math.abs(a-xB) <= scope && Math.abs(b-yB)<= scope)
            isInside = true;
        else{
            isInside = false;
        }
        if(isInside) {

            //check enermy in front or behind tower
            // pX == true if a-xB is positive else false

            if (a > xB)
                pX = true;
            else
                pX = false;
            if (b > yB)
                pY = true;
            else
                pY = false;

            if (pX)
                xB += sp;
            else
                xB -= sp;

            if (pY)
                yB += sp;
            else
                yB -= sp;

            //check if bullet collision with enermy

            if (xB >= a && pX) {
                xB = (int) a;
            }
            if (xB <= a && !pX)
                xB = (int) a;

            if (yB >= b+10 && pY)
                yB = (int) b;
            if (yB <= b-10 && !pY)
                yB = (int) b;

            // check if bullet throw outside of their scope

            if (xB > x + scope || yB > y + scope || xB <= 30 || yB <= 30 || (xB == (int) a && yB == (int) b)) {
                xB = x;
                yB = y;
            }
        } else {
            xB = x;
            yB = y;
        }

    }
    public void render(Graphics g){
        g.drawImage(Assets.t1,x,y,null);
        if(isInside) {
            g.drawImage(Assets.bullet, xB, yB, null);
            g.drawOval(x - 150, y - 150, 400, 400);
        }
    }

    public int getxB(){
        return xB;
    }
    public int getyB(){
        return yB;
    }
    public int getX(){return x;}
    public int getY(){return y;}

    public void resetXb(){
        xB = x;
    }
    public void restYb(){
        yB = y;
    }
    public int getDame(){
        return dame;
    }
}
